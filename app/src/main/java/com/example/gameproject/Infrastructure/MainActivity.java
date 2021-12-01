package com.example.gameproject.Infrastructure;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gameproject.R;


public class MainActivity extends AppCompatActivity
{
    MediaPlayer bkgrdmsc;
    //upon button click
    public void OnTap(View view) {
        setContentView(new Game(this));
        bkgrdmsc=MediaPlayer.create(MainActivity.this, R.raw.bakground);
        bkgrdmsc.setLooping(true);
        bkgrdmsc.start();
    }
    public void OnTap2(View view) {setContentView(R.layout.layout);}
    public void OnTap3(View view) {setContentView(R.layout.activity_main);}

    private enum STATE{
        MENU,
        GAME
    }

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
    @Override
    protected void onPause(){
        super.onPause();
        bkgrdmsc.release();
        finish();
    }
}