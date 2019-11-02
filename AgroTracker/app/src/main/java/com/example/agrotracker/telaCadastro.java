package com.example.agrotracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.agrotracker.ui.login.LoginActivity;
import com.example.agrotracker.ui.login.LoginActivityKt;


public class telaCadastro extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        this.spinnerMenu();
    }

    private void spinnerMenu(){
        Spinner dropdown = findViewById(R.id.cadSpinner1);
        String[] items = new String[]{"Selecione", "Empresa", "Produtor Rural", "Consumidor"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_txt, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch(position){
                    case 0:
                        break;
                    case 1:
                        Intent intent1 = new Intent(selectedItemView.getContext(), cadastroEmpresa.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(selectedItemView.getContext(), cadastroProdutor.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(selectedItemView.getContext(), cadastroPessoa.class);
                        startActivity(intent3);
                        break;
                    default:

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}
