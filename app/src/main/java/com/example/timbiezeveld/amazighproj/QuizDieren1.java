package com.example.timbiezeveld.amazighproj;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizDieren1 extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> mixlist = new ArrayList<Integer>();


    private int[] photos = {
            R.drawable.dieren01_egel, R.drawable.dieren01_ezel, R.drawable.dieren01_geit, R.drawable.dieren01_hond, R.drawable.dieren01_jakhals, R.drawable.dieren01_kat,
            R.drawable.dieren01_kikker, R.drawable.dieren01_kip, R.drawable.dieren01_koe, R.drawable.dieren01_konijn, R.drawable.dieren01_muis, R.drawable.dieren01_paard, R.drawable.dieren01_schaap, R.drawable.dieren01_vis, R.drawable.dieren01_vogel
    };


    private String[] vertaling = {
            "Insi", "Aɣyul", "Tɣaṭṭ",
            "Ayḍi", "Uccen", "Mucc",
            "Aqaqriw", "Tyaziḍt", "Tafunast",
            "Aqninni", "Aɣerda", "Ayis",
            "Icerri", "Aslem", "Agḍiḍ"
    };
    private int[] geluid = {
            R.raw.dieren01_egel, R.raw.dieren01_ezel, R.raw.dieren01_geit, R.raw.dieren01_hond, R.raw.dieren01_jakhals, R.raw.dieren01_kat,
            R.raw.dieren01_kikker, R.raw.dieren01_kip, R.raw.dieren01_koe, R.raw.dieren01_konijn, R.raw.dieren01_muis, R.raw.dieren01_paard, R.raw.dieren01_schaap, R.raw.dieren01_vis, R.raw.dieren01_vogel
    };


    int quiznum;
    int aantalfout;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addTarr();

        quiznum = 0;
        score = 0;


        antPosition();

        loadImg();
        TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


        amw.setText(vertaling[quiznum]);


    }

    public void antPosition() {
        int[] layouts = new int[]{R.layout.activity_quiz, R.layout.activity_quiz1, R.layout.activity_quiz2, R.layout.activity_quiz3, R.layout.activity_quiz4, R.layout.activity_quiz5, R.layout.activity_quiz6,};

        setContentView(layouts[new Random().nextInt(layouts.length)]);
        setScore(0, true);
        final MediaPlayer mp = MediaPlayer.create(this, geluid[quiznum]);
        mp.start();

    }

    public void addTarr() {
        list.clear();
        list.add(R.drawable.dieren01_egel);
        list.add(R.drawable.dieren01_ezel);//
        list.add(R.drawable.dieren01_geit);
        list.add(R.drawable.dieren01_hond);
        list.add(R.drawable.dieren01_jakhals);
        list.add(R.drawable.dieren01_kat);
        list.add(R.drawable.dieren01_kikker);
        list.add(R.drawable.dieren01_kip);
        list.add(R.drawable.dieren01_koe);
        list.add(R.drawable.dieren01_konijn);
        list.add(R.drawable.dieren01_muis);
        list.add(R.drawable.dieren01_paard);
        list.add(R.drawable.dieren01_schaap);
        list.add(R.drawable.dieren01_vis);
        list.add(R.drawable.dieren01_vogel);
        list.remove(quiznum);

    }

    public void goedAntwoord() {
        setScore(2, false);
        if (quiznum < vertaling.length - 1) {
            aantalfout = 0;

            quiznum++;
            addTarr();

            antPosition();
            loadImg();

            TextView amw = (TextView) findViewById(R.id.amazighwoord); // amazich woor afgekoort met amw


            amw.setText(vertaling[quiznum]);


        } else {
            Intent intent = new Intent(QuizDieren1.this, klaar.class);
            intent.putExtra("extra_text", String.valueOf(this.score));

            startActivity(intent);


        }

    }


    public void setFout(int i, String k) {
        switch (i) {
            case 1:
                Button btn1 = (Button) findViewById(R.id.photo1); // amazich woor afgekoort met amw
                btn1.setBackgroundColor(Color.parseColor(k));

                break;
            case 2:
                Button btn2 = (Button) findViewById(R.id.photo2); // amazich woor afgekoort met amw
                btn2.setBackgroundResource(R.drawable.kruis);

                break;
            case 3:
                Button btn3 = (Button) findViewById(R.id.photo3); // amazich woor afgekoort met amw

                btn3.setBackgroundResource(R.drawable.kruis);
                break;
            case 4:
                Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
                btn4.setBackgroundResource(R.drawable.kruis);
                break;
            case 5:
                Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
                btn5.setBackgroundResource(R.drawable.kruis);
                break;
            case 6:
                Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
                btn6.setBackgroundResource(R.drawable.kruis);


        }
    }

    public void foutAntwoord(int i) {
        setFout(i, "#FF0000");
        setScore(-1, false);
    }


    public void clickAntwoord(View v) {
        switch (v.getId()) {
            case R.id.photo1:

                goedAntwoord();
                //setKleur(1,"#FFA477");
                break;
            case R.id.photo2:
                foutAntwoord(2);
                break;
            case R.id.photo3:
                foutAntwoord(3);
                break;
            case R.id.photo4:
                foutAntwoord(4);
                break;
            case R.id.photo5:
                foutAntwoord(5);
                break;
            case R.id.photo6:
                foutAntwoord(6);
                break;
        }
        aantalfout++;


    }

    public void loadImg() {
        Random rand = new Random();

        int n2;
        int n3;
        int n4;

        int n5;
        int n6;


        n2 = 1;

        n3 = 2;
        n4 = 3;

        n5 = 4;

        n6 = 5;


        Button btn1 = (Button) findViewById(R.id.photo1); // amazich woor afgekoort met amw
        btn1.setBackgroundResource(photos[quiznum]);

        Button btn2 = (Button) findViewById(R.id.photo2); // amazich woor afgekoort met amw
        btn2.setBackgroundResource(list.get(1));
        Button btn3 = (Button) findViewById(R.id.photo3); // amazich woor afgekoort met amw
        btn3.setBackgroundResource(list.get(4));
        Button btn4 = (Button) findViewById(R.id.photo4); // amazich woor afgekoort met amw
        btn4.setBackgroundResource(list.get(7));
        Button btn5 = (Button) findViewById(R.id.photo5); // amazich woor afgekoort met amw
        btn5.setBackgroundResource(list.get(5));
        Button btn6 = (Button) findViewById(R.id.photo6); // amazich woor afgekoort met amw
        btn6.setBackgroundResource(list.get(9));
    }


    public void setScore(int score, boolean aanpas) {

        this.score = this.score + score;
        TextView txt = (TextView) findViewById(R.id.score); // score view
        if (aanpas) {

            txt.setText("Score: " + String.valueOf(this.score));
        }
    }


}





