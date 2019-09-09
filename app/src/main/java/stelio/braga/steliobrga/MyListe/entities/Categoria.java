package stelio.braga.steliobrga.MyListe.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Categoria  {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "data")
    private String data;

    @ColumnInfo(name = "valor")
    private String valor;

    @ColumnInfo(name = "imagem")
    private String imagem;

    public Categoria() {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
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


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
