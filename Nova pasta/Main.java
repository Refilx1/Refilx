public class Main {
    private Forma[] formas = {
        new Retangulo(2, 5, "Preto"),
        new Retangulo(3, 1, "Branco"),
        new Circulo(4, "Azul"),
        new Circulo(5, "Vermelho")
    };

    private void imprimir(Forma f) {
        System.out.println("Cor: " + f.getCor());
        System.out.println("Area: " + f.getArea());
        System.out.println("Perímetro: " + f.getPerimetro());
    }

    public void run() {
        System.out.println("FORMAS GEOMÉTRICAS: ");
        System.out.println();

        for (Forma f: formas) {
            imprimir(f);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}