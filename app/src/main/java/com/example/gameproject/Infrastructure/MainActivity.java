package com.example.gameproject.Infrastructure;


import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameproject.R;


public class MainActivity extends AppCompatActivity
{
    //upon button click
    public void OnTap(View view) {
        setContentView(new Game(this));
    }

    private enum STATE{
        MENU,
        GAME
    };

    //use STATE variable to check what State we are in
    private STATE State=STATE.MENU;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Set window to fullscreen (will hide status bar)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(State==STATE.GAME) {
            //Set ContentView to Game, so that objects in the Game Class can be rendered to the Screen
            setContentView(new Game(this));
        }
        else if(State==STATE.MENU){
            setContentView(R.layout.activity_main);
        }
    }
}