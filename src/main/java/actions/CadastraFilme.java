package actions;

import exceptions.FilmeJaCadastradoExecption;
import sistema.CategoriaFilme;
import sistema.SistemaFilmeGUI;
import sistema.SistemaFilmeInterface;
import sistema.SistemaFilmeMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastraFilme implements ActionListener{
    SistemaFilmeGUI screen;
    SistemaFilmeInterface sistemaFilmeMap;
    public CadastraFilme(SistemaFilmeGUI screen, SistemaFilmeMap sistemaFilmeMap) {
        this.screen = screen;
        this.sistemaFilmeMap = sistemaFilmeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
           String codigo = JOptionPane.showInputDialog("digite o codigo do filme");
           String nome = JOptionPane.showInputDialog("digite o nome do filme");
           int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("digite  o ano de lançamento do filme"));
           int duracao = Integer.parseInt(JOptionPane.showInputDialog("digite a duração do filme"));


           List<CategoriaFilme> categorias = new ArrayList<>();
           int continuar = 0;

            while(continuar == JOptionPane.YES_OPTION){
                CategoriaFilme categoria = null;
                CategoriaFilme[] options = {
                        CategoriaFilme.ACAO,
                        CategoriaFilme.ROMANCE,
                        CategoriaFilme.TERROR,
                        CategoriaFilme.COMEDIA,
                        CategoriaFilme.DRAMA
                };// podemos adicionar novas categorias aqui

                Object categoriaEscolha = JOptionPane.showInputDialog(null, null, "escolha uma categoria para o filme",
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                for (CategoriaFilme escolha : options) {
                    if (escolha.equals(categoriaEscolha)) {
                        categoria = escolha;
                        categorias.add(categoria);
                    }
                }

                continuar = JOptionPane.showConfirmDialog(null,"deseja adicionar mais alguma categoria?","atenção",JOptionPane.YES_NO_OPTION);
            }



            sistemaFilmeMap.cadastrarFilme(codigo,nome,anoLancamento,duracao,categorias);
        } catch (FilmeJaCadastradoExecption ex) {
            JOptionPane.showMessageDialog(null,"filme já cadastrado");
        }
    }
}
