package Desafio;
import java.util.Random;

class Hacker extends Thread {
    private static volatile boolean cofreAberto = false;
    private static volatile boolean policialChegou = false;
    private int hackerId;

    public Hacker(int hackerId) {
        this.hackerId = hackerId;
    }

    public void run() {
        int tentativa = 0;
        while (!cofreAberto && !policialChegou) {
            String tentativaSenha = gerarSenhaAleatoria();
            tentativa++;
            System.out.println("Hacker " + hackerId + " tentativa " + tentativa + ": " + tentativaSenha);
            if (tentativaSenha.equals("89")) {
                cofreAberto = true;
                System.out.println("Hacker " + hackerId + " abriu o cofre com a senha " + tentativaSenha + "!");
                policial.interrupt(); 
                break;
            }
            try {
                Thread.sleep(100); // Simulando tempo de tentativa
            } catch (InterruptedException e) {
                System.out.println("Hacker " + hackerId + " interrompido.");
                return; 
            }
        }
    }

    private String gerarSenhaAleatoria() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static void policialChegou() {
        policialChegou = true;
    }

    public static boolean isCofreAberto() {
        return cofreAberto;
    }

    // Adiciona uma referência à thread do policial
    private static Thread policial;

    public static void setPolicial(Thread policialThread) {
        policial = policialThread;
    }
}

class Policial extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("Policial chegará em " + i + " segundos.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Policial Não chegou a tempo");
                return;
            }
        }
        Hacker.policialChegou();
        if (!Hacker.isCofreAberto()) {
            System.out.println("Policial chegou e prendeu os hackers!");
            System.exit(0); // Encerra o programa
        } else {
            System.out.println("Policial chegou, mas os hackers já abriram o cofre.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Hacker hacker1 = new Hacker(1);
        Hacker hacker2 = new Hacker(2);
        Hacker hacker3 = new Hacker(3);
        Hacker hacker4 = new Hacker(4);
        Policial policial = new Policial();

        // Configura a referência à thread do policial
        Hacker.setPolicial(policial);

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
