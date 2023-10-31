package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private int numVagasGaragem;
    private int numAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numVagasGaragem, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numVagasGaragem = numVagasGaragem;
        this.numAndar = numAndar;
    }

    public int getNumVagasGaragem() {
        return numVagasGaragem;
    }

    public int getNumAndar() {
        return numAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int meses = getPrazoFinanciamento() * 12;
        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -meses));
        return pagamentoMensal;
    }


    @Override
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }



    @Override
    public String toFileString() {
        return String.format("Apartamento %.2f %d %.2f %d %d %.2f", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), getNumVagasGaragem(), getNumAndar(), calcularTotalPagamento());
    }

}
