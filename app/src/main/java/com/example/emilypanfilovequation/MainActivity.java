package com.example.emilypanfilovequation;

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
        etA.setText(rnd.nextDouble()*401-200+"");
        etB.setText(rnd.nextDouble()*401-200+"");
        etC.setText(rnd.nextDouble()*401-200+"");
    }
}