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

class ViewPagerAdapter11 extends PagerAdapter {

    Context context;

    int images[] = {
            R.drawable.apple,
            R.drawable.breakfast,
            R.drawable.mushroom,
            R.drawable.apple,
            R.drawable.train,
            R.drawable.a00,
            R.drawable.salad,
            R.drawable.pizza,
            R.drawable.a77,
            R.drawable.sheep,
    };

    int headings[] = {

            R.string.heading_apple,
            R.string.heading_breakfast,
            R.string.heading_mushroom,
            R.string.heading_apple,
            R.string.heading_train,
            R.string.heading_a00,
            R.string.heading_salad,
            R.string.heading_pizza,
            R.string.heading_a77,
            R.string.heading_sheep,
    };



    public ViewPagerAdapter11(Context context){

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