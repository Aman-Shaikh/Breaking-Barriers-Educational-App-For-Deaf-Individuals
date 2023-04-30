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

class ViewPagerAdapter6 extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.lunch,
            R.drawable.dinner,
            R.drawable.breakfast,
            R.drawable.apple,
            R.drawable.egg,
            R.drawable.peas,
            R.drawable.cake,
            R.drawable.pizza,
            R.drawable.salad,
            R.drawable.chocolate,
            R.drawable.juice,
            R.drawable.cookie,
            R.drawable.toast,
            R.drawable.milk,
    };

    int headings[] = {

            R.string.heading_lunch,
            R.string.heading_dinner,
            R.string.heading_breakfast,
            R.string.heading_apple,
            R.string.heading_egg,
            R.string.heading_peas,
            R.string.heading_cake,
            R.string.heading_pizza,
            R.string.heading_salad,
            R.string.heading_chocalate,
            R.string.heading_juice,
            R.string.heading_cookie,
            R.string.heading_toast,
            R.string.heading_milk,
    };



    public ViewPagerAdapter6(Context context){

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