

public abstract class Funcionario {
    private double salarioBase;
    public Funcionario(double salarioBase) {
    this.salarioBase = salarioBase;
    }
    public double salarioMensal() {
    double total = salarioBase + gratificacao();
    return total;
    }
    protected abstract double gratificacao();
   }
   