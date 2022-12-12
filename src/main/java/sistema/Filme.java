package sistema;

import java.io.Serializable;
import java.util.List;

public class Filme implements Serializable {
    private String codigo;
    private String nome;
    private int anoLancamento;
    private int duracaoEmMinutos;

    private List <CategoriaFilme> categoriaFilme;



    public Filme(String codigo, String nome, int anoLancamento, int duracaoEmMinutos, List<CategoriaFilme> categoriaFilme) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.categoriaFilme = categoriaFilme;
    }
    public Filme(){this("","",0,0,null);}

    public boolean ehDaCategoria(CategoriaFilme categoria) {
        for (CategoriaFilme cat: this.categoriaFilme) {
            if (cat.equals(categoria)) {
                return true;
            }
        }
        return false;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public String imprimirCategorias(List<CategoriaFilme> categorias){
        String catString = "";
        for(CategoriaFilme cat : categorias){
            catString = catString.concat(cat+",");
        }
        catString = catString.toLowerCase();
        return catString;
    }
    @Override
    public String toString() {
        return "Este filme tem " +"\n"+
                "codigo: " + this.codigo + "\n" +
                "nome: " + this.nome + "\n" +
                "ano de lancamento: " + this.anoLancamento +"\n"+
                "Duração: " + this.duracaoEmMinutos +" min"+"\n"+
                "Categorias: " + imprimirCategorias(this.categoriaFilme);
    }
}

