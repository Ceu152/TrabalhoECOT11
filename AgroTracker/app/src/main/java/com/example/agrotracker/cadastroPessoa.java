package com.example.agrotracker;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class cadastroPessoa extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_pessoa);
        this.onConfirmation();
    }

    private void onConfirmation(){
        ImageButton confirm = findViewById(R.id.prodConfirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), cadastroPessoa.class);
                startActivity(intent3);
            }
        });
    }
}
