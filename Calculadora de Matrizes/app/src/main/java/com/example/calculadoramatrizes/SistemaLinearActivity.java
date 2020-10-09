package com.example.calculadoramatrizes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SistemaLinearActivity extends AppCompatActivity {

    CardView cv2x2, cv3x3, cv4x4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_linear);

        cv2x2 = findViewById(R.id.cv2x2);
        cv3x3 = findViewById(R.id.cv3x3);
        cv4x4 = findViewById(R.id.cv4x4);

        cv2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaLinearActivity.this, Sistema2Activity.class)); //Abre tela Sistema 2x2
            }
        });

        cv3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaLinearActivity.this, Sistema3Activity.class)); //Abre tela Sistema 3x3
            }
        });

        cv4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaLinearActivity.this, Sistema4Activity.class)); //Abre tela Sistema 4x4
            }
        });

    }
}