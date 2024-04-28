package Aula5;

public class Conta {
    public int numConta;
    protected String tipoConta;
    private String dono;
    private double saldo;
    private boolean statusConta;



    public void abrirConta(double saldo, boolean statusConta ){
        setTipoConta(tipoConta);
        setStatusConta(statusConta);
        if (tipoConta == "cc"){
            this.saldo += 50;
        }
    }

    public void fecharConta(){

    }

    public void depositar(){
        
    }

    public void sacar(){

    }

    public void pagarMensal(){

    }



    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }



}
