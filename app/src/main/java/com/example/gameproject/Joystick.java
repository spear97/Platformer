package com.example.gameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Joystick
{
    private double outerX;
    private double outerY;
    private double outerR;
    private Paint outerPaint;

    private double innerX;
    private double innerY;
    private double innerR;
    private Paint innerPaint;
    private boolean isPressed;

    public Joystick(Context context, double x, double y, double r1, double r2)
    {
        outerX = x;
        outerY = y;
        outerR = r1;

        outerPaint = new Paint();
        outerPaint.setColor(Color.GRAY);
        outerPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerX = x;
        innerY = y;
        innerR = r2;

        innerPaint = new Paint();
        innerPaint.setColor(Color.BLUE);
        innerPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle((float) outerX, (float) outerY, (float) outerR, outerPaint);
        canvas.drawCircle((float) innerX, (float) innerY, (float) innerR, innerPaint);
    }

    public void update()
    {

    }

    public void setActuator(double x, double y)
    {
        innerX = x;
        innerY = y;
    }

    public void setIsPressed(boolean b)
    {
        isPressed = b;
    }

    public boolean getPressed()
    {
        return isPressed;
    }

    public void resetActuator()
    {
        innerX = outerX;
        innerY = outerY;
    }

    public double dist(double x, double y)
    {
        return Math.sqrt(Math.pow(x - outerX, 2) + Math.pow(y - outerY, 2));
    }

    public double getInnerX()
    {
        return innerX;
    }

    public double getOuterX()
    {
        return outerX;
    }

}
