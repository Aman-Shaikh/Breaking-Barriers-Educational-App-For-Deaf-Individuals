package com.example.first;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

class ViewPagerAdapter7 extends PagerAdapter {

    Context context;

    int images[] = {
            R.drawable.vegetable,
            R.drawable.onion,
            R.drawable.mushroom,
            R.drawable.pumpkin,
            R.drawable.corn,
            R.drawable.carrot,
            R.drawable.tomato,
            R.drawable.potato,
    };

    int headings[] = {
            R.string.heading_vegetable,
            R.string.heading_onion,
            R.string.heading_mushroom,
            R.string.heading_pumpkin,
            R.string.heading_corn,
            R.string.heading_carrot,
            R.string.heading_tomato,
            R.string.heading_potato,
    };

    public ViewPagerAdapter7(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return  headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.texttitle);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}