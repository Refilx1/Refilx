package PBL_Aprender;

public interface Alimento {
    double calcularAlimento();
    
    default void comer(){
        System.out.println("Comendo");
    }

}
