package stelio.braga.steliobrga.MyListe.databasesCategoria;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseCategoria {
    private Context mCtx;
    private static DatabaseCategoria mInstance;
    private  Databases databases;

    public DatabaseCategoria(Context mCtx) {
        this.mCtx = mCtx;
        databases = Room.databaseBuilder(mCtx, Databases.class,"Categoriadatabases").allowMainThreadQueries().build();
    }



    public  static synchronized  DatabaseCategoria getmInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseCategoria(mCtx);
        }
        return mInstance;
    }
    public Databases getDatabases(){
        return databases;
    }
}
