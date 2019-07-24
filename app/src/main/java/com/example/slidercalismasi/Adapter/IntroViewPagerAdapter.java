package com.example.slidercalismasi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slidercalismasi.Model.ScreenItem;
import com.example.slidercalismasi.R;

import java.util.List;

/*
* layoutta kullanmış olduğumuz pager nesnesi için, adapter sınıfını oluşturduk.
 */
public class IntroViewPagerAdapter extends PagerAdapter {

    /*
    model sınıfındaki değişkenleri kullanabilmek için List tipinde tanımladık.
     */
    Context context;
    List<ScreenItem> screenItems;

    // layout_screen.xml dosyasındaki nesneleri tanımladık
    ImageView introImg;
    TextView intro_title;
    TextView intro_description;

    public IntroViewPagerAdapter(Context context, List<ScreenItem> screenItems) {
        this.context = context;
        this.screenItems = screenItems;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutScreen= inflater.inflate(R.layout.screen_layout,null);

        introImg = layoutScreen.findViewById(R.id.intro_image);
        intro_title =layoutScreen.findViewById(R.id.intro_title);
        intro_description= layoutScreen.findViewById(R.id.intro_description);

        intro_title.setText(screenItems.get(position).getTitle());
        intro_description.setText(screenItems.get(position).getDescription());
        introImg.setImageResource(screenItems.get(position).getScreenImg());

        container.addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        /*
        oluşturduğumuz listedeki değerlerin sayısını dönen metot
         */
        return screenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        /*
        View
         */
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        /*
        açıklama yazzzzz
         */
        container.removeView((View)object);

    }
}
