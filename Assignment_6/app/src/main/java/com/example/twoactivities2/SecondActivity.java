package com.example.twoactivities2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtMess;
    Button btnReply;
    EditText edtReply;

    public static final String REPLY_MESSAGE = "com.example.twoactivities2.extra.MESSAGE_REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent callIntent = getIntent();
        String mess = callIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        txtMess = findViewById(R.id.text_message);
        txtMess.setText(mess);

        edtReply = findViewById(R.id.edtReply);

        btnReply = findViewById(R.id.btnReply);
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent(SecondActivity.this,MainActivity.class);
                String mess = edtReply.getText().toString();
                replyIntent.putExtra(REPLY_MESSAGE,mess);
                setResult(RESULT_OK,replyIntent);
                finish();
            }
        });
    }
}