package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtWeb = null;
    Button btnWeb = null;
    EditText edtLocation = null;
    Button btnLocation = null;
    EditText edtShare = null;
    Button btnShare = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeb = findViewById(R.id.website_edittext);
        btnWeb = findViewById(R.id.open_website_button);
        edtLocation = findViewById(R.id.location_edittext);
        btnLocation = findViewById(R.id.open_location_button);
        edtShare = findViewById(R.id.share_edittext);
        btnShare = findViewById(R.id.share_text_button);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtWeb.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                    e.printStackTrace();
                }
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = edtLocation.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                    e.printStackTrace();
                }
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edtShare.getText().toString();
                String mimeType = "text/plain";
                new ShareCompat
                        .IntentBuilder(MainActivity.this)
                        .setType("text/plain")
                        .setChooserTitle("Share text with: ")
                        .setText(txt)
                        .startChooser();
            }
        });

    }
}