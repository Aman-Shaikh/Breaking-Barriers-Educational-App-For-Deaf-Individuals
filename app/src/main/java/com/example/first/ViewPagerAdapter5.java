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

class ViewPagerAdapter5 extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.dog,
            R.drawable.cat,
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.bear,
            R.drawable.snake,
            R.drawable.sheep,
            R.drawable.zebra,
            R.drawable.chicken,
            R.drawable.gorilla,
            R.drawable.giraffe,
            R.drawable.elephant,
            R.drawable.monkey,
            R.drawable.bison,
            R.drawable.horse,
            R.drawable.mouse,
    };

    int headings[] = {

            R.string.heading_dog,
            R.string.heading_cat,
            R.string.heading_lion,
            R.string.heading_tiger,
            R.string.heading_bear,
            R.string.heading_snake,
            R.string.heading_sheep,
            R.string.heading_zebra,
            R.string.heading_chicken,
            R.string.heading_gorilla,
            R.string.heading_giraffe,
            R.string.heading_elephant,
            R.string.heading_monkey,
            R.string.heading_bisom,
            R.string.heading_horse,
            R.string.heading_mouse,
    };



    public ViewPagerAdapter5(Context context){

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