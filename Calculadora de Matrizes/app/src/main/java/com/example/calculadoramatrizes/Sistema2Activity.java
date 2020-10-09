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

public class Sistema2Activity extends AppCompatActivity {

    private EditText edtx1, edty1, edtInd1;
    private EditText edtx2, edty2, edtInd2;

    private Button calcular, limpar;

    private TextView tvResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema2);

        edtx1 = findViewById(R.id.edtS2x1);
        edty1 = findViewById(R.id.edtS2y1);
        edtInd1 = findViewById(R.id.edtS2inde);
        edtx2 = findViewById(R.id.edtS2x2);
        edty2 = findViewById(R.id.edtS2y2);
        edtInd2 = findViewById(R.id.edtS2inde2);

        calcular = findViewById(R.id.buttonCalcS2);
        limpar = findViewById(R.id.buttonLimpaSis2);

        tvResul = findViewById(R.id.tvResulS2);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                if(imm.isActive())
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                if(edtx1.getText().toString().isEmpty() || edty1.getText().toString().isEmpty() || edtx2.getText().toString().isEmpty() || edty2.getText().toString().isEmpty() || edtInd1.getText().toString().isEmpty() || edtInd2.getText().toString().isEmpty()){
                    Toast.makeText(Sistema2Activity.this, "Digite todos os campos para calcular", Toast.LENGTH_SHORT).show();
                }else{
                    float [][] coeficientes = new float[2][2];
                    coeficientes[0][0] = Float.parseFloat(edtx1.getText().toString());
                    coeficientes[0][1] = Float.parseFloat(edty1.getText().toString());


                    coeficientes[1][0] = Float.parseFloat(edtx2.getText().toString());
                    coeficientes[1][1] = Float.parseFloat(edty2.getText().toString());

                    float [] termosIndependentes = new float[2];
                    termosIndependentes[0] = Float.parseFloat(edtInd1.getText().toString());
                    termosIndependentes[1] = Float.parseFloat(edtInd2.getText().toString());

                    SistemaLinear s = new SistemaLinear(coeficientes, termosIndependentes);

                    tvResul.setText("Resultado: \n" + s.getSolucao());
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
        edtx1.setText("");
        edty1.setText("");
        edtx2.setText("");
        edty2.setText("");
        edtInd1.setText("");
        edtInd2.setText("");
    }
}