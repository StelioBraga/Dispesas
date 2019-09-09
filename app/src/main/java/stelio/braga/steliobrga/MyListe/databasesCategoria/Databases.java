package stelio.braga.steliobrga.MyListe.databasesCategoria;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import stelio.braga.steliobrga.MyListe.DAO.CategoriaDAO;
import stelio.braga.steliobrga.MyListe.entities.Categoria;

@Database(entities = {Categoria.class}, version = 1,exportSchema = false)
    public  abstract class  Databases extends RoomDatabase{
        public abstract CategoriaDAO categoriaDAO();
}

