package cinedevsoftware;

import java.util.Scanner;

public class CineDevSoftware {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        //Instancia um objeto da classe cinema com 10 fileiras e 20 assentos pro fileiras
        Cinema cinema = new Cinema(10, 20);
        int opcao;
        //Loop principal
        do {
            System.out.println("\n===== CineDev =====");
            System.out.println("1 - Exibir Mapa de Assentos");
            System.out.println("2 - Comprar Ingresso");
            System.out.println("3 - Cancelar Ingresso");
            System.out.println("4 - Exibir Relatório de Ocupação");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            //Estrutura para executar a opção escolhida
            switch (opcao) {
                case 1:
                    cinema.exibirMapa();
                    break;
                case 2:
                    System.out.print("Digite a fileira (1-10): ");
                    int f = scanner.nextInt();
                    System.out.print("Digite o assento (1-20): ");
                    int a = scanner.nextInt();
                    cinema.comprarIngresso(f, a);
                    break;
                case 3:
                    System.out.print("Digite a fileira (1-10): ");
                    f = scanner.nextInt();
                    System.out.print("Digite o assento (1-20): ");
                    a = scanner.nextInt();
                    cinema.cancelarCompra(f, a);
                    break;
                case 4:
                    cinema.exibirRelatorio();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("️ Opção inválida!");
            }
        } while (opcao != 0); // O loop continua enquanto a opção não for 0 (Sair).

    }
}

