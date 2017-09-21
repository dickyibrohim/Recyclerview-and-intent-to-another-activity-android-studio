package com.app.dicky.resepku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DICKY IBROHIM on 9/19/2017.
 */

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepHolder> {
    private String mJudul[];
    private String mLangkah[];
    private ResepListener mListener;
    public ResepAdapter(String titleresep[],String langkah[],ResepListener listener){
        mJudul = titleresep;
        mLangkah = langkah;
        mListener = listener;
    }
    interface ResepListener{
        void onClick(int position);
    }
    @Override
    public ResepHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_resep, parent, false);
        return new ResepHolder(view);
    }

    @Override
    public void onBindViewHolder(ResepHolder holder, int position) {
        String judul = mJudul[position];
        String langkah = mLangkah[position];
        holder.setResep(judul,langkah);
    }

    @Override
    public int getItemCount() {
        return mJudul.length;
    }
    public String getJudul(int position){
        return mJudul[position];
    }

    public class ResepHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView1;
        private TextView textView2;
        public ResepHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.titleresep);
            textView2 = (TextView) itemView.findViewById(R.id.langkah);
            itemView.setOnClickListener(this);
        }
        public void setResep(String judul,String ket){
            textView1.setText(judul);
            textView2.setText(ket);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}