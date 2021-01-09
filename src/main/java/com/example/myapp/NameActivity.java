package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        btn = findViewById(R.id.button2);
        text = findViewById(R.id.editTextTextPersonName);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent();
        intent.putExtra("name", text.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}