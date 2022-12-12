package actions;

import sistema.Gravador;
import sistema.SistemaFilmeGUI;
import sistema.SistemaFilmeMap;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fechar extends WindowAdapter {
    SistemaFilmeGUI screen;
    SistemaFilmeMap sistema;
    public Fechar(SistemaFilmeGUI screen, SistemaFilmeMap sistemaFilmeMap) {
        this.screen = screen;
        this.sistema = sistemaFilmeMap;
    }
    @Override
    public void windowClosing(WindowEvent e) {
        Gravador test = new Gravador(sistema);
        int option = JOptionPane.showConfirmDialog(null,"tem certeza que quer sair","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            test.salvarLista();
            System.exit(0);
        }


    }
}
