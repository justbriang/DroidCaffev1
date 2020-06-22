package com.example.droidcaffev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DonutActivity extends AppCompatActivity {
private TextView title,description;
private ImageView image;
Toolbar toolbar;
String TAG="Donut activity";
View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        toolbar=findViewById(R.id.dtoolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        image=findViewById(R.id.donutimg);
        title=findViewById(R.id.titledn);
        description=findViewById(R.id.dondes);
        title.setText(getIntent().getStringExtra("Dtitle"));
        description.setText(getIntent().getStringExtra("Ddescription"));
        int test=getIntent().getIntExtra("Dimg",1);
        Log.e(TAG, "onCreate: "+test );
        Glide.with(this).load(test).into(image);



    }
}
