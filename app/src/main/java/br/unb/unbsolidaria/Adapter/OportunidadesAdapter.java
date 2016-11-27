package br.unb.unbsolidaria.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.entidades.Oportunidade;
import br.unb.unbsolidaria.extras.ImageHelper;

/**
 * Created by Scartezini on 24/11/2016.
 */

public class OportunidadesAdapter extends RecyclerView.Adapter<OportunidadesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Oportunidade> mList;
    private LayoutInflater mLayoutInflater;
    private float scale;
    private int width;
    private int height;

    public OportunidadesAdapter(Context c, List<Oportunidade> l){
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int)(14 * scale + 0.5f);
        height = (width / 16) * 9;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card_oportunidade, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvTitulo.setText(mList.get(position).getTitulo());
        holder.tvLocal.setText(mList.get(position).getLocal());
        holder.tvVaga.setText(String.valueOf(mList.get(position).getVagas()));
        holder.tvDescricao.setText(mList.get(position).getDescricao());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            holder.ivOrg.setImageResource(mList.get(position).getPhoto());
        }
        else{
            Bitmap bitmap = BitmapFactory.decodeResource( mContext.getResources(), mList.get(position).getPhoto());
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
            holder.ivOrg.setImageBitmap(bitmap);
        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addListItem(Oportunidade opt, int position){
        mList.add(opt);
        notifyItemInserted(position);
    }


    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivOrg;
        public TextView tvTitulo;
        public TextView tvLocal;
        public TextView tvVaga;
        public TextView tvDescricao;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivOrg = (ImageView) itemView.findViewById(R.id.iv_org);
            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            tvLocal = (TextView) itemView.findViewById(R.id.tv_local);
            tvVaga = (TextView) itemView.findViewById(R.id.tv_vaga);
            tvDescricao = (TextView) itemView.findViewById(R.id.tv_descricao);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
