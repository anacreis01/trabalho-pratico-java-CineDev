
package cinedevsoftware;

public class Cinema {

        // Matriz que representa a sala de cinema (L = Livre, X = Ocupado)
        private char[][] sala; 
        private int fileiras;  // Quantidade de fileiras
        private int assentosPorFileira;  // Quantidade de assentos por fileira

        // Construtor - cria a sala com o número de fileiras e assentos
        public Cinema(int fileiras, int assentosPorFileira) {
            this.fileiras = fileiras;
            this.assentosPorFileira = assentosPorFileira;
            sala = new char[fileiras][assentosPorFileira]; // Cria a matriz da sala
            inicializarSala(); // Marca todos os assentos como livres
        }

        // Inicializa todos os assentos como livres ('L')
        private void inicializarSala() {
            for (int i = 0; i < fileiras; i++) {
                for (int j = 0; j < assentosPorFileira; j++) {
                    sala[i][j] = 'L'; // 'L' significa Livre
                }
            }
        }

        // Mostra o mapa de assentos da sala
        public void exibirMapa() {
            System.out.println("Assentos: 1 a " + assentosPorFileira);
            for (int i = 0; i < fileiras; i++) {
                System.out.print("Fileira " + (i + 1) + ": ");
                for (int j = 0; j < assentosPorFileira; j++) {
                    System.out.print("[" + sala[i][j] + "]"); // Exibe [L] ou [X]
                }
                System.out.println();
            }
        }

        // Compra de ingresso - marca um assento como ocupado ('X')
        public void comprarIngresso(int fileira, int assento) {
            // Verifica se a posição é válida
            if (fileira < 1 || fileira > fileiras || assento < 1 || assento > assentosPorFileira) {
                System.out.println("Posição inválida!");
                return;
            }

            // Verifica se o assento já está ocupado
            if (sala[fileira - 1][assento - 1] == 'X') {
                System.out.println("Assento já ocupado!");
            } else {
                sala[fileira - 1][assento - 1] = 'X'; // Marca como ocupado
                System.out.println("Compra realizada com sucesso!");
            }
        }

        // Cancelar a compra de um assento - volta para 'L'
        public void cancelarCompra(int fileira, int assento) {
            // Verifica se a posição é válida
            if (fileira < 1 || fileira > fileiras || assento < 1 || assento > assentosPorFileira) {
                System.out.println("Posição inválida!");
                return;
            }

            // Verifica se o assento já está livre
            if (sala[fileira - 1][assento - 1] == 'L') {
                System.out.println("Esse assento já está livre!");
            } else {
                sala[fileira - 1][assento - 1] = 'L'; // Marca como livre
                System.out.println("Compra cancelada com sucesso!");
            }
        }

        // Exibe relatório de ocupação da sala
        public void exibirRelatorio() {
            int total = fileiras * assentosPorFileira; // Total de lugares
            int ocupados = 0;
            int livres = 0;

            // Conta quantos assentos estão ocupados e livres
            for (int i = 0; i < fileiras; i++) {
                for (int j = 0; j < assentosPorFileira; j++) {
                    if (sala[i][j] == 'X') {
                        ocupados++;
                    } else {
                        livres++;
                    }
                }
            }

            // Calcula o percentual de ocupação
            double percentual = (ocupados * 100.0) / total;

            // Exibe relatório
            System.out.println("===== Relatório de Ocupação =====");
            System.out.println("Total de assentos: " + total);
            System.out.println("Assentos ocupados: " + ocupados);
            System.out.println("Assentos livres: " + livres);
            System.out.printf("Percentual de ocupação: %.2f%%\n", percentual);
        }

    }

