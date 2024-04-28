package PBL_Aprender;


// Classe Mamifero que implementa a interface Leite
public class Mamifero extends Animal implements Leite, Alimento{
    protected double peso;
    protected String tamanho;

    protected Mamifero(String nome, String idade, double peso) {
        super(nome, idade);
        this.peso = peso;
        this.nome = nome;

    }


    protected String getNome(){
        return nome;
    }
    // Implementação do método da interface Leite
    @Override
    public double calcularQuantidadeLeite() {
        if (this.peso >30){
            System.out.println("bebendo leite");
           return peso / 3.0;
        }else{
            System.out.println("Não precisa de leite");
            return 0.0;
        }

    }

    @Override
    public double calcularAlimento(){
        return peso / 2.5;
    }
    // Outros métodos da classe Mamifero...

    public void tamanho(){
        
    }
}
