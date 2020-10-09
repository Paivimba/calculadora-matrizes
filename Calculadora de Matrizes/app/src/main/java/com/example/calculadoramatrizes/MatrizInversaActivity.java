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

public class MatrizInversaActivity extends AppCompatActivity {
    private EditText edtA11, edtA12, edtA13, edtA14,
                     edtA21, edtA22, edtA23, edtA24,
                     edtA31, edtA32, edtA33, edtA34,
                     edtA41, edtA42, edtA43, edtA44;


    private Button calcular, limpar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz_inversa);

        edtA11 = findViewById(R.id.editTextNumberMI);
        edtA12 = findViewById(R.id.editTextNumber3MI);
        edtA13 = findViewById(R.id.editTextNumber5MI);
        edtA14 = findViewById(R.id.editTextNumber4MI);

        edtA21 = findViewById(R.id.editTextNumber6MI);
        edtA22 = findViewById(R.id.editTextNumber7MI);
        edtA23 = findViewById(R.id.editTextNumber8MI);
        edtA24 = findViewById(R.id.editTextNumber9MI);

        edtA31 = findViewById(R.id.editTextNumber10MI);
        edtA32 = findViewById(R.id.editTextNumber11MI);
        edtA33 = findViewById(R.id.editTextNumber12MI);
        edtA34 = findViewById(R.id.editTextNumber13MI);

        edtA41 = findViewById(R.id.editTextNumber14MI);
        edtA42 = findViewById(R.id.editTextNumber15MI);
        edtA43 = findViewById(R.id.editTextNumber16MI);
        edtA44 = findViewById(R.id.editTextNumber17MI);

        calcular = findViewById(R.id.buttonCalculaMI);
        limpar = findViewById(R.id.buttonLimpaInversa);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                if(imm.isActive())
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                if (edtA11.getText().toString().isEmpty()) {
                    edtA11.setError("Digite pelo menos a11");
                } else if (edtA12.getText().toString().isEmpty() && edtA22.getText().toString().isEmpty() && edtA21.getText().toString().isEmpty() &&
                           edtA12.getText().toString().isEmpty() || edtA22.getText().toString().isEmpty() && edtA21.getText().toString().isEmpty() &&
                           edtA14.getText().toString().isEmpty() && edtA24.getText().toString().isEmpty() && edtA34.getText().toString().isEmpty() &&
                           edtA44.getText().toString().isEmpty() && edtA43.getText().toString().isEmpty() && edtA42.getText().toString().isEmpty() &&
                           edtA41.getText().toString().isEmpty() && edtA12.getText().toString().isEmpty() && edtA22.getText().toString().isEmpty() &&
                           edtA21.getText().toString().isEmpty() && edtA13.getText().toString().isEmpty() && edtA23.getText().toString().isEmpty() &&
                           edtA33.getText().toString().isEmpty() && edtA32.getText().toString().isEmpty() && edtA31.getText().toString().isEmpty()){

                        //Matriz 1x1
                        float[][] matriz = new float[1][1];
                        matriz[0][0] = Float.parseFloat(edtA11.getText().toString());
                        Inversa i = new Inversa(matriz);
                        float[][] resul = i.getInversa();
                        edtA11.setText(Float.toString(resul[0][0]));

                } else if (edtA13.getText().toString().isEmpty() && edtA23.getText().toString().isEmpty() && edtA33.getText().toString().isEmpty() &&
                        edtA32.getText().toString().isEmpty() && edtA31.getText().toString().isEmpty() && edtA14.getText().toString().isEmpty() &&
                        edtA24.getText().toString().isEmpty() && edtA34.getText().toString().isEmpty() && edtA44.getText().toString().isEmpty() &&
                        edtA43.getText().toString().isEmpty() && edtA42.getText().toString().isEmpty() && edtA41.getText().toString().isEmpty()) {
                    if (edtA12.getText().toString().isEmpty() || edtA22.getText().toString().isEmpty() || edtA21.getText().toString().isEmpty()) {
                        Toast.makeText(MatrizInversaActivity.this, "Digite uma matriz quadrada", Toast.LENGTH_SHORT).show();
                    } else {
                        //Matriz 2x2
                        float[][] matriz = new float[2][2];
                        matriz[0][0] = Float.parseFloat(edtA11.getText().toString());
                        matriz[0][1] = Float.parseFloat(edtA12.getText().toString());
                        matriz[1][0] = Float.parseFloat(edtA21.getText().toString());
                        matriz[1][1] = Float.parseFloat(edtA22.getText().toString());

                        Inversa i = new Inversa(matriz);
                        float[][] resul = i.getInversa();
                        edtA11.setText(Float.toString(resul[0][0]));
                        edtA12.setText(Float.toString(resul[0][1]));
                        edtA21.setText(Float.toString(resul[1][0]));
                        edtA22.setText(Float.toString(resul[1][1]));
                    }
                } else if (edtA14.getText().toString().isEmpty() && edtA24.getText().toString().isEmpty() && edtA34.getText().toString().isEmpty() &&
                        edtA44.getText().toString().isEmpty() && edtA43.getText().toString().isEmpty() && edtA42.getText().toString().isEmpty() && edtA41.getText().toString().isEmpty()) {
                    if (edtA12.getText().toString().isEmpty() || edtA22.getText().toString().isEmpty() || edtA21.getText().toString().isEmpty() ||
                            edtA13.getText().toString().isEmpty() || edtA23.getText().toString().isEmpty() || edtA33.getText().toString().isEmpty() ||
                            edtA32.getText().toString().isEmpty() || edtA31.getText().toString().isEmpty()) {
                        Toast.makeText(MatrizInversaActivity.this, "Digite uma matriz quadrada", Toast.LENGTH_SHORT).show();
                    } else {
                        //Matriz 3x3
                        float[][] matriz = new float[3][3];
                        matriz[0][0] = Float.parseFloat(edtA11.getText().toString());
                        matriz[0][1] = Float.parseFloat(edtA12.getText().toString());
                        matriz[0][2] = Float.parseFloat(edtA13.getText().toString());
                        matriz[1][0] = Float.parseFloat(edtA21.getText().toString());
                        matriz[1][1] = Float.parseFloat(edtA22.getText().toString());
                        matriz[1][2] = Float.parseFloat(edtA23.getText().toString());
                        matriz[2][0] = Float.parseFloat(edtA31.getText().toString());
                        matriz[2][1] = Float.parseFloat(edtA32.getText().toString());
                        matriz[2][2] = Float.parseFloat(edtA33.getText().toString());

                        Inversa i = new Inversa(matriz);
                        float[][] resul = i.getInversa();
                        edtA11.setText(Float.toString(resul[0][0]));
                        edtA12.setText(Float.toString(resul[0][1]));
                        edtA13.setText(Float.toString(resul[0][2]));
                        edtA21.setText(Float.toString(resul[1][0]));
                        edtA22.setText(Float.toString(resul[1][1]));
                        edtA23.setText(Float.toString(resul[1][2]));
                        edtA31.setText(Float.toString(resul[2][0]));
                        edtA32.setText(Float.toString(resul[2][1]));
                        edtA33.setText(Float.toString(resul[2][2]));
                    }
                } else if (!(edtA14.getText().toString().isEmpty() && edtA24.getText().toString().isEmpty() && edtA34.getText().toString().isEmpty() && edtA44.getText().toString().isEmpty() &&
                        edtA43.getText().toString().isEmpty() && edtA42.getText().toString().isEmpty() && edtA41.getText().toString().isEmpty() && edtA12.getText().toString().isEmpty() &&
                        edtA22.getText().toString().isEmpty() && edtA21.getText().toString().isEmpty() && edtA13.getText().toString().isEmpty() &&
                        edtA23.getText().toString().isEmpty() && edtA33.getText().toString().isEmpty() && edtA32.getText().toString().isEmpty() && edtA31.getText().toString().isEmpty())) {
                    if (edtA14.getText().toString().isEmpty() || edtA24.getText().toString().isEmpty() || edtA34.getText().toString().isEmpty() || edtA44.getText().toString().isEmpty() ||
                            edtA43.getText().toString().isEmpty() || edtA42.getText().toString().isEmpty() || edtA41.getText().toString().isEmpty() || edtA12.getText().toString().isEmpty() &&
                            edtA22.getText().toString().isEmpty() || edtA21.getText().toString().isEmpty() || edtA13.getText().toString().isEmpty() ||
                            edtA23.getText().toString().isEmpty() || edtA33.getText().toString().isEmpty() || edtA32.getText().toString().isEmpty() || edtA31.getText().toString().isEmpty()) {
                        Toast.makeText(MatrizInversaActivity.this, "Digite uma matriz quadrada", Toast.LENGTH_SHORT).show();
                    } else {

                        //Matriz 4x4
                        float[][] matriz = new float[4][4];
                        matriz[0][0] = Float.parseFloat(edtA11.getText().toString());
                        matriz[0][1] = Float.parseFloat(edtA12.getText().toString());
                        matriz[0][2] = Float.parseFloat(edtA13.getText().toString());
                        matriz[0][3] = Float.parseFloat(edtA14.getText().toString());
                        matriz[1][0] = Float.parseFloat(edtA21.getText().toString());
                        matriz[1][1] = Float.parseFloat(edtA22.getText().toString());
                        matriz[1][2] = Float.parseFloat(edtA23.getText().toString());
                        matriz[1][3] = Float.parseFloat(edtA24.getText().toString());
                        matriz[2][0] = Float.parseFloat(edtA31.getText().toString());
                        matriz[2][1] = Float.parseFloat(edtA32.getText().toString());
                        matriz[2][2] = Float.parseFloat(edtA33.getText().toString());
                        matriz[2][3] = Float.parseFloat(edtA34.getText().toString());
                        matriz[3][0] = Float.parseFloat(edtA41.getText().toString());
                        matriz[3][1] = Float.parseFloat(edtA42.getText().toString());
                        matriz[3][2] = Float.parseFloat(edtA43.getText().toString());
                        matriz[3][3] = Float.parseFloat(edtA44.getText().toString());

                        Inversa i = new Inversa(matriz);
                        float[][] resul = i.getInversa();
                        edtA11.setText(Float.toString(resul[0][0]));
                        edtA12.setText(Float.toString(resul[0][1]));
                        edtA13.setText(Float.toString(resul[0][2]));
                        edtA14.setText(Float.toString(resul[0][3]));
                        edtA21.setText(Float.toString(resul[1][0]));
                        edtA22.setText(Float.toString(resul[1][1]));
                        edtA23.setText(Float.toString(resul[1][2]));
                        edtA24.setText(Float.toString(resul[1][3]));
                        edtA31.setText(Float.toString(resul[2][0]));
                        edtA32.setText(Float.toString(resul[2][1]));
                        edtA33.setText(Float.toString(resul[2][2]));
                        edtA34.setText(Float.toString(resul[2][3]));
                        edtA41.setText(Float.toString(resul[3][0]));
                        edtA42.setText(Float.toString(resul[3][1]));
                        edtA43.setText(Float.toString(resul[3][2]));
                        edtA44.setText(Float.toString(resul[3][3]));
                    }

                }else{
                    Toast.makeText(MatrizInversaActivity.this, "Digite uma matriz quadrada", Toast.LENGTH_SHORT).show();
                }

            }

        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });

    }

    private void limpaCampos() {
            edtA11.setText("");
            edtA12.setText("");
            edtA13.setText("");
            edtA14.setText("");
            edtA21.setText("");
            edtA22.setText("");
            edtA23.setText("");
            edtA24.setText("");
            edtA31.setText("");
            edtA32.setText("");
            edtA33.setText("");
            edtA34.setText("");
            edtA41.setText("");
            edtA42.setText("");
            edtA43.setText("");
            edtA44.setText("");
    }
}