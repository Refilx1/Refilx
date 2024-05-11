package PBL_Aprender;


// Classe Mamifero que implementa as interfaces Leite e Alimento
public class Mamifero extends Animal implements Leite, Alimento {
    protected double peso;
    protected String tamanho;

    // Construtor da classe Mamifero
    protected Mamifero(String nome, String idade, double peso) {
        super(nome, idade); // Chamando o construtor da superclasse Animal
        this.peso = peso; // Inicializando o peso do mamífero
        this.nome = nome; // Inicializando o nome do mamífero
    }

    // Método para obter o nome do mamífero
    protected String getNome() {
        return nome;
    }

    // Implementação do método da interface Leite
    @Override
    public double calcularQuantidadeLeite() {
        if (this.peso > 30) { // Se o peso do mamífero for maior que 30
            System.out.println("bebendo leite"); // Exibe uma mensagem indicando que está bebendo leite
            return peso / 3.0; // Retorna a quantidade de leite produzida pelo mamífero
        } else { // Caso contrário
            System.out.println("Não precisa de leite"); // Exibe uma mensagem indicando que não precisa de leite
            return 0.0; // Retorna 0, pois o mamífero não precisa de leite
        }
    }

    // Implementação do método da interface Alimento
    @Override
    public double calcularAlimento() {
        return peso / 2.5; // Retorna a quantidade de alimento necessária para o mamífero
    }

    // Outros métodos da classe Mamifero...

    public void tamanho(){
        
    }
}
