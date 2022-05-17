package com.example.droidcoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView donutImg = null;
    ImageView iceImg = null;
    ImageView froyoImg = null;
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";
    String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImg = findViewById(R.id.donut);
        donutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.donut_order_message);
                Toast.makeText(getApplicationContext(), "donut_order_message", Toast.LENGTH_SHORT).show();
            }
        });
        iceImg = findViewById(R.id.ice_cream);
        iceImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.ice_cream_order_message);
                Toast.makeText(getApplicationContext(), "ice_order_message", Toast.LENGTH_SHORT).show();
            }
        });
        froyoImg = findViewById(R.id.froyo);
        froyoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.froyo_order_message);
                Toast.makeText(getApplicationContext(), "froyo_order_message", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClick(View view) {
        Intent intent =
                new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
}