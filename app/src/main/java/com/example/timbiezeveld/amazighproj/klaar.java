package com.example.timbiezeveld.amazighproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class klaar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klaar);

        String text = getIntent().getStringExtra("extra_text");
      //  String text = "hoi";
       TextView score = (TextView) findViewById(R.id.textView2); //
        score.setText(text);


    }

    public void terug(View v){
            Intent intent = new Intent(this, CatogoryQuiz.class);
        startActivity(intent);

    }

}
