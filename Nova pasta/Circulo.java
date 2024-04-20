public class Circulo extends Forma {
    private double raio;

    public Circulo(double raio, String cor) {
        super(cor);
        this.raio = raio;
    }

    public double getDiametro() {
        return 2 * raio;
    }

    @Override
    public double getArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * raio;
    }
}
