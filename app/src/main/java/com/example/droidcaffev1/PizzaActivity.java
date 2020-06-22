package com.example.droidcaffev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TextViewCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaActivity extends AppCompatActivity {
ImageView imageView;
TextView title,description;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        imageView=findViewById(R.id.pizza);
        title=findViewById(R.id.pizzatitle);
        description=findViewById(R.id.pizzasub);
        toolbar = findViewById(R.id.pizzatoolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
