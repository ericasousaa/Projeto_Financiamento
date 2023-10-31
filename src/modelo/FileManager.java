package modelo;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void salvarFinanciamentosEmArquivoTexto(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                writer.println(financiamento.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> lerFinanciamentosDeArquivoTexto(String nomeArquivo) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }

    public static void salvarFinanciamentosSerializados(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> lerFinanciamentosSerializados(String nomeArquivo) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Object obj = inputStream.readObject();
            if (obj instanceof ArrayList) {
                financiamentos = (ArrayList<Financiamento>) obj;
            } else {
                System.out.println("O arquivo não contém uma lista de financiamentos.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }
}
