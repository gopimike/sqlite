package com.example.gopi.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText1;
Button button1,button2;
String s1;
database dataa;//kabali da

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);

        dataa=new database(this);
    }

    public void sav(View view) {
        s1=editText1.getText().toString();
        long a=dataa.savee(s1);
        Toast.makeText(this, "registered"+a, Toast.LENGTH_SHORT).show();
    }

    public void list(View view) {
        String s2=new String();

    }
}
