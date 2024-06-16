package Desafio;

class Policial extends Thread {
    public void run() {
        // no for você consegue colocar o tempo que o policial tem para chegar
        for (int i = 60; i > 0; i--) {
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
            System.exit(0); // Encerra o programa apos prender os hackers 
        } else {
            System.out.println("Policial chegou, mas os hackers já abriram o cofre.");
        }
    }
}
