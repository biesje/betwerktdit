package com.example.timbiezeveld.amazighproj;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timbiezeveld.amazighproj.R;

public class OefenFruit extends Activity

{
    float x1,x2;
    float y1, y2;
    int arrayNum;
    int aantalWoorden;
    private String[] woorden = {
           "appel", "peer", "abrikoos",
            "perzik","druiven","watermeloen",
            "honingmeloen", "granaatappel", "vijg",
            "cactusvijg", "pruim", "sinaasappel",
            "dadel", "citroen", "bananen"
    };

    private String[] vertaling = {
                 "tateffaht", "tafirast", "rmecmac",
            "rxux","aḍil","ddellaɛ",
            "abettix", "arremman", "tazart",
            "tahendict", "rbarquq", "taleccint",
            "tini", "llaymun", "banan"
    };

    private int[] photos = {
        R.drawable.fruit_appel, R.drawable.fruit_peer, R.drawable.fruit_abrikoos, R.drawable.fruit_perzik, R.drawable.fruit_druiven, R.drawable.fruit_watermeloen, R.drawable.fruit_honingmeloen,
            R.drawable.fruit_granaatappel, R.drawable.fruit_vijg,
    };

    private int[] geluid = {
            R.raw.dieren01_egel,R.raw.dieren01_ezel, R.raw.dieren01_geit,R.raw.dieren01_hond, R.raw.dieren01_jakhals, R.raw.dieren01_kat,
            R.raw.dieren01_kikker, R.raw.dieren01_kip, R.raw.dieren01_koe, R.raw.dieren01_konijn, R.raw.dieren01_muis, R.raw.dieren01_paard, R.raw.dieren01_schaap, R.raw.dieren01_vis, R.raw.dieren01_vogel
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen);
        arrayNum = 0;
        setItems();

        aantalWoorden = woorden.length-1;

    }

    // onTouchEvent () method gets called when User performs any touch event on screen
    // Method to handle touch event like left to right swap and right to left swap
    public boolean onTouchEvent(MotionEvent touchevent) {
            switch (touchevent.getAction()) {
                // when user first touches the screen we get x and y coordinate
                case MotionEvent.ACTION_DOWN: {
                    x1 = touchevent.getX();
                    y1 = touchevent.getY();
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    x2 = touchevent.getX();
                    y2 = touchevent.getY();

                    //if left to right sweep event on screen
                    if (x1 < x2) {
                        arrayNum--;
                    }

                    // if right to left sweep event on screen
                         if (arrayNum < aantalWoorden) {

                             if (x1 > x2) {
                                 arrayNum++;
                             }
                             //Set layout
                         }
                    setItems();


                    break;

            }
        }
            return false;

    }

    public  void setItems(){

        TextView nlw = (TextView) findViewById(R.id.nederlands); //nederlands woord afgekort met nlw
        TextView amw = (TextView) findViewById(R.id.vertaling); // amazich woor afgekoort met amw
        ImageView img = (ImageView) findViewById(R.id.imageView);
        final MediaPlayer mp = MediaPlayer.create(this, geluid[arrayNum]);

        nlw.setText(woorden[arrayNum] );
        amw.setText(vertaling[arrayNum] );

        img.setImageResource(photos[arrayNum]);
        mp.start();


    }


}
