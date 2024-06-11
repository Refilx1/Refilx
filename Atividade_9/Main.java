package Atividade_9;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Estamos na thread " + Thread.currentThread().getName());
            }
        });
        System.out.println("Estamos na thread " + Thread.currentThread().getName());
        thread.start();
        Thread.sleep(1000);
        System.out.println("Estamos na thread " + Thread.currentThread().getName());
    }
}
