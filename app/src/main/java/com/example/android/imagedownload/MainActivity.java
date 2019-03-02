package com.example.android.imagedownload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
ImageView downld;
    public void hry(View view)  {
        Log.d("hry","testing");
DownloadImage h=new DownloadImage();
Bitmap b;

try {
    b = h.execute("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwik58Ly79_gAhXMwI8KHRGoAu0QjRx6BAgBEAU&url=%2Furl%3Fsa%3Di%26source%3Dimages%26cd%3D%26ved%3D%26url%3Dhttps%253A%252F%252Fwww.pexels.com%252Fsearch%252Fnature%252F%26psig%3DAOvVaw0Y3s9DTqdiAAdg2G1ODcns%26ust%3D1551492979023202&psig=AOvVaw0Y3s9DTqdiAAdg2G1ODcns&ust=1551492979023202").get();
    Log.d("b","testing");

    downld.setImageBitmap(b);
}
catch (Exception e){
    e.printStackTrace();
}
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
downld=(ImageView) findViewById(R.id.imagevew);
        }
        public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

            @Override
            protected Bitmap doInBackground(String... strings) {

                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection urlConnection;
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.connect();
                    InputStream in = urlConnection.getInputStream();
                    Bitmap mybitmap = BitmapFactory.decodeStream(in);


                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return null;
            }

        }
    }



