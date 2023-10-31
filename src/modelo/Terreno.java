package modelo;

import modelo.Financiamento;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int meses = getPrazoFinanciamento() * 12;
        double pagamentoMensalSemAcrecimo = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -meses));
        double pagamentoMensalComAcrecimo = pagamentoMensalSemAcrecimo * 1.02;
        return pagamentoMensalComAcrecimo;
    }


    @Override
    public double calcularTotalPagamento() {
        double pagamentoMensal = calcularPagamentoMensal();
        int meses = getPrazoFinanciamento() * 12;
        return pagamentoMensal * meses;
    }

    @Override
    public String toFileString() {
        return String.format("Terreno %.2f %d %.2f %s", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), tipoZona);
    }
}
