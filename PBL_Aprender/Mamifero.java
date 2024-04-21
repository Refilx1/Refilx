package PBL_Aprender;


// Classe Mamifero que implementa a interface Leite
public class Mamifero extends Animal implements Leite, Alimento {
    private double peso;

    public Mamifero(String nome, String idade, double peso) {
        super(nome, idade);
        this.peso = peso;
    }

    // Implementação do método da interface Leite
    @Override
    public double calcularQuantidadeLeite() {
        // Retorna o peso do mamífero dividido por 3 para calcular a quantidade de leite
        return peso / 3.0;
    }

    @Override
    public double calcularAlimento(){
        return peso / 2.5;
    }
    // Outros métodos da classe Mamifero...
}
