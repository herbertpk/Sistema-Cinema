package sistema;

import exceptions.FilmeJaCadastradoExecption;
import exceptions.FilmeNaoExisteExecption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFilmeMap implements SistemaFilmeInterface {
    private Map<String,Filme> filmesMap;



    public SistemaFilmeMap(){
        filmesMap = new HashMap<>();
    }

    public void cadastrarFilme( String codigo, String nome, int anoLancamento,int duracaoEmMinutos,List<CategoriaFilme> categoriaFilme ) throws FilmeJaCadastradoExecption {
        Filme filme = new Filme(codigo, nome, anoLancamento, duracaoEmMinutos, categoriaFilme);
        if(filmesMap.containsKey(codigo)){
        throw new FilmeJaCadastradoExecption("SistemaFilmes.Filme já cadastrado");
        }else{
            filmesMap.put(codigo,filme);
        }
    }
    public void cadastrarFilme(Filme filme) throws FilmeJaCadastradoExecption {
        if(filmesMap.containsKey(filme.getCodigo())){
            throw new FilmeJaCadastradoExecption("SistemaFilmes.Filme já cadastrado");
        }else{
            filmesMap.put(filme.getCodigo(),filme);
        }
    }

    public Filme pesquisaFilme(String codigo) throws FilmeNaoExisteExecption {
        if (filmesMap.containsKey(codigo)) {
            return filmesMap.get(codigo);
        } else {
            throw new FilmeNaoExisteExecption("Não existe");
        }
    }

    public List<Filme> obterFilmesLancadosEm(int ano){
        List<Filme> obterLancados = new ArrayList<>();
        for( Filme f : filmesMap.values()){
            if (f.getAnoLancamento() == ano){
                obterLancados.add(f);
            }
        }
        return obterLancados;
    }
    public List<Filme> obterFilmesComNome(String nome) throws FilmeNaoExisteExecption{
    List<Filme> obterFilme = new ArrayList<>();
    for (Filme f : filmesMap.values() ){
        if ( f.getNome().equals(nome)){
            obterFilme.add(f);
        }
    }
        return obterFilme;
    }
    public boolean existemFilmesDaCategoria( CategoriaFilme categoria) {
        for (Filme f : filmesMap.values()) {
            if (f.ehDaCategoria(categoria)) {
                return true;
            }
        }
        return false;
    }
    public int contaFilmesDaCategoria( CategoriaFilme categoria){
        int cont = 0;
        for (Filme f: filmesMap.values()) {
            if (f.ehDaCategoria(categoria)){
                cont++;
            }
        }
        return cont;
    }

}
