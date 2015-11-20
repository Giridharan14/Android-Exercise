package com.giridharan.fsignup1;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Main2Activity extends AppCompatActivity {
    Button load_img;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;
    TextView e1,e2,e3;
    String img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        e1=(TextView)findViewById(R.id.textView);
        e2=(TextView)findViewById(R.id.textView2);
        e3=(TextView)findViewById(R.id.textView3);
        e1.setText(bundle.getString("ONE"));
        e2.setText(bundle.getString("TWO"));
        e3.setText(bundle.getString("Four"));
        img1=bundle.getString("Three");
        String text= bundle.getString("ONE");
        text=text +" "+ bundle.getString("TWO");
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT).show();
        img = (ImageView)findViewById(R.id.img);
        new LoadImage().execute(img1);

    }

private class LoadImage extends AsyncTask<String, String, Bitmap> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(Main2Activity.this);
        pDialog.setMessage("Loading Image ....");
        pDialog.show();

    }
    protected Bitmap doInBackground(String... args) {
        try {
        URL image_value = new URL(img1);
            bitmap = BitmapFactory.decodeStream(image_value.openConnection().getInputStream());
//bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;

    }

    protected void onPostExecute(Bitmap image) {

        if(image != null){
            img.setImageBitmap(image);
            pDialog.dismiss();

        }else{

            pDialog.dismiss();
            Toast.makeText(Main2Activity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

        }
    }
}

}