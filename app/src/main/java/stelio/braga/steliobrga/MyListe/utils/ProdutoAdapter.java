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
import stelio.braga.steliobrga.MyListe.entities.Produtos;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {
    private List<Produtos>  mprodudosList;
    private Context mContext;
    private AdapterView.OnItemClickListener onItemClickListener;

    public ProdutoAdapter(List<Produtos> mprodudosList, Context mContext) {
        this.mprodudosList = mprodudosList;
        this.mContext = mContext;

    }



    @Override
    public ProdutoAdapter.ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ProdutoAdapter.ProdutoViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoAdapter.ProdutoViewHolder holder, int i) {
        Produtos produtos = mprodudosList.get(i);
        holder.tv_iem_valor .setText(produtos.getValor());
        holder.tv_item_nome .setText(String.valueOf(produtos.getNome()));
        holder.tv_item_quantidade.setText(String.valueOf(produtos.getQuantidade()));
        holder.image_item_produto.setImageURI(Uri.parse(produtos.getImagem()));


    }

    @Override
    public int getItemCount() {
        return mprodudosList.size();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder {
        private ProdutoAdapter mAdapter;
        ImageView image_item_produto;
        TextView tv_item_nome, tv_iem_valor,tv_item_quantidade;


        public ProdutoViewHolder(@NonNull View itemView,final ProdutoAdapter mAdapter) {
            super(itemView);
            this.mAdapter =mAdapter;
            tv_iem_valor = itemView.findViewById(R.id.tv_item_valor);
            tv_item_nome = itemView.findViewById(R.id.tv_item_nome);
            tv_item_quantidade = itemView.findViewById(R.id.tv_item_quantidade);
            image_item_produto = itemView.findViewById(R.id.image_item_produto);

        }
    }
}
