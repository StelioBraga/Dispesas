package stelio.braga.steliobrga.minhalista.entites;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;


@Entity
public class Categoria extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "data")
    private String data;

    @ColumnInfo(name = "valor")
    private int valor;
    @ColumnInfo(name = "imagem")
    private int imagem;

    public Categoria(int id, String nome, String data, int valor, int imagem) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.imagem = imagem;
    }


    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    @Bindable
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Bindable
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Bindable
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Bindable
    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
