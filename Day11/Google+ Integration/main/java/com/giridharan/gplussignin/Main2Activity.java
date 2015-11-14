package com.giridharan.gplussignin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.InputStream;
import java.net.URL;
public class Main2Activity extends AppCompatActivity {
    Button load_img;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;
    TextView e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String img1;
        Bundle bundle = getIntent().getExtras();
        e1=(TextView)findViewById(R.id.textView);
        e2=(TextView)findViewById(R.id.textView2);
        e3=(TextView)findViewById(R.id.textView3);
        e1.setText(bundle.getString("ONE"));
        e2.setText(bundle.getString("TWO"));
        e3.setText(bundle.getString("Three"));
        img1=bundle.getString("Four");
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
            bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
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