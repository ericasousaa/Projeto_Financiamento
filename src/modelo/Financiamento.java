package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public abstract double calcularTotalPagamento();

    public abstract String toFileString();

    @Override
    public String toString() {
        return "Valor do Imóvel: " + valorImovel +
                ", Valor do Financiamento: " + calcularTotalPagamento() +
                ", Taxa de Juros Anual: " + taxaJurosAnual +
                ", Prazo de Financiamento: " + prazoFinanciamento + " anos";
    }
}
