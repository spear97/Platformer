package com.example.gameproject.object;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.gameproject.R;

/*
* Circle is an abstract class which implements a draw method from GameObject
* drawing the object as a circle.
*/
public abstract class Circle extends GameObject
{
    protected double r;
    protected Paint paint;

    public Circle(Context context, double x, double y, double r)
    {
        super(x, y);
        this.r = r;

        //Set color of Circles
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle((float) x, (float) y, (float)r, paint);
    }
}
