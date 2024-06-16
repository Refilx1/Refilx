package Desafio;

public class Main {
    public static void main(String[] args) {
        Hacker hacker1 = new Hacker(1);
        Hacker hacker2 = new Hacker(2);
        Hacker hacker3 = new Hacker(3);
        Hacker hacker4 = new Hacker(4);
        Policial policial = new Policial();

        // Configura a referência à thread do policial
        Hacker.setPolicial(policial);
        // Logo a baixo está a quantidade de hackers que podem ser criados 
        hacker1.start();
        hacker2.start();
        hacker3.start();
        hacker4.start();
        policial.start();

        try {
            hacker1.join();
            hacker2.join();
            policial.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}