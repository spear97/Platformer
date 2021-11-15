package com.example.gameproject.Objects.AI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.gameproject.Infrastructure.GameLoop;
import com.example.gameproject.Objects.GameObject;
import com.example.gameproject.R;

public class Enemy extends GameObject
{
    private static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/ GameLoop.MAX_UPS;
    private double r;


    public Enemy(Context context, double x, double y, double r)
    {
        super(x, y);
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
}