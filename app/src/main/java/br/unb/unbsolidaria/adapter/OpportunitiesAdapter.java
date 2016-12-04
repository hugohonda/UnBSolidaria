package br.unb.unbsolidaria.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.unb.unbsolidaria.OpportunityAcitivity;
import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.SplashActivity;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.extras.ImageHelper;

/**
 * Created by Scartezini on 24/11/2016.
 */

public class OpportunitiesAdapter extends RecyclerView.Adapter<OpportunitiesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Opportunity> mList;
    private LayoutInflater mLayoutInflater;
    private float scale;
    private int width;
    private int height;

    public OpportunitiesAdapter(Context c, List<Opportunity> l) {
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int) (14 * scale + 0.5f);
        height = (width / 16) * 9;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card_opportunity, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tvTitulo.setText(mList.get(position).getTitle());
        holder.tvLocal.setText(mList.get(position).getLocal());
        holder.tvVaga.setText(String.valueOf(mList.get(position).getVagas()));
        holder.tvdescription.setText(mList.get(position).getDescription());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.ivOrg.setImageResource(mList.get(position).getPhoto());
        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), mList.get(position).getPhoto());
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
            holder.ivOrg.setImageBitmap(bitmap);
        }

        holder.btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, OpportunityAcitivity.class);
                intent.putExtra("id",mList.get(position).getID());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addListItem(Opportunity opt, int position) {
        mList.add(opt);
        notifyItemInserted(position);
    }


    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivOrg;
        public TextView tvTitulo;
        public TextView tvLocal;
        public TextView tvVaga;
        public TextView tvdescription;
        public Button btnSeeMore;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivOrg = (ImageView) itemView.findViewById(R.id.iv_org);
            tvTitulo = (TextView) itemView.findViewById(R.id.tv_title);
            tvLocal = (TextView) itemView.findViewById(R.id.tv_local);
            tvVaga = (TextView) itemView.findViewById(R.id.tv_vaga);
            tvdescription = (TextView) itemView.findViewById(R.id.tv_descricao);
            btnSeeMore = (Button) itemView.findViewById(R.id.btn_seemore);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
