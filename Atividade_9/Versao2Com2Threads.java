package Atividade_9;

public class Versao2Com2Threads {

    public static void main(String[] args) {
        int inicio = 1;
        int fim = 1000000;

        long startTime = System.currentTimeMillis();

        ContaPrimosThread thread1 = new ContaPrimosThread(inicio, fim / 2);
        thread1.setName("T1");
        thread1.start();

        ContaPrimosThread thread2 = new ContaPrimosThread(fim / 2 + 1, fim);
        thread2.setName("T2");
        thread2.start();

        // Aguardando as threads terminarem
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tempo total de execução: " + totalTime + " milissegundos");
    }
}
