package actions;

import exceptions.FilmeNaoExisteExecption;
import sistema.Filme;
import sistema.SistemaFilmeGUI;
import sistema.SistemaFilmeInterface;
import sistema.SistemaFilmeMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ObterFilmesComNome implements ActionListener {

    SistemaFilmeGUI screen;
    SistemaFilmeInterface sistema;
    public ObterFilmesComNome(SistemaFilmeGUI screen, SistemaFilmeMap sistemaFilmeMap) {
        this.screen = screen;
        this.sistema = sistemaFilmeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nome = JOptionPane.showInputDialog(null,"digite o nome do filme a ser procurado.");
        try {
            List<Filme> filmes = sistema.obterFilmesComNome(nome);
            String filmesString = "";
            int quant = 0;

            for (Filme f : filmes) {
                quant++;
                filmesString = filmesString.concat("\n"+"filme numero "+quant+"\n"+"\n"+f + "," + "\n");
            }
            if(quant == 1){
                JOptionPane.showMessageDialog(null,"foi encontrado este filme:" + "\n" + filmesString);
            }else {
                JOptionPane.showMessageDialog(null, "foram encontrados estes filmes:" + "\n" + filmesString);
            }
        }catch(FilmeNaoExisteExecption ex){
            JOptionPane.showMessageDialog(null,"não foi encontrado nenhum filme cadastrado com este nome");
        }
    }
}
