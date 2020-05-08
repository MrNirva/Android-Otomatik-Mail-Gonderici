package com.harun.otomatikmailgonderici;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// https://harun.xyz/

public class MainActivity extends AppCompatActivity {

    private EditText aliciMail, konu, icerik;
    private Button buttonMailYollaNormal, buttonMailYollaEkli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aliciMail = findViewById(R.id.aliciMail);
        konu = findViewById(R.id.konu);
        icerik = findViewById(R.id.icerik);

        buttonMailYollaNormal = findViewById(R.id.buttonMailYollaNormal);
        buttonMailYollaEkli = findViewById(R.id.buttonMailYollaEkli);

        buttonMailYollaNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // MailGonderici nesnemizi oluşturduğumuz kısım
                MailGonderici mg = new MailGonderici(MainActivity.this, aliciMail.getText().toString(), konu.getText().toString(), icerik.getText().toString());

                // Mail Gönderme işlemini başlattığımız nokta
                mg.execute();

            }
        });

        buttonMailYollaEkli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // MailGonderici nesnemizi oluşturduğumuz kısım
                EkliMailGonderici eg = new EkliMailGonderici(MainActivity.this, aliciMail.getText().toString(), konu.getText().toString(), icerik.getText().toString());

                // Mail Gönderme işlemini başlattığımız nokta
                eg.execute();

            }
        });

    }
}
