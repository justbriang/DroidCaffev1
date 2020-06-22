package com.example.droidcaffev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BurgerActivity extends AppCompatActivity {
    ImageView imageView;
    TextView title,description;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);
        imageView=findViewById(R.id.burger);
        title=findViewById(R.id.burgertitle);
        description=findViewById(R.id.burgersub);
        toolbar = findViewById(R.id.burgertoolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
