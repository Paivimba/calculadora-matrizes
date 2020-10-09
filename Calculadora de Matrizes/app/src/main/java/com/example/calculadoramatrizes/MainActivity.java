package com.example.calculadoramatrizes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView cvMatrizInversa,
                     cvDeterminante,
                     cvSistemaLinear,
                     cvSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvMatrizInversa = findViewById(R.id.cvMatrizInversa);
        cvDeterminante = findViewById(R.id.cvDeterminante);
        cvSistemaLinear = findViewById(R.id.cvSistemaLinear);
        cvSair = findViewById(R.id.cvSair);

        /**   EVENTO DO CARDVIEW MATRIZ INVERSA   **/
        cvMatrizInversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MatrizInversaActivity.class)); //Abre a activity referente ao botão apertado
            }
        });

        /**   EVENTO DO CARDVIEW DETERMINANTE   **/
        cvDeterminante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DeterminanteActivity.class)); //Abre a activity referente ao botão apertado
            }
        });

        /**   EVENTO DO CARDVIEW SISTEMA LINEAR   **/
        cvSistemaLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SistemaLinearActivity.class)); //Abre a activity referente ao botão apertado
            }
        });

        /**   EVENTO DO CARDVIEW SAIR   **/
        cvSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizar();
            }
        });
    }


    /** Método para fechar o app **/
    public void finalizar(){
        this.finish();
    }
}