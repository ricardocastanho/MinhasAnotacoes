package com.example.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private static final String ARQUIVO_PREFERNCIAL = "Arquivo Preferencial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERNCIAL, 0);
                SharedPreferences.Editor editor = preferences.edit();

                String texto = editText.getText().toString();
                editor.putString("texto", texto);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Anotação Salva", Toast.LENGTH_LONG).show();
            }
        });
        //Recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERNCIAL, 0);

        //Valida se temos o "texto" em preferencias
        if (preferences.contains("texto")) {
            String texto = preferences.getString("texto", "");
            editText.setText(texto);
        }
    }
}
