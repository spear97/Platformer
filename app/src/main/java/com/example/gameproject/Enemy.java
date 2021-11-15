package com.example.gameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import androidx.core.content.ContextCompat;

public class Enemy
{
    private static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/GameLoop.MAX_UPS;
    private double x;
    private double y;
    private double r;
    private Paint paint;
    private double velocityX;
    private double velocityY;


    public Enemy(Context context, double x, double y, double r)
    {
        this.x = x;
        this.y = y;
        this.r = r;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.evil);
        paint.setColor(color);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle((float) x, (float) y, (float) r, paint);
    }

    public void update()
    {
        x += MAX_SPEED;
    }

    public void setPosition(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}