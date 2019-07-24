package com.example.slidercalismasi.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.slidercalismasi.Adapter.IntroViewPagerAdapter;
import com.example.slidercalismasi.Model.ScreenItem;
import com.example.slidercalismasi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    IntroViewPagerAdapter introViewPagerAdapter;

    List<ScreenItem> itemList= new ArrayList<>();
    TabLayout tabLayout;
    Button btnNext;

    int position=0;

    public void icerikEkle(){
        //listenin içine değerlerini atadık.
        itemList.add(new ScreenItem(
                "HAYDİ BAŞLAYALIM!",
                "Haydi gelin, su içmeyince bize neler oluyor öğrenelim.",
                R.drawable.beyin2));

        itemList.add(new ScreenItem("HER SABAH ...",
                "Her sabah uyandığınızda, mutlaka bir bardak su içmeliyiz, hiç kimse bütün gün böyle gezmek istemez değil mi?",
                R.drawable.beyin1));

        itemList.add(new ScreenItem("İLK SUYUMUZU İÇTİYSEK ...",
                "İlk suyumuzu içtiysek, tam da böyle bir başlangıç yapıyoruz güne!",
                R.drawable.beyin8));

        itemList.add(new ScreenItem("ÇALIŞMAYA BAŞLAYABİLİRİZ",
                "Bir bardak su daha içip, çalışmaya başlayabiliriz.",
                R.drawable.beyin9));

        itemList.add(new ScreenItem("YÜKSEK VERİM ...",
                "Yüksek verimli bir çalışma sizi bekliyor.",
                R.drawable.beyin10));

        itemList.add(new ScreenItem("CAPCANLI FİKİRLER ...",
                "Bir bardak daha su içip, çalışma verimini zirveye taşımak isteme miyiz?",
                R.drawable.beyin5));

        itemList.add(new ScreenItem("EKİP ÇALIŞMASINDA ... ",
                "Ekip arkadaşlarınızla yaptığınız fikir alışverişleri işinizi daha kolaylaştıracak.",
                R.drawable.beyin6));

        itemList.add(new ScreenItem("PROBLEM ÇÖZMEDE ...",
                "Yaşantınızdaki problemleri çözmede daha iyi olabilmek için bir bardak su daha!",
                R.drawable.beyin4));

        itemList.add(new ScreenItem("AMANINN! UNUTTUNUZ MU?",
                "Su içmeyi unuttuğunuz an, hemen bir bardak daha içmeye koşun.",
                R.drawable.beyin7));

        itemList.add(new ScreenItem("SPOR MU DEDİNİZ?",
                "Öyle hızlı koşun ki, kendinizi spor yaparken bulun!",
                R.drawable.beyin0));

        itemList.add(new ScreenItem("GÜN SONU ...",
                "Tam da gerektiği gibi su içtiniz ve gün sonu yorgunluğu kalmadı!",
                R.drawable.beyin12));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //actionBar ı gizleme
        getSupportActionBar().hide();

        tabLayout= findViewById(R.id.tabLayout);
        btnNext=findViewById(R.id.btnNext);


        icerikEkle();

        //view pager sınıfını set ediyoruz.
        viewPager= findViewById(R.id.viewPager);
        introViewPagerAdapter= new IntroViewPagerAdapter(this,itemList);
        viewPager.setAdapter(introViewPagerAdapter);


        //tablayout u set ediyoruz.
        tabLayout.setupWithViewPager(viewPager);

        //buton click listener.. ileri butonuna tıklama olayı.

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position=viewPager.getCurrentItem();
                if (position < itemList.size()){

                    position++;
                    viewPager.setCurrentItem(position);
                }

                if (position == itemList.size()){

                    // TODO: show the GETSTARTED button and hide the next button

                    loadLastScreen();
                }
            }
        });
    }


    //show the GETSTARTED button and hide the next button
    private void loadLastScreen() {

    }
}
