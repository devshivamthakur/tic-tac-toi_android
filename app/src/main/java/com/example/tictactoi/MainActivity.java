package com.example.tictactoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
int player =1;p
int gamestate[]={2,2,2,2,2,2,2,2,2};
int winpos[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void playertab(View v)
{
    ImageView img=(ImageView)v;
    int tapped=Integer.parseInt(img.getTag().toString());
    if(gamestate[tapped]==2)
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

       if(gamestate[arr[0]]!=2&&gamestate[arr[1]]!=2&&gamestate[arr[1]]!=2&&gamestate[arr[2]]!=2)
       {

           if (gamestate[arr[0]] == gamestate[arr[1]] && gamestate[arr[1]] == gamestate[arr[2]])
           {
               Toast.makeText(this, String.valueOf(player) + " is win", Toast.LENGTH_LONG).show();
               for(int i=0;i<9;i++)
               {
                   gamestate[i]=0;
               }


           }
       }
    }
    if(gamestate[0]!=2&&gamestate[1]!=2&& gamestate[2]!=2 && gamestate[3]!=2 && gamestate[4]!=2 && gamestate[5]!=2 && gamestate[6]!=2 && gamestate[7]!=2&& gamestate[8]!=2)
    {
        Toast.makeText(getApplicationContext()," game draw",Toast.LENGTH_LONG).show();
    }

}

}