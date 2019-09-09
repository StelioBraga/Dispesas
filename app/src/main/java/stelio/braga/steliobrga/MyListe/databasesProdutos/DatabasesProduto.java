package stelio.braga.steliobrga.MyListe.databasesProdutos;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import stelio.braga.steliobrga.MyListe.entities.Produtos;
import stelio.braga.steliobrga.MyListe.DAO.ProdutoDAO;

@Database(entities = {Produtos.class}, version = 1,exportSchema = false)
public  abstract class  DatabasesProduto extends RoomDatabase {
    public abstract ProdutoDAO produtoDoa();
}
