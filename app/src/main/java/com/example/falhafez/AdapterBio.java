package com.example.falhafez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// کلاس adapter برای ایجاد ارتباط بین سرور و گرفتن اطلاعات و نمایش در لیست ویو
class AdapterBio extends RecyclerView.Adapter<AdapterBio.MyHolder> {
// تعریف یک لیست بر اساس مدل + تعریف کانتکس
    private List<ModelBio> modelBioArrayList;
    private Context c;

    public AdapterBio(Context c, List<ModelBio> modelBioBioArrayList) {
        this.modelBioArrayList = modelBioBioArrayList;
        this.c = c;
    }


//
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.layout_bio, parent, false);
        return new MyHolder(v);
    }


    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        ModelBio modelBio = modelBioArrayList.get(position);
        holder.Name.setText(modelBio.getName());
        holder.BirthYearInLHijri.setText(""+modelBio.getBirthYearInLHijri());
        holder.DeathYearInLHijri.setText(""+modelBio.getDeathYearInLHijri());
        holder.BirthPlace.setText(modelBio.getBirthPlace());


    }

// برگرداندن طول ارایه
    @Override
    public int getItemCount() {

        return modelBioArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView Name;
        TextView BirthYearInLHijri;
        TextView DeathYearInLHijri;
        TextView BirthPlace;

        public MyHolder(View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.rowtxtName);
            BirthYearInLHijri = itemView.findViewById(R.id.rowtxtbirthYearInLHijri);
            DeathYearInLHijri = itemView.findViewById(R.id.rowtxtdeathYearInLHijri);
            BirthPlace = itemView.findViewById(R.id.rowtxtbirthPlace);
        }
    }
}
