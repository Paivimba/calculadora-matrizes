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

public class Sistema3Activity extends AppCompatActivity {

    private EditText edtx1, edty1, edtz1, edtInd1;
    private EditText edtx2, edty2, edtz2, edtInd2;
    private EditText edtx3, edty3, edtz3, edtInd3;

    private Button calcular, limpar;

    private TextView tvResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema3);

        edtx1 = findViewById(R.id.edtS3x1);
        edty1 = findViewById(R.id.edtS3y1);
        edtz1 = findViewById(R.id.edtS3z1);
        edtInd1 = findViewById(R.id.edtS3inde);

        edtx2 = findViewById(R.id.edtS3x2);
        edty2 = findViewById(R.id.edtS3y2);
        edtz2 = findViewById(R.id.edtS3z2);
        edtInd2 = findViewById(R.id.edtS3inde2);

        edtx3 = findViewById(R.id.edtS3x3);
        edty3 = findViewById(R.id.edtS3y3);
        edtz3 = findViewById(R.id.edtS3z3);
        edtInd3 = findViewById(R.id.edtS3Inde3);

        calcular = findViewById(R.id.buttonCalcS3);
        limpar = findViewById(R.id.buttonLimpaSis3);

        tvResul = findViewById(R.id.tvResulS3);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                if(imm.isActive())
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                if(edtx1.getText().toString().isEmpty() || edty1.getText().toString().isEmpty() || edtInd3.getText().toString().isEmpty() || edtx2.getText().toString().isEmpty() || edty2.getText().toString().isEmpty() || edtInd1.getText().toString().isEmpty() || edtInd2.getText().toString().isEmpty() || edtz1.getText().toString().isEmpty() || edtz2.getText().toString().isEmpty() || edtx3.getText().toString().isEmpty() || edty3.getText().toString().isEmpty() || edtz3.getText().toString().isEmpty()){
                    Toast.makeText(Sistema3Activity.this, "Digite todos os campos para calcular", Toast.LENGTH_SHORT).show();
                }else{
                    float [][] coeficientes = new float[3][3];
                    coeficientes[0][0] = Float.parseFloat(edtx1.getText().toString());
                    coeficientes[0][1] = Float.parseFloat(edty1.getText().toString());
                    coeficientes[0][2] = Float.parseFloat(edtz1.getText().toString());


                    coeficientes[1][0] = Float.parseFloat(edtx2.getText().toString());
                    coeficientes[1][1] = Float.parseFloat(edty2.getText().toString());
                    coeficientes[1][2] = Float.parseFloat(edtz2.getText().toString());

                    coeficientes[2][0] = Float.parseFloat(edtx3.getText().toString());
                    coeficientes[2][1] = Float.parseFloat(edty3.getText().toString());
                    coeficientes[2][2] = Float.parseFloat(edtz3.getText().toString());

                    float [] termosIndependentes = new float[3];
                    termosIndependentes[0] = Float.parseFloat(edtInd1.getText().toString());
                    termosIndependentes[1] = Float.parseFloat(edtInd2.getText().toString());
                    termosIndependentes[2] = Float.parseFloat(edtInd3.getText().toString());

                    SistemaLinear s = new SistemaLinear(coeficientes, termosIndependentes);

                    tvResul.setText("Resultado: \n" + s.getSolucao());
                }
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
            }
        });
    }

    private void limparCampos() {
        edtx1.setText("");
        edty1.setText("");
        edtz1.setText("");
        edtx2.setText("");
        edty2.setText("");
        edtz2.setText("");
        edtx3.setText("");
        edty3.setText("");
        edtz3.setText("");
        edtInd1.setText("");
        edtInd2.setText("");
        edtInd3.setText("");
    }
}