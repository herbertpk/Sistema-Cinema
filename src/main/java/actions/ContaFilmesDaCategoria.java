package actions;

import sistema.CategoriaFilme;
import sistema.SistemaFilmeGUI;
import sistema.SistemaFilmeInterface;
import sistema.SistemaFilmeMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContaFilmesDaCategoria implements ActionListener {
    SistemaFilmeGUI screen;
    SistemaFilmeInterface sistema;
    public ContaFilmesDaCategoria(SistemaFilmeGUI screen, SistemaFilmeMap sistemaFilmeMap) {
        this.screen = screen;
        this.sistema = sistemaFilmeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoriaFilme categoria = null;
        CategoriaFilme[] options = {
                CategoriaFilme.ACAO,
                CategoriaFilme.ROMANCE,
                CategoriaFilme.TERROR,
                CategoriaFilme.COMEDIA,
                CategoriaFilme.DRAMA
        };// podemos adicionar novas categorias aqui


        Object categoriaEscolha =  JOptionPane.showInputDialog(null, null, "escolha uma categoria",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        for (CategoriaFilme escolha : options) {
            if (escolha.equals(categoriaEscolha)) {
                categoria = escolha;
            }
        }
        JOptionPane.showMessageDialog(null,"existe "+sistema.contaFilmesDaCategoria(categoria)+" filme desta categoria.");
    }
}
