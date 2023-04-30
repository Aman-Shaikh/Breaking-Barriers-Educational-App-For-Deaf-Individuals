package com.example.first.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.first.model.MyRecyclerViewModel;
import com.example.first.R;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{
    ArrayList<MyRecyclerViewModel> list;
    Context context;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    Bitmap bitmap=null;
    int width = 250;
    int height = 200;
    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);


    // RecyclerView recyclerView;
    public MyRecyclerViewAdapter(ArrayList<MyRecyclerViewModel> list,Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.sample_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyRecyclerViewModel model = list.get(position);
        String imagesNames = model.getPics();
        holder.textView.setText(model.getText());

        for(int i=0;i<imagesNames.length();i++)
        {
            String mDrawableName="";
            if(imagesNames.charAt(i)>='0' && imagesNames.charAt(i)<='9')
            {
                 mDrawableName =  "a"+imagesNames.charAt(i)+imagesNames.charAt(i);
            }
            else
            {
                mDrawableName = ""+imagesNames.charAt(i);
            }

            int id = context.getResources().getIdentifier(mDrawableName , "drawable" ,context.getPackageName()) ;

            ImageView img = new ImageView(context);
            img.setImageResource(id);
            img.setLayoutParams(parms);
            holder.gridLayout.addView(img);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public GridLayout gridLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.ImageText);
            this.gridLayout = (GridLayout) itemView.findViewById(R.id.imagesGridLayout);
        }
    }

    public void showToast(String str)
    {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

}
