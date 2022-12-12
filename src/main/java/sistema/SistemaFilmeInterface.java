package sistema;

import exceptions.FilmeJaCadastradoExecption;
import exceptions.FilmeNaoExisteExecption;

import java.io.Serializable;
import java.util.List;

public interface SistemaFilmeInterface extends Serializable {
    void cadastrarFilme(String codigo, String nome, int anoLancamento, int duracaoEmMinutos, List<CategoriaFilme> categoriaFilme ) throws FilmeJaCadastradoExecption;
    void cadastrarFilme(Filme filme) throws FilmeJaCadastradoExecption;
    Filme pesquisaFilme(String codigo) throws FilmeNaoExisteExecption;
    List<Filme> obterFilmesLancadosEm(int ano);
    List<Filme> obterFilmesComNome(String nome) throws FilmeNaoExisteExecption;
    boolean existemFilmesDaCategoria( CategoriaFilme categoria);
    int contaFilmesDaCategoria( CategoriaFilme categoria);

}
