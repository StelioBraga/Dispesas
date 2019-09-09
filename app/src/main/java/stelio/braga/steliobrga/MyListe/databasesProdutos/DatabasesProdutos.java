package stelio.braga.steliobrga.MyListe.databasesProdutos;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabasesProdutos {
    private Context mCtx;
    private static DatabasesProdutos mInstance;
    private DatabasesProduto databases;

    public DatabasesProdutos(Context mCtx) {
        this.mCtx = mCtx;
        databases = Room.databaseBuilder(mCtx, DatabasesProduto.class,"Produtodatabases").allowMainThreadQueries().build();
    }



    public  static synchronized DatabasesProdutos getmInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabasesProdutos(mCtx);
        }
        return mInstance;
    }
    public DatabasesProduto getDatabases(){
        return databases;
    }
}
