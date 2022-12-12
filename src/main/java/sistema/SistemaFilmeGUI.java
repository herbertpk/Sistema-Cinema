package sistema;

import actions.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SistemaFilmeGUI extends JFrame  {
        SistemaFilmeInterface sistema;
public SistemaFilmeGUI(SistemaFilmeMap sistema){

    this.sistema = sistema;


    //Tela
    setTitle("Sistema Filmes");
    setSize(1280,720);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(NORMAL);
    this.setLayout(new BorderLayout(5,5));
    //Componente dentro da janela
    JPanel layout = new JPanel();
    layout.setLayout(new GridLayout(2,3));


    String barra = File.separator;
    String imagePath = "."+barra+"src"+barra+"main"+barra+"resources"+barra;
    //Botoes

    //Pesquisa
    ImageIcon pesquisaIcon = new ImageIcon(imagePath+"PESQUISA.jpg");
    JButton pesquisa = new JButton("Pesquisar", pesquisaIcon);
    pesquisa.setBounds(100, 100, 05, 05);

    pesquisa.setVisible(true);


    //Cadastro
    ImageIcon cadastraIcon = new ImageIcon(imagePath+"CADASTRAFILME.jpg");
    JButton cadastrar = new JButton("Cadastrar", cadastraIcon);
    cadastrar.setBounds(100, 100, 05, 05);
    cadastrar.setVisible(true);

    //obterFilmesLancadosEm
    ImageIcon obterFilmesLancadosEmIcon = new ImageIcon(imagePath+"OBTFILMESLANCADOSEM.jpg");
    JButton obterFilmesLancadosEm = new JButton("obterFilmesLancadosEm", obterFilmesLancadosEmIcon);

    obterFilmesLancadosEm.setBounds(100, 100, 05, 05);
    obterFilmesLancadosEm.setVisible(true);

    //obterFilmesComNome
    ImageIcon obterFilmesComnomeIcon = new ImageIcon(imagePath+"OBTFILMESOCMNOME.jpg");
    JButton obterFilmesComnome = new JButton("obterFilmesComNome", obterFilmesComnomeIcon);

    obterFilmesComnome.setBounds(100, 100, 05, 05);
    obterFilmesComnome.setVisible(true);


    //existemFilmesDaCategoria
    ImageIcon existemFilmesDacategoriaIcon = new ImageIcon(imagePath+"EXISTEMFILMESDACATG.jpg");
    JButton existemFilmesDacategoria = new JButton("existemFilmesDaCategoria", existemFilmesDacategoriaIcon);

    existemFilmesDacategoria.setBounds(100, 100, 05, 05);
    existemFilmesDacategoria.setVisible(true);


    //contaFilmesDaCategoria
    ImageIcon contaFilmesDaCIcon = new ImageIcon(imagePath+"CONTAFILMESDACATEGORIA.jpg");
    JButton contaFilmesDaC = new JButton("contaFilmesDaCategoria", contaFilmesDaCIcon);
    contaFilmesDaC.setBounds(100, 100, 05, 05);
    contaFilmesDaC.setVisible(true);





    // Cria botão> actionListener > faz esse bagulho aqui de baixo(criar nova funcionalidade)
    //add.ActionListener(new "Nome do novo metodo no caso o botao(this, a classe com que ele se refere))
    pesquisa.addActionListener(new PesquisaFilmeCodigo(this, sistema));
    cadastrar.addActionListener(new CadastraFilme(this, sistema));
    obterFilmesLancadosEm.addActionListener(new PesquisaFilmeAno(sistema));
    obterFilmesComnome.addActionListener(new ObterFilmesComNome(this, sistema));
    existemFilmesDacategoria.addActionListener(new ExistemFilmesDaCategoria(this, sistema));
    contaFilmesDaC.addActionListener(new ContaFilmesDaCategoria(this, sistema));
    addWindowListener(new Fechar(this , sistema));
    //Adicionando botões ao layout :
    layout.add(pesquisa);
    layout.add(cadastrar);
    layout.add(obterFilmesLancadosEm);
    layout.add(obterFilmesComnome);
    layout.add(existemFilmesDacategoria);
    layout.add(contaFilmesDaC);
    this.setLayout(new BorderLayout(5,5));
    this.add(layout,BorderLayout.CENTER);
    setVisible(true);

}

    // depois implementar o action com base na classe que recebe
    // criar classe interna



}

