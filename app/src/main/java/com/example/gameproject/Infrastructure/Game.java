package com.example.gameproject.Infrastructure;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.Graphics.Animator;
import com.example.gameproject.Graphics.SpriteSheet;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
    private final GameOver gameOver;
    private final Performance performance;
    private final Player player;
    private final GameDisplay gameDisplay;
    private GameLoop gameLoop;
    private Joystick joystick;
    private int height;
    private int width;

    public Game(Context context)
    {
        super(context);

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        // Get the height and width of the Device Game is Launched on
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        // Set gameLoop to be able to handle Execution of Game Functionality
        gameLoop = new GameLoop(surfaceHolder, this);

        // Initialize UI
        performance = new Performance(context, gameLoop);
        gameOver = new GameOver(context);
        joystick = new Joystick(275, 700, 70, 40);

        // Initialize game objects
        SpriteSheet spriteSheet = new SpriteSheet(context);
        Animator animator = new Animator(spriteSheet.getPlayerSpriteArray());
        player = new Player(context, joystick, 2*500, 500, 32, animator);

        // Initialize display and center it around the player
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels, player);
        
        // Enable view's focus event for touch mode
        setFocusable(true);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder)
    {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2)
    {
        Log.d("Game.java", "surfaceChanged()");
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder)
    {
        Log.d("Game.java", "surfaceDestroyed()");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // Handle user input touch event actions
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(joystick.isPressed((double)event.getX(), (double)event.getY()))
                {
                    joystick.setIsPressed(true);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed())
                {
                    joystick.setActuator((double)event.getX(), (double)event.getY());
                }
                return true;
            case MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
                return true;
        }
        return super.onTouchEvent(event);
    }

    //Displays Content onto the Screen
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        performance.drawFPS(canvas);
        performance.drawUPS(canvas);

        joystick.draw(canvas);
        player.draw(canvas, gameDisplay);
    }

    public void update()
    {
        joystick.update();
        player.update();
    }
}