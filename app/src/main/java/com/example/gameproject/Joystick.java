package com.example.gameproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick
{
    private int outerRadius;
    private int innerRadius;
    private int outerCenterX;
    private int outerCenterY;
    private int innerCenterX;
    private int innerCenterY;
    private Paint innerPaint;
    private Paint outerPaint;
    private double CenterToTouchDistance;
    private boolean isPressed;
    private double actuatorX;
    private double actuatorY;

    public Joystick(int x, int y, int outerR, int innerR)
    {
        // Outer and inner circle make up the joystick
        outerCenterX = x;
        outerCenterY = y;
        innerCenterX = x;
        innerCenterY = y;

        // Radii of Circles
        outerRadius = outerR;
        innerRadius = innerR;

        // paint of circles
        outerPaint = new Paint();
        outerPaint.setColor(Color.GRAY);
        outerPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerPaint = new Paint();
        innerPaint.setColor(Color.LTGRAY);
        innerPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }
    public void draw(Canvas canvas)
    {
        // Draw outer circle
        canvas.drawCircle(outerCenterX, outerCenterY, outerRadius, outerPaint);

        // Draw inner circle
        canvas.drawCircle(innerCenterX, innerCenterY, innerRadius, innerPaint);
    }

    public void update()
    {
        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition()
    {
        innerCenterX = (int)(outerCenterX + actuatorX*outerRadius);
        innerCenterY = (int)(outerCenterY + actuatorY*outerRadius);
    }

    public boolean isPressed(double x, double y)
    {
        CenterToTouchDistance = Math.sqrt(Math.pow(outerCenterX - x, 2) + Math.pow(outerCenterY - y, 2));
        return CenterToTouchDistance < outerRadius;
    }

    public void setIsPressed(boolean isPressed)
    {
        this.isPressed = isPressed;
    }

    public boolean getIsPressed()
    {
        return isPressed;
    }

    public void setActuator(double x, double y)
    {
        double deltaX = x - outerCenterX;
        double deltaY = y - outerCenterX;
        double deltaDistance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if(deltaDistance < outerRadius)
        {
            actuatorX = deltaX / outerRadius;
            actuatorY = deltaY / outerRadius;
        }
        else
        {
            actuatorX = deltaX / deltaDistance;
            actuatorY = deltaY / deltaDistance;
        }
    }

    public void resetActuator()
    {
        actuatorX = 0.0;
        actuatorY = 0.0;
    }
}
