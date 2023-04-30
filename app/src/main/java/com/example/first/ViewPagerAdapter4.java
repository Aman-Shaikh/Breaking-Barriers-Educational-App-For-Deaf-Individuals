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

class ViewPagerAdapter4 extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.bicycle,
            R.drawable.ship,
            R.drawable.helicopter,
            R.drawable.truck,
            R.drawable.car,
            R.drawable.motorcycle,
            R.drawable.bus,
            R.drawable.taxi,
            R.drawable.ambulance,
            R.drawable.train,
            R.drawable.scooter,
            R.drawable.aeroplan,
    };

    int headings[] = {

            R.string.heading_bicycle,
            R.string.heading_ship,
            R.string.heading_helicopter,
            R.string.heading_Truck,
            R.string.heading_car,
            R.string.heading_motorcycle,
            R.string.heading_bus,
            R.string.heading_taxi,
            R.string.heading_ambulance,
            R.string.heading_train,
            R.string.heading_scooter,
            R.string.heading_aeroplan,
    };



    public ViewPagerAdapter4(Context context){

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