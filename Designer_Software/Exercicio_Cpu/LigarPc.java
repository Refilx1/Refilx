package Designer_Software.Exercicio_Cpu;

public class LigarPc {
    public void ligar(){
        Cpu cpu = new Cpu();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
        
        cpu.start();
        memory.start();
        memory.load();
        hardDrive.start();
        hardDrive.read();
        memory.finish();
    }
}
