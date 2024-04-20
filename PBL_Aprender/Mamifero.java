package PBL_Aprender;

class Mamifero extends Animal{
    public Mamifero(String nome, String idade){
        super(nome, idade);
    }

    public void leite(double leite){
        System.out.println(nome + " Alimenta com: " + leite + "Litros de leite");
    }

}
