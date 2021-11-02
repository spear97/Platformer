package com.example.gameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
    private final Player player;
    private final Joystick joystick;
    private  GameLoop gameLoop;

    public Game(Context context)
    {
        super(context);

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        // Set gameLoop to be able to handle Execution of Game Functionality
        gameLoop = new GameLoop(surfaceHolder, this);

        //Initialize Player Character
        player = new Player(getContext(), 1000, 500, 30);
        
        //Initialize Joystick
        joystick = new Joystick(getContext(), 200, 1200, 100, 50);

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

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder)
    {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // Handle user input touch event actions
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                joystick.setIsPressed(true);
                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getPressed())
                {
                    joystick.setActuator((double) event.getX(), (double) event.getY());
                }
                return true;
            case MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
        }
        return super.onTouchEvent(event);
    }

    //Displays Content onto the Screen
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        drawFPS(canvas);
        drawUPS(canvas);

        joystick.draw(canvas);
        player.draw(canvas);
    }

    //Display the Number of Frames Per Second being Run
    public void drawFPS(Canvas canvas)
    {
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: " + averageFPS, 100, 50, paint);
    }

    //Display the Number of Updates Per Second being Run
    public void drawUPS(Canvas canvas)
    {
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS: " + averageUPS, 100, 200, paint);
    }

    public void update()
    {
        player.update();
    }
}
