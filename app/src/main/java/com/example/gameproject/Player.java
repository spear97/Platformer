package com.example.gameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import androidx.core.content.ContextCompat;

public class Player
{

    private double x;
    private double y;
    private double r;
    private Paint paint;

    public Player(Context context, double x, double y, double r)
    {
        this.x = x;
        this.y = y;
        this.r = r;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle((float) x, (float) y, (float) r, paint);
    }

    public void update()
    {

    }

    public void setPosition(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}
