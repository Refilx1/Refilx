package Atividade_9;

public class Versao1SemThread {

    public static void main(String[] args) {
        int inicio = 1;
        int fim = 1000000;

        long inicioExecucao = System.currentTimeMillis();
        contaPrimos(inicio, fim);
        long fimExecucao = System.currentTimeMillis();

        long tempoTotal = fimExecucao - inicioExecucao;
        System.out.println("Tempo total de execução: " + tempoTotal + " milissegundos");
    }

    private static void contaPrimos(int inicio, int fim) {
        for (int valor = inicio; valor <= fim; valor++) {
            if (ehPrimo(valor)) {
                System.out.println(valor);
            }
        }
    }

    private static boolean ehPrimo(int valor) {
        for (int d = 2; d < valor; d++) {
            if (valor % d == 0) {
                return false;
            }
        }
        return true;
    }
}
