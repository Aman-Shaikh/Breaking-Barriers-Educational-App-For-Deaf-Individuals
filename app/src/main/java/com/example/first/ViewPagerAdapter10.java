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

class ViewPagerAdapter10 extends PagerAdapter {

    Context context;

    int images[] = {
            R.drawable.ship,
            R.drawable.dog,
            R.drawable.snake,
            R.drawable.ambulance,
            R.drawable.x,
            R.drawable.a44,
            R.drawable.horse,
            R.drawable.aeroplan,
            R.drawable.tired,
            R.drawable.elephant,
    };

    int headings[] = {
            R.string.heading_ship,
            R.string.heading_dog,
            R.string.heading_snake,
            R.string.heading_ambulance,
            R.string.heading_24,
            R.string.heading_a44,
            R.string.heading_horse,
            R.string.heading_aeroplan,
            R.string.heading_tired,
            R.string.heading_elephant,

    };



    public ViewPagerAdapter10(Context context){

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