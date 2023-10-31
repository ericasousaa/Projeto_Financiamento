package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                double valor = scanner.nextDouble();
                if (valor <= 0) {
                    throw new IllegalArgumentException("Valor do imóvel deve ser positivo.");
                }
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean inputValido = false;
        while (!inputValido) {
            try {
                System.out.print("Digite o prazo do financiamento em anos: ");
                prazo = scanner.nextInt();
                if (prazo <= 0) {
                    throw new IllegalArgumentException("O prazo do financiamento deve ser positivo.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return prazo;
    }

    public double pedirTaxaJuros() {
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual: ");
                double taxa = scanner.nextDouble();
                if (taxa <= 0) {
                    throw new IllegalArgumentException("A taxa de juros deve ser positiva.");
                }
                return taxa;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double pedirAreaConstruida() {
        while (true) {
            try {
                System.out.print("Digite a área construída: ");
                double area = scanner.nextDouble();
                if (area <= 0) {
                    throw new IllegalArgumentException("A área construída deve ser positiva.");
                }
                return area;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double pedirTamanhoTerreno() {
        while (true) {
            try {
                System.out.print("Digite o tamanho do terreno: ");
                double tamanho = scanner.nextDouble();
                if (tamanho <= 0) {
                    throw new IllegalArgumentException("O tamanho do terreno deve ser positivo.");
                }
                return tamanho;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int pedirNumVagasGaragem() {
        while (true) {
            try {
                System.out.print("Digite o número de vagas na garagem: ");
                int numVagas = scanner.nextInt();
                if (numVagas < 1) {
                    throw new IllegalArgumentException("O número de vagas na garagem não pode ser negativo.");
                }
                return numVagas;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int pedirNumAndar() {
        while (true) {
            try {
                System.out.print("Digite o número de andares: ");
                int numAndares = scanner.nextInt();
                if (numAndares < 2) {
                    throw new IllegalArgumentException("O número de andares não pode ser negativo.");
                }
                return numAndares;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String pedirTipoZona() {
        while (true) {
            try {
                System.out.print("Digite o tipo de zona (residencial, comercial, industrial, etc.): ");
                String tipoZona = scanner.next();
                if (tipoZona.trim().isEmpty()) {
                    throw new IllegalArgumentException("O tipo de zona não pode estar vazio.");
                }
                return tipoZona;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite uma string.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int pedirTipoFinanciamento() {
        while (true) {
            try {
                System.out.println("Escolha o tipo de financiamento:");
                System.out.println("1 - Casa");
                System.out.println("2 - Apartamento");
                System.out.println("3 - Terreno");

                int escolhaTipoFinanciamento = scanner.nextInt();
                if (escolhaTipoFinanciamento < 1 || escolhaTipoFinanciamento > 3) {
                    throw new IllegalArgumentException("Escolha inválida de financiamento. Tente novamente.");
                }
                return escolhaTipoFinanciamento;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

