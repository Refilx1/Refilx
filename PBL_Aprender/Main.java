package PBL_Aprender;

public class Main {
    public static void main(String[] args) {
        
        Mamifero vaca = new Mamifero("Vaca", "4", 110);
        Mamifero gato = new Mamifero("gato", "5", 10);

        System.out.println("Nome do animal: " + vaca.getNome());
        double calcularQuantidadeLeiteVaca = vaca.calcularQuantidadeLeite();
        double calcularAlimentoVaca = vaca.calcularAlimento();
        System.out.println("Qtd de leite: " + calcularQuantidadeLeiteVaca);
        System.out.println("Qts de comida: " + calcularAlimentoVaca);
        vaca.comer();
        
        System.out.println("-------------------------------------------");

        System.out.println("Nome do animal: " + gato.getNome());
        double calcularQuantidadeLeiteGato = gato.calcularQuantidadeLeite();
        double calcularAlimentoGato = gato.calcularAlimento();
        System.out.println("Qtd de leite: " + calcularQuantidadeLeiteGato);
        System.out.println("Qts de comida: " + calcularAlimentoGato);
        gato.comer();

    }
}   
