package Desafio;
import java.util.Random;

class Hacker extends Thread {
    private static volatile boolean cofreAberto = false; 
    // A palavra-chave volatile é usada em programação multi-threading. Indica ao compilador e à JVM que o valor da variável cofreAberto pode ser alterado por múltiplas threads.
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
            if (tentativaSenha.equals("899")) { // aqui você coloca a senha do cofre
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
        // caso queira aumentar a quantidade de digitos da senha, basta aumentar o valor do for de 3 para o valor que você queira
        for (int i = 0; i < 3; i++) { 
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

    // Aqui vc adiciona a referencia do policial
    private static Thread policial;

    public static void setPolicial(Thread policialThread) {
        policial = policialThread;
    }
}


