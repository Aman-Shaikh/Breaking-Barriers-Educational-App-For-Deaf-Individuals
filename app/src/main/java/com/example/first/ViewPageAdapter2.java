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

class ViewPagerAdapter2 extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.blue,
            R.drawable.purple,
            R.drawable.red,
            R.drawable.white,
            R.drawable.green,
            R.drawable.pink,
            R.drawable.brown,
            R.drawable.orange,
            R.drawable.yellow,
            R.drawable.black,
    };

    int headings[] = {

            R.string.heading_blue,
            R.string.heading_purple,
            R.string.heading_red,
            R.string.heading_white,
            R.string.heading_green,
            R.string.heading_pink,
            R.string.heading_brown,
            R.string.heading_orange,
            R.string.heading_yellow,
            R.string.heading_black,
    };



    public ViewPagerAdapter2(Context context){

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