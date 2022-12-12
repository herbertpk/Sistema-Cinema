package sistema;

public class Main {
    public static void main(String[] args){
        SistemaFilmeMap sistemaFilmeMap = new SistemaFilmeMap();
        Recuperador rec = new Recuperador();
        new SistemaFilmeGUI(rec.recuperar(sistemaFilmeMap));
    }
}
