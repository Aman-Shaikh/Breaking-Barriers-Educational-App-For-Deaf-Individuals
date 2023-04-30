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

class ViewPagerAdapter3 extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.excited,
            R.drawable.surprise,
            R.drawable.tired,
            R.drawable.happy,
            R.drawable.dream,
            R.drawable.feeling,
            R.drawable.sad,
            R.drawable.good,
            R.drawable.bad,
            R.drawable.nervous,
            R.drawable.bored,
            R.drawable.grumpy,
    };

    int headings[] = {

            R.string.heading_excited,
            R.string.heading_surprise,
            R.string.heading_tired,
            R.string.heading_happy,
            R.string.heading_dream,
            R.string.heading_feeling,
            R.string.heading_sad,
            R.string.heading_good,
            R.string.heading_bad,
            R.string.heading_nervous,
            R.string.heading_bored,
            R.string.heading_grumpy,
    };



    public ViewPagerAdapter3(Context context){

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