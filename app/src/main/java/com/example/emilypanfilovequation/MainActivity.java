package com.example.emilypanfilovequation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText etA,etB,etC;
    private Button random,solve;
    Random rnd=new Random();
    String strA,strB,strC;
    float numA,numB,numC;
    private final int REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etA=(EditText) findViewById(R.id.etA);
        etB=(EditText) findViewById(R.id.etB);
        etC=(EditText) findViewById(R.id.etC);
        random=(Button) findViewById(R.id.random);
        solve=(Button) findViewById(R.id.solve);
        random.setBackgroundColor(Color.rgb(0,255,250));
        solve.setBackgroundColor(Color.rgb(0,255,250));
    }

    public void random(View view) {
        etA.setText(rnd.nextFloat()*401-200+"");
        etB.setText(rnd.nextFloat()*401-200+"");
        etC.setText(rnd.nextFloat()*401-200+"");
    }

    public void go(View view) {
        strA=etA.getText().toString();
        strB=etB.getText().toString();
        strC=etC.getText().toString();
        if(!strA.isEmpty() && !strB.isEmpty() && !strC.isEmpty()){
            numA=Float.parseFloat(strA);
            numB=Float.parseFloat(strB);
            numC=Float.parseFloat(strC);
            Intent si=new Intent(MainActivity.this, MainActivity2.class);
            si.putExtra("a",numA);
            si.putExtra("b",numB);
            si.putExtra("c",numC);
            startActivityForResult(si,REQUEST_CODE);
        }

    }
}