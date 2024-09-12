package Designer_Software.Exercicio_Cpu;

public class DesligarPc {
    public void desligar(){
        Cpu cpu = new Cpu();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
        
        memory.start();
        memory.finish();
        hardDrive.finish();
        cpu.finish();
    }
}
