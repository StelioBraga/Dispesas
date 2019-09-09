package stelio.braga.steliobrga.MyListe.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

import stelio.braga.steliobrga.MyListe.entities.Produtos;

@Dao
public interface ProdutoDAO {

        @Query("SELECT *FROM produtos")
        List<Produtos> getAll();

        @Insert
        void  insert(Produtos produtos);

        @Delete
        void delete(Produtos produtos);

        @Update
        void update(Produtos produtos);

}
