package com.example.tictactoi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static final String mess="com.example.tictactoi.EXTRA";
    public static final String draw="com.example.tictactoi.EXTRA";
    String winner="";
int player =1;
int gamestate[]={3,3,3,3,3,3,3,3,3};
int winpos[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,3,6},{2,5,8}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void playertab(View v)
{
    ImageView img=(ImageView)v;
    int tapped=Integer.parseInt(img.getTag().toString());
    if(gamestate[tapped]==3)
    {

        gamestate[tapped]=player;
        if(player==1)
        {
            img.setImageResource(R.drawable.x);
            player=2;
        }
        else if(player==2)
        {
            img.setImageResource(R.drawable.o);
            player=1;
        }
    }
    System.out.println(Arrays.toString(gamestate));
    for(int arr[]:winpos)
    {

       if(gamestate[arr[0]]!=3&&gamestate[arr[1]]!=3&&gamestate[arr[1]]!=3&&gamestate[arr[2]]!=3)
       {

           if (gamestate[arr[0]] == gamestate[arr[1]] && gamestate[arr[1]] == gamestate[arr[2]])

           {
               if(player==2)
               {
                   winner=String.valueOf(1);
               }
               else {
                   winner=String.valueOf(2);
               }
               try {
                   Intent it=new Intent(getApplicationContext(),result.class);
                   it.putExtra(mess,winner);
                   Thread.sleep(36);
                   startActivity(it);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }




           }
       }
    }
    if(gamestate[0]!=3&&gamestate[1]!=3&& gamestate[2]!=3 && gamestate[3]!=3 && gamestate[4]!=3 && gamestate[5]!=3 && gamestate[6]!=3 && gamestate[7]!=3&& gamestate[8]!=3)
    {
        Intent it=new Intent(getApplicationContext(),result.class);
        it.putExtra(draw,"Game Draw");
        startActivity(it);
    }

}

}