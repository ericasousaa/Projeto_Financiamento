package modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int meses = getPrazoFinanciamento() * 12;
        double pagamentoMensalSemSeguro = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -meses));
        double pagamentoMensalComSeguro = pagamentoMensalSemSeguro + 80;
        return pagamentoMensalComSeguro;
    }


    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }


    @Override
    public String toFileString() {
        return String.format("Casa %.2f %d %.2f %.2f", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), getAreaConstruida());
    }
}
