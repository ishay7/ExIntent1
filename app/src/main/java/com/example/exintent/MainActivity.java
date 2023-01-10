package com.example.exintent;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //details
    EditText lname, fname, adress;
    Button submit;

    //camera
    Bitmap bitmap;
    Button camera;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //details
        lname = (EditText) findViewById(R.id.ETlname);
        fname = (EditText) findViewById(R.id.ETfname);
        adress = (EditText) findViewById(R.id.ETadress);
        submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);

        //camera
        iv = (ImageView)findViewById(R.id.iv);
        camera = (Button) findViewById(R.id.btnCamera);
        camera.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == submit)
        {
            Intent intent = new Intent(this, Second.class);
            intent.putExtra("lname", lname.getText().toString());
            intent.putExtra("fname", fname.getText().toString());
            intent.putExtra("adress", adress.getText().toString());
            intent.putExtra("bitmap", bitmap);
            startActivity(intent);
        }
        else if(view == camera)
        {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0)//details
        {
            if(resultCode==RESULT_OK)
            {
                bitmap= (Bitmap)data.getExtras().get("data");
                iv.setImageBitmap(bitmap);
            }
        }
    }
}