package actions;

import exceptions.FilmeNaoExisteExecption;
import sistema.Filme;
import sistema.SistemaFilmeGUI;
import sistema.SistemaFilmeMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PesquisaFilmeCodigo implements ActionListener {
    SistemaFilmeGUI screen;
    SistemaFilmeMap sistemaFilmeMap;

    public PesquisaFilmeCodigo(SistemaFilmeGUI sistema, SistemaFilmeMap sistemaFilmeMap) {
        this.screen = sistema;
        this.sistemaFilmeMap = sistemaFilmeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog(null,"qual o codigo do filme a ser pesquisado");
        try {
            Filme filmeResultado = sistemaFilmeMap.pesquisaFilme(codigo);
            JOptionPane.showMessageDialog(null,filmeResultado);
        } catch (FilmeNaoExisteExecption ex) {
            JOptionPane.showMessageDialog(null,"não existe nenhum filme com este codigo: "+ codigo +" !");
        }

    }
}
