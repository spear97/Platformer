package com.example.gameproject.Infrastructure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.R;

public class Performance
{
    private GameLoop gameLoop;
    private Context context;

    public Performance(Context context, GameLoop gameLoop)
    {
        this.context = context;
        this.gameLoop = gameLoop;
    }

    public void draw(Canvas canvas)
    {
        drawUPS(canvas);
        drawFPS(canvas);
    }

    public void drawUPS(Canvas canvas)
    {
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS: " + averageUPS, 100, 100, paint);
    }

    public void drawFPS(Canvas canvas)
    {
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: " + averageFPS, 100, 200, paint);
    }

    public void drawPlayerX(Canvas canvas, double x)
    {
        String averageFPS = Double.toString(x);
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Y: " + averageFPS, 100, 300, paint);
    }

    public void drawJoystickX(Canvas canvas, double x)
    {
        String averageFPS = Double.toString(x);
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("YActuator: " + averageFPS, 100, 400, paint);
    }
}