package main;

import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import modelo.Financiamento;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int escolhaTipoFinanciamento;
        do {
            System.out.println("Escolha o tipo de financiamento:");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");

            escolhaTipoFinanciamento = scanner.nextInt();

            switch (escolhaTipoFinanciamento) {
                case 1:
                    double valorImovelCasa = interfaceUsuario.pedirValorImovel();
                    int prazoFinanciamentoCasa = interfaceUsuario.pedirPrazoFinanciamento();
                    double taxaJurosAnualCasa = interfaceUsuario.pedirTaxaJuros();
                    double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                    double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
                    financiamentos.add(new Casa(valorImovelCasa, prazoFinanciamentoCasa, taxaJurosAnualCasa, areaConstruida, tamanhoTerreno));
                    break;
                case 2:
                    double valorImovelApartamento = interfaceUsuario.pedirValorImovel();
                    int prazoFinanciamentoApartamento = interfaceUsuario.pedirPrazoFinanciamento();
                    double taxaJurosAnualApartamento = interfaceUsuario.pedirTaxaJuros();
                    int numVagasGaragem = interfaceUsuario.pedirNumVagasGaragem();
                    int numAndar = interfaceUsuario.pedirNumAndar();
                    financiamentos.add(new Apartamento(valorImovelApartamento, prazoFinanciamentoApartamento, taxaJurosAnualApartamento, numVagasGaragem, numAndar));
                    break;
                case 3:
                    double valorImovelTerreno = interfaceUsuario.pedirValorImovel();
                    int prazoFinanciamentoTerreno = interfaceUsuario.pedirPrazoFinanciamento();
                    double taxaJurosAnualTerreno = interfaceUsuario.pedirTaxaJuros();
                    String tipoZona = interfaceUsuario.pedirTipoZona();
                    financiamentos.add(new Terreno(valorImovelTerreno, prazoFinanciamentoTerreno, taxaJurosAnualTerreno, tipoZona));
                    break;
                default:
                    System.out.println("Escolha inválida de financiamento. Tente novamente.");
            }
        } while (escolhaTipoFinanciamento < 1 || escolhaTipoFinanciamento > 3);

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.calcularTotalPagamento();

            System.out.println("Financiamento " + (i + 1) + " - Valor do Imóvel: R$ " + financiamento.getValorImovel() +
                    ", Valor do Financiamento: R$ " + financiamento.calcularTotalPagamento() +
                    ", Prazo do Financiamento: " + financiamento.getPrazoFinanciamento() + " anos" +
                    ", Taxa de Juros Anual: " + (financiamento.getTaxaJurosAnual() * 100) + "%" +
                    (financiamento instanceof Apartamento ? ", Número de Vagas na Garagem: " + ((Apartamento) financiamento).getNumVagasGaragem() : "") +
                    (financiamento instanceof Apartamento ? ", Número de Andares: " + ((Apartamento) financiamento).getNumAndar() : "") +
                    (financiamento instanceof Terreno ? ", Tipo de Zona: " + ((Terreno) financiamento).getTipoZona() : ""));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("financiamentos.txt"))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.toFileString());
                writer.newLine();
            }
            System.out.println("Dados dos financiamentos foram salvos em 'financiamentos.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            outputStream.writeObject(financiamentos);
            System.out.println("Dados dos financiamentos foram serializados e salvos em 'financiamentos.ser'.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("financiamentos.ser"))) {
            ArrayList<Financiamento> financiamentosLidos = (ArrayList<Financiamento>) inputStream.readObject();
            System.out.println("Dados dos financiamentos foram lidos de 'financiamentos.ser'.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
