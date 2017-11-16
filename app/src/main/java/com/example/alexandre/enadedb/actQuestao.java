package com.example.alexandre.enadedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class actQuestao extends AppCompatActivity {

    Button btAlternativa ;
    Button btProxima;
    String letra;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_questao);
        btAlternativa = findViewById(R.id.btAlternativas);
        btProxima = findViewById(R.id.btProx);
        btAlternativa.setOnClickListener(CallAlt);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){
        super.onActivityResult(requestCode,resultCode, Data);
        if(requestCode==0 & resultCode==RESULT_OK){
            letra = Data.getStringExtra("Resultado");
            texto = Data.getStringExtra("Texto");
            btAlternativa.setText(texto);
        }
    }

    View.OnClickListener CallAlt = view -> {
        Toast.makeText(this, "Aqui funciona", Toast.LENGTH_SHORT).show();
        Intent alt = new Intent(actQuestao.this, actAlternativa.class);
        startActivityForResult(alt,0);
    };

}
