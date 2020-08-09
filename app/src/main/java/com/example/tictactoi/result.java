package com.example.tictactoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent it=getIntent();
        String winner=it.getStringExtra("com.example.tictactoi.EXTRA");
        TextView t=findViewById(R.id.textView);
        assert winner != null;
        if(winner.equals("Game Draw"))
        {
            t.setText(winner+" ");
        }else {
            t.setText(t.getText()+" "+winner);
        }

    }
    public void back_to(View v)
    {
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
    }
}