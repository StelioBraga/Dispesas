package stelio.braga.steliobrga.MyListe.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;

@Entity
public class Produtos {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "quantidade")
    private String quantidade;

    @ColumnInfo(name = "valor")
    private String valor;

    @ColumnInfo(name = "unidade")
    private String unidade;

    @ColumnInfo(name = "categoria")
    private String categoria;

    @ColumnInfo(name = "imagem")
    private String imagem;

    public Produtos() {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.unidade = unidade;
        this.categoria = categoria;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
