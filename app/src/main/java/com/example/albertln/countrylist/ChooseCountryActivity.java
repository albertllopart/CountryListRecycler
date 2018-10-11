package com.example.albertln.countrylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseCountryActivity extends AppCompatActivity {

    public static final int CHOOSE_COUNTRY = 0;

    //Model
    private String country;

    private Button btn_choose;
    private TextView country_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country);

        country = "";

        country_view = findViewById(R.id.country_view);
        country_view.setText(country);

        btn_choose = findViewById(R.id.btn_choose);
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cridem CountryListActivity esperant un resultat
                Intent intent = new Intent(ChooseCountryActivity.this, CountryListActivity.class);
                intent.putExtra("country", country); //informem del país seleccionat a l'altra activitat
                startActivityForResult(intent, CHOOSE_COUNTRY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            /*Recollim el resultat d'haver cridat countryListActivity*/
            case CHOOSE_COUNTRY:
                if (resultCode == RESULT_OK) {
                    country = data.getStringExtra("country");
                    country_view.setText(country);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
