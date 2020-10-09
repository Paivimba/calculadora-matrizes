package com.example.calculadoramatrizes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sistema4Activity extends AppCompatActivity {

    private EditText edtw1, edtx1, edty1, edtz1, edtInd1;
    private EditText edtw2, edtx2, edty2, edtz2, edtInd2;
    private EditText edtw3, edtx3, edty3, edtz3, edtInd3;
    private EditText edtw4, edtx4, edty4, edtz4, edtInd4;

    private Button calcular, limpar;

    private TextView tvResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema4);

        edtw1 = findViewById(R.id.edtS4w1);
        edtx1 = findViewById(R.id.edtS4x1);
        edty1 = findViewById(R.id.edtS4y1);
        edtz1 = findViewById(R.id.edtS4z1);
        edtInd1 = findViewById(R.id.edtS4inde);

        edtw2 = findViewById(R.id.edtS4w2);
        edtx2 = findViewById(R.id.edtS4x2);
        edty2 = findViewById(R.id.edtS4y2);
        edtz2 = findViewById(R.id.edtS4z2);
        edtInd2 = findViewById(R.id.edtS4inde2);

        edtw3 = findViewById(R.id.edtS4w3);
        edtx3 = findViewById(R.id.edtS4x3);
        edty3 = findViewById(R.id.edtS4y3);
        edtz3 = findViewById(R.id.edtS4z3);
        edtInd3 = findViewById(R.id.edtS4Inde3);

        edtw4 = findViewById(R.id.edtS4w4);
        edtx4 = findViewById(R.id.edtS4x4);
        edty4 = findViewById(R.id.edtS4y4);
        edtz4 = findViewById(R.id.edtS4z4);
        edtInd4 = findViewById(R.id.edtS4inde4);

        calcular = findViewById(R.id.buttonCalcS4);
        limpar = findViewById(R.id.buttonLimpaSis4);

        tvResul = findViewById(R.id.tvResulS4);


        /** Evento dos botões **/
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                if(inputMethodManager.isActive())
                    inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                if(edtx1.getText().toString().isEmpty() || edty1.getText().toString().isEmpty() || edtx2.getText().toString().isEmpty() ||
                        edty2.getText().toString().isEmpty() || edtInd1.getText().toString().isEmpty() || edtInd2.getText().toString().isEmpty() ||
                        edtz1.getText().toString().isEmpty() || edtz2.getText().toString().isEmpty() || edtx3.getText().toString().isEmpty() ||
                        edty3.getText().toString().isEmpty() || edtz3.getText().toString().isEmpty() || edtw1.getText().toString().isEmpty() ||
                        edtw2.getText().toString().isEmpty() || edtw3.getText().toString().isEmpty() || edtw3.getText().toString().isEmpty() ||
                        edtw4.getText().toString().isEmpty() || edtx4.getText().toString().isEmpty() || edty4.getText().toString().isEmpty() ||
                        edtz4.getText().toString().isEmpty() || edtInd3.getText().toString().isEmpty() || edtInd4.getText().toString().isEmpty()){
                    Toast.makeText(Sistema4Activity.this, "Digite todos os campos para calcular", Toast.LENGTH_SHORT).show();
                }else{
                    float [][] coeficientes = new float[4][4];
                    coeficientes[0][0] = Float.parseFloat(edtw1.getText().toString());
                    coeficientes[0][1] = Float.parseFloat(edtx1.getText().toString());
                    coeficientes[0][2] = Float.parseFloat(edty1.getText().toString());
                    coeficientes[0][3] = Float.parseFloat(edtz1.getText().toString());

                    coeficientes[0][0] = Float.parseFloat(edtw2.getText().toString());
                    coeficientes[1][1] = Float.parseFloat(edtx2.getText().toString());
                    coeficientes[1][2] = Float.parseFloat(edty2.getText().toString());
                    coeficientes[1][3] = Float.parseFloat(edtz2.getText().toString());

                    coeficientes[0][0] = Float.parseFloat(edtw3.getText().toString());
                    coeficientes[2][1] = Float.parseFloat(edtx3.getText().toString());
                    coeficientes[2][2] = Float.parseFloat(edty3.getText().toString());
                    coeficientes[2][3] = Float.parseFloat(edtz3.getText().toString());

                    coeficientes[3][0] = Float.parseFloat(edtw4.getText().toString());
                    coeficientes[3][1] = Float.parseFloat(edtx4.getText().toString());
                    coeficientes[3][2] = Float.parseFloat(edty4.getText().toString());
                    coeficientes[3][3] = Float.parseFloat(edtz4.getText().toString());

                    float [] termosIndependentes = new float[4];
                    termosIndependentes[0] = Float.parseFloat(edtInd1.getText().toString());
                    termosIndependentes[1] = Float.parseFloat(edtInd2.getText().toString());
                    termosIndependentes[2] = Float.parseFloat(edtInd3.getText().toString());
                    termosIndependentes[3] = Float.parseFloat(edtInd4.getText().toString());

                    SistemaLinear s = new SistemaLinear(coeficientes, termosIndependentes);

                    tvResul.setText("Resultado: \n" + s.getSolucao());
                }
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos(); //Chama o método responsável por limpar os campos
            }
        });
    }

    private void limpaCampos() {
        edtw1.setText("");
        edtx1.setText("");
        edty1.setText("");
        edtz1.setText("");
        edtw2.setText("");
        edtx2.setText("");
        edty2.setText("");
        edtz2.setText("");
        edtw3.setText("");
        edtx3.setText("");
        edty3.setText("");
        edtz3.setText("");
        edtw4.setText("");
        edtx4.setText("");
        edty4.setText("");
        edtz4.setText("");
        edtInd1.setText("");
        edtInd2.setText("");
        edtInd3.setText("");
        edtInd4.setText("");
    }
}