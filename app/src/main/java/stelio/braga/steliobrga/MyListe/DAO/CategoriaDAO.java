package stelio.braga.steliobrga.MyListe.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import stelio.braga.steliobrga.MyListe.entities.Categoria;

@Dao
public interface CategoriaDAO {

    @Query("SELECT * FROM categoria")
    List<Categoria> getAll();

    @Insert
    void  insert(Categoria categoria);

    @Delete
    void delete(Categoria categoria);

    @Update
    void update(Categoria categoria);
}
