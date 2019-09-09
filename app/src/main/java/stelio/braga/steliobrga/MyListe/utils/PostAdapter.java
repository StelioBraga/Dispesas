package stelio.braga.steliobrga.MyListe.utils;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import stelio.braga.steliobrga.MyListe.R;
import stelio.braga.steliobrga.MyListe.entities.Categoria;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Categoria> mCategoriasList;
    private Context mContext;
    private AdapterView.OnItemClickListener onItemClickListener;


    public PostAdapter(List<Categoria> mCategoriasList, Context mContext) {
        this.mCategoriasList = mCategoriasList;
        this.mContext = mContext;
    }

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final View view = inflater.inflate(R.layout.post, viewGroup, false);
//        status = ProfileActivity.status;
        return new PostViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, final int position) {
        Categoria categoria = mCategoriasList.get(position);

        holder.tv_nome.setText(categoria.getNome());
        holder.tv_valor.setText(String.valueOf(categoria.getValor()));
        holder.tv_data.setText(String.valueOf(categoria.getData()));
        holder.Iv_categoria.setImageURI(Uri.parse(categoria.getImagem()));
    }

    @Override
    public int getItemCount() {
        return mCategoriasList.size();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public void onItemHolderClick(PostViewHolder holder) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(null, holder.itemView, holder.getAdapterPosition(), holder.getItemId());
        }
    }



    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private PostAdapter mAdapter;
        ImageView Iv_categoria;
        TextView tv_nome, tv_data, tv_valor;


        public PostViewHolder(View itemView, final PostAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;


            tv_nome = itemView.findViewById(R.id.tv_nome);
            tv_data = itemView.findViewById(R.id.tv_data);
            tv_valor = itemView.findViewById(R.id.tv_valor);
            Iv_categoria = itemView.findViewById(R.id.Iv_categoria);


        }

        public void setStudentToList(Categoria item, int position) {

        }

        @Override
        public void onClick(View v) {

        }


    }





        }




