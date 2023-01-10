package com.example.exintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Second extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;

    //details
    TextView tv;

    //camera
    Bitmap bitmap;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnBack = (Button)findViewById((R.id.btnBack));
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);

        btnBack.setOnClickListener(this);

        Intent intent = getIntent();
        String fname = intent.getExtras().getString("fname");
        String lname = intent.getExtras().getString("lname");
        String adress = intent.getExtras().getString("adress");
        bitmap = (Bitmap)intent.getParcelableExtra("bitmap");

        tv.setText(fname + lname + ", Your adress: " + adress);
        iv.setImageBitmap(bitmap);


    }

    @Override
    public void onClick(View view) {
        if(view == btnBack)
        {
            finish();
        }
    }
}