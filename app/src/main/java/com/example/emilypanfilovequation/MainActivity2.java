package com.example.emilypanfilovequation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private Button back;
    private ImageView parabola;
    private TextView answer;
    private float a,b,c,delta;
    private String solution1,solution2;
    Intent gi=getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        back=(Button) findViewById(R.id.back);
        parabola=(ImageView) findViewById(R.id.parabola);
        answer=findViewById(R.id.answer);
        back.setBackgroundColor(Color.rgb(0,255,250));
        a=gi.getFloatExtra("a",0);
        b=gi.getFloatExtra("b",0);
        c=gi.getFloatExtra("c",0);
        delta=b*b-4*a*c;
        if (delta==0 && a>0){
            parabola.setImageResource(R.drawable.parabola1);
        }
        if (delta>0 && a>0){
            parabola.setImageResource(R.drawable.parabola2);
        }
        if (delta<0 && a>0){
            parabola.setImageResource(R.drawable.parabola3);
        }
        if (delta==0 && a<0){
            parabola.setImageResource(R.drawable.parabola4);
        }
        if (delta>0 && a<0){
            parabola.setImageResource(R.drawable.parabola5);
        }
        if (delta<0 && a<0){
            parabola.setImageResource(R.drawable.parabola6);
        }
        if (delta==0){
            solution1=(Float.valueOf(-b)+Math.sqrt(delta))/(2*a)+"";
            solution2="no solution";
        }
        if (delta>0){
            solution1=(Float.valueOf(-b)+Math.sqrt(delta))/(2*a)+"";
            solution2=(Float.valueOf(-b)-Math.sqrt(delta))/(2*a)+"";
        }
        if (delta<0){
            solution1="no solution";
            solution2="no solution";
        }
        answer.setText("X1="+solution1+" , "+"X2="+solution2);

    }

    public void back(View view) {
        gi.putExtra("answer1",solution1);
        gi.putExtra("answer2",solution2);
        setResult(Activity.RESULT_OK,gi);
        finish();
    }
}