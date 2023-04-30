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

class ViewPagerAdapter8 extends PagerAdapter {

    Context context;

    int images[] = {
            R.drawable.c,
            R.drawable.a33,
            R.drawable.y,
            R.drawable.a22,
            R.drawable.w,
            R.drawable.a88,
            R.drawable.k,
            R.drawable.a99,
            R.drawable.v,
            R.drawable.a11,
    };

    int headings[] = {
            R.string.heading_three,
            R.string.heading_a33,
            R.string.heading_25,
            R.string.heading_a22,
            R.string.heading_23,
            R.string.heading_a88,
            R.string.heading_11,
            R.string.heading_a99,
            R.string.heading_22,
            R.string.heading_a11,
    };

    public ViewPagerAdapter8(Context context){
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