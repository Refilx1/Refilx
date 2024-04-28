package PBL_Aprender;


public interface Leite {
    double calcularQuantidadeLeite();

    default void beber(){
        System.out.println("Bebendo leite ainda");
    }
}
