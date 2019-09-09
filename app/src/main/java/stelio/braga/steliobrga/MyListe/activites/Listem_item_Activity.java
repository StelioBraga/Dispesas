package stelio.braga.steliobrga.MyListe.activites;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import stelio.braga.steliobrga.MyListe.utils.ProdutoAdapter;
import stelio.braga.steliobrga.MyListe.R;
import stelio.braga.steliobrga.MyListe.databasesProdutos.DatabasesProdutos;
import stelio.braga.steliobrga.MyListe.entities.Produtos;

public class Listem_item_Activity extends AppCompatActivity {
    RecyclerView rv_item;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listem_item);
        rv_item = findViewById(R.id.rv_item);
        rv_item.setLayoutManager(new LinearLayoutManager(this)); // set the list layout style to vertical.


    }

    private final void gravarProduto(){
        class gravarProduto extends AsyncTask<Void, Void, List<Produtos>> {

            @Override
            protected List<Produtos> doInBackground(Void... voids) {
                List<Produtos> produtosList = DatabasesProdutos.getmInstance(ctx)
                        .getDatabases()
                        .produtoDoa()
                        .getAll();


                return produtosList;
            }

            @Override
            protected void onPostExecute(List<Produtos> produdos) {
                super.onPostExecute(produdos);

                ProdutoAdapter posts = new ProdutoAdapter(produdos,ctx);
                rv_item.setAdapter(posts);
            }
        }
        gravarProduto user = new gravarProduto();
        user.execute();

    }


}
