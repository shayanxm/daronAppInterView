package com.example.daronapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.daronapp.R;
import com.example.daronapp.model.Data;

import java.util.Date;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Data> dataList;
    private Context context;

    public CustomAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView statusTv;
        TextView nameTv;
TextView priceTV;
        ImageView statusIv;
        TextView colorTv;


        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            statusIv = mView.findViewById(R.id.item_status_iv);
            statusIv.setBackgroundResource(R.drawable.red_circle);
            nameTv = mView.findViewById(R.id.item_name_tv);
            statusTv = mView.findViewById(R.id.item_status_tv);
priceTV=mView.findViewById(R.id.item_price_tv);
colorTv=mView.findViewById(R.id.item_des_tv);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rec_item_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
Data currentData=dataList.get(position);
        holder.nameTv.setText(currentData.getName());
        holder.statusTv.setText(currentData.getStatus().getMessage());
        holder.priceTV.setText(currentData.getPrice());
        String finalStringBuilder="";
        for (int i=0;i<currentData.getSpecifications().size();i++){
            if (dataList.get(position).getSpecifications().get(i).getPivotKindCode()==1){
               finalStringBuilder+= " ,"+dataList.get(position).getSpecifications().get(i).getPivot().getColor();
            }
            holder.colorTv.setText(finalStringBuilder);
    }

//
//        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(dataList.get(position).getThumbnailUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.coverImage);


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}