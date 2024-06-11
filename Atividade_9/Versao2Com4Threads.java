package Atividade_9;

public class Versao2Com4Threads {

    public static void main(String[] args) {
        int inicio = 1;
        int fim = 1000000;

        long startTime = System.currentTimeMillis();

        int metade = (inicio + fim) / 2;
        int quarto = (inicio + metade) / 2;

        ContaPrimosThread thread1 = new ContaPrimosThread(inicio, quarto);
        thread1.setName("T1");
        thread1.start();

        ContaPrimosThread thread2 = new ContaPrimosThread(quarto + 1, metade);
        thread2.setName("T2");
        thread2.start();

        ContaPrimosThread thread3 = new ContaPrimosThread(metade + 1, (metade + fim) / 2);
        thread3.setName("T3");
        thread3.start();

        ContaPrimosThread thread4 = new ContaPrimosThread((metade + fim) / 2 + 1, fim);
        thread4.setName("T4");
        thread4.start();

        // Aguardando as threads terminarem
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tempo total de execução: " + totalTime + " milissegundos");
    }
}
