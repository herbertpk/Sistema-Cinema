package actions;

import sistema.Filme;
import sistema.SistemaFilmeInterface;
import sistema.SistemaFilmeMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;


public class PesquisaFilmeAno implements ActionListener {

    private SistemaFilmeInterface sistemaFilmeMap;

    public PesquisaFilmeAno(SistemaFilmeMap sistemaFilmeMap) {
        this.sistemaFilmeMap = sistemaFilmeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resultFilme ="";
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"qual o ano que deseja pesquisar"));
        List<Filme> filmes = sistemaFilmeMap.obterFilmesLancadosEm(ano);

        if(filmes.isEmpty()){
            JOptionPane.showMessageDialog(null,"não foi encontrado, nenhum filme cadastrado, que foi lançado no ano de "+ano);
        }else {
            int quant = 0;
            for (Filme f : filmes) {
                quant++;
                resultFilme = resultFilme.concat("\n"+"filme numero "+quant+"\n"+"\n"+f + "," + "\n");
            }
            if(quant == 1){
                JOptionPane.showMessageDialog(null,"foi encontrado este filme:" + "\n" + resultFilme);
            }else {
                JOptionPane.showMessageDialog(null, "foram encontrados estes filmes:" + "\n" + resultFilme);
            }
        }
    }
}
