package stelio.braga.steliobrga.MyListe.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kishannareshpal.examescomponents.StateMode;
import com.kishannareshpal.examescomponents.StateView;

import java.util.List;

import stelio.braga.steliobrga.MyListe.databasesCategoria.DatabaseCategoria;
import stelio.braga.steliobrga.MyListe.utils.PostAdapter;
import stelio.braga.steliobrga.MyListe.R;
import stelio.braga.steliobrga.MyListe.entities.Categoria;

public class CategoriaFragment extends Fragment {
    StateView stateView;

    RecyclerView rv_posts;
    Context ctx;

    public CategoriaFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ctx = getActivity();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ctx = getActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);



        stateView = view.findViewById(R.id.stateView);
        //vazio
        stateView.iconRes(R.drawable.ic_box).title("Não tem nenhuma categoria disponivel ").message("Adicione uma categoria!!");
        rv_posts = view.findViewById(R.id.rv_categoria);
        rv_posts.setLayoutManager(new CustomLinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false)); // set the list_item layout style to vertical.

        //Toast.makeText(ctx, getUsuarios(), Toast.LENGTH_SHORT).show();

        getUsuarios();
        return view;

    }

        // get data
    private final void getUsuarios(){
        class Getusuarios extends AsyncTask<Void,Void, List<Categoria>> {

            @Override
            protected List<Categoria> doInBackground(Void... voids) {
                List<Categoria> categoriaslista = DatabaseCategoria.getmInstance(ctx)
                        .getDatabases()
                        .categoriaDAO()
                        .getAll();



                return categoriaslista;
            }

            @Override
            protected void onPostExecute(List<Categoria> categorias) {
                super.onPostExecute(categorias);

                if (categorias.isEmpty()) {
                    stateView.stateMode(StateMode.ALTERNATE);
                } else {

                    Toast.makeText(ctx, "Here", Toast.LENGTH_SHORT).show();
                    PostAdapter posts = new PostAdapter(categorias, ctx);
                    stateView.stateMode(StateMode.NORMAL);
                    rv_posts.setAdapter(posts);
                }



            }
        }
        Getusuarios user = new Getusuarios();
        user.execute();

    }


    // Layout manager for recycler view
    public class CustomLinearLayoutManager extends LinearLayoutManager {
        public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);


        }
    }
}

