package com.example.sivak.login_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText ed1;
    private static EditText ed2;
    private static TextView tv;
    private static Button btn;
    int attempt = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        tv = findViewById(R.id.textView4);
        btn = findViewById(R.id.button);

        tv.setText(Integer.toString(attempt));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals("user") && ed2.getText().toString().equals("pass")) {
                    Toast.makeText(MainActivity.this, "The user name and the password is correct", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(i);


                } else {
                    Toast.makeText(MainActivity.this, "The entered username and the password is incorrect", Toast.LENGTH_SHORT).show();
                    attempt--;
                    tv.setText(Integer.toString(attempt));
                    if (attempt == 0) {
                        btn.setEnabled(false);
                    }
                }
            }
        });
    }
}
