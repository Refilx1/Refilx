package Atividade_9;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable(){
            public void run(){
                System.out.println("estamos na thread "+ Thread.currentThread().getName());
            }
        });
        System.out.println("estamos na thread "+ Thread.currentThread().getName());
        thread.start();
        Thread.sleep(1000);
        System.out.println("estamos na thread "+ Thread.currentThread().getName());
    }
}
