import exceptions.FilmeJaCadastradoExecption;
import exceptions.FilmeNaoExisteExecption;
import org.junit.jupiter.api.DisplayName;
import sistema.CategoriaFilme;
import sistema.Filme;
import sistema.SistemaFilmeInterface;
import sistema.SistemaFilmeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class TestCase {
    private SistemaFilmeInterface filme;
    private List<CategoriaFilme> categorias;


    @BeforeEach
    void setup(){
        filme = new SistemaFilmeMap();
        categorias = new ArrayList<>();
    }

    @Test
    @DisplayName("teste metodo contarFilmesDaCategoria")
    void testeContaFilmesCategoria () throws FilmeJaCadastradoExecption {

        categorias.add(CategoriaFilme.ROMANCE);

        filme.cadastrarFilme("codigo", "nome",2001, 10,categorias);
        assertEquals(1,filme.contaFilmesDaCategoria(CategoriaFilme.ROMANCE));
    }

    @Test
    @DisplayName("teste metodo cadastrarFilme")
    void testeCadastraFilme() throws FilmeJaCadastradoExecption {

        categorias.add(CategoriaFilme.ROMANCE);

        try {
            filme.cadastrarFilme("codigo", "nome", 2001, 10, categorias);
            filme.cadastrarFilme("outroCodigo", "outroNome", 2001, 10, categorias);
        } catch (FilmeJaCadastradoExecption e) {
            fail("o codigo não poderia chegar nesse ponto");
        }
        assertThrows(FilmeJaCadastradoExecption.class, () -> filme.cadastrarFilme("codigo", "nome", 2001, 10, categorias), "deveria lançar esta exceção");


    }

    @Test
    @DisplayName("teste metodo obterFilmesLancadosEm")
    void testeObterFilmesLancadosEm() throws FilmeJaCadastradoExecption {

        try {
            filme.cadastrarFilme("codigo", "nome", 2001, 10, categorias);
            assertEquals(1, (filme.obterFilmesLancadosEm(2001)).size());
        }catch(FilmeJaCadastradoExecption e ){
            fail();
        }

    }

    @Test
    @DisplayName("teste metodo obterFilmesComNome")
    void testeObterFilmesComNome() throws FilmeJaCadastradoExecption {

        try {
            filme.cadastrarFilme("codigo", "nome", 2001, 10, categorias);
            filme.cadastrarFilme("outroCodigo", "outroNome", 2001, 10, categorias);
            assertEquals(1,filme.obterFilmesComNome("nome").size());
        }catch(FilmeJaCadastradoExecption | FilmeNaoExisteExecption e){
            fail("o teste falhou por lançar uma execção inesperada!");
        }
    }

    @Test
    @DisplayName("teste metodo existeFilmesDaCategoria")
    void testeExistemFilmesDaCategoria() throws FilmeJaCadastradoExecption {

        categorias.add(CategoriaFilme.ROMANCE);

        filme.cadastrarFilme("codigo", "nome", 2001, 10, categorias);
        filme.cadastrarFilme("outroCodigo", "outroNome", 2001, 10, categorias);
        assertTrue(filme.existemFilmesDaCategoria(CategoriaFilme.ROMANCE));

    }

    @Test
    @DisplayName("teste metodo Pesquisa")
    void testePesquisaFilme() throws FilmeJaCadastradoExecption, FilmeNaoExisteExecption {
        Filme F = new Filme("codigo", "nome", 2001, 10, categorias);
        filme.cadastrarFilme(F);

        assertEquals(F,filme.pesquisaFilme("codigo"));

    }

    @Test
    @DisplayName("teste do exception FilmeNaoExisteExecption")
    void testeFilmeNaoExisteExecption() throws FilmeJaCadastradoExecption, FilmeNaoExisteExecption {


        try {
            filme.cadastrarFilme("codigo", "nome", 2001, 10, categorias);
            filme.pesquisaFilme("codigo");
        }catch(FilmeJaCadastradoExecption | FilmeNaoExisteExecption e ) {
            fail("não poderia lançar execption");


            assertThrows(FilmeNaoExisteExecption.class, () -> filme.pesquisaFilme("codigo"));
        }
    }


}
