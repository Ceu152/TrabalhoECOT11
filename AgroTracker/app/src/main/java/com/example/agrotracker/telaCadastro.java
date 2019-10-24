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
                        System.out.println(position);
                        Intent intent = new Intent(selectedItemView.getContext(), cadastroEmpresa.class);
                        startActivity(intent);
                        break;
                    case 2:
                        break;
                    case 3:
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
