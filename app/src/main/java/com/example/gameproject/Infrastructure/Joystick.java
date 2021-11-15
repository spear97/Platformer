package com.example.gameproject.Infrastructure;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick
{
    private int outerCircleCenterPositionX;
    private int outerCircleCenterPositionY;
    private int innerCircleCenterPositionX;
    private int innerCircleCenterPositionY;
    private final int outerCircleRadius;
    private final int innerCircleRadius;

    private Paint outerCirclePaint;
    private Paint innerCirclePaint;
    private double joystickCenterToTouchDistance;
    private boolean isPressed;
    private double actuatorX;
    private double actuatorY;

    public Joystick(int centerPositionX, int centerPositionY, int outerCircleRadius, int innerCircleRadius)
    {
        //Outer and inner circle make up the joystick
        outerCircleCenterPositionX = centerPositionX;
        outerCircleCenterPositionY = centerPositionY;
        innerCircleCenterPositionX = centerPositionX;
        innerCircleCenterPositionY = centerPositionY;

        // Radii of circles
        this.outerCircleRadius = outerCircleRadius;
        this.innerCircleRadius = innerCircleRadius;

        // paint of circles
        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void draw(Canvas canvas)
    {
        //Draw Outer Circle
        canvas.drawCircle(outerCircleCenterPositionX,
                          outerCircleCenterPositionY,
                          outerCircleRadius,
                          outerCirclePaint);

        //Draw Inner Circle
        canvas.drawCircle(innerCircleCenterPositionX,
                          innerCircleCenterPositionY,
                          innerCircleRadius,
                          innerCirclePaint);
    }

    public void update()
    {
        //Update the Position of the Inner for each Tick (or Frame)
        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition()
    {
        //Set the Inner Circle's X Position
        innerCircleCenterPositionX = (int)(outerCircleCenterPositionX + actuatorX*outerCircleRadius);

        //Set the Inner Circle's Y Position
        innerCircleCenterPositionY = (int)(outerCircleCenterPositionY + actuatorY*outerCircleRadius);
    }

    public boolean isPressed(double touchPositionX, double touchPositionY)
    {
        //Calculate the Distance between the Touch Position and the Outer Circle's Position
        joystickCenterToTouchDistance = Math.sqrt(
                Math.pow(outerCircleCenterPositionX-touchPositionX,2) +
                Math.pow(outerCircleCenterPositionY-touchPositionY,2)
        );
        return joystickCenterToTouchDistance < outerCircleRadius;
    }

    //Switch to Indicate the Joystick is being Pressed
    public void setIsPressed(boolean isPressed)
    {
        this.isPressed = isPressed;
    }

    //Retrieve the current Value of IsPressed
    public boolean getIsPressed()
    {
        return isPressed;
    }

    public void setActuator(double touchPositionX, double touchPositionY)
    {
        //Calculate the Distance between the Touch Position and the Outer Circle's Position
        double deltaX = touchPositionX - outerCircleCenterPositionX;
        double deltaY = touchPositionY - outerCircleCenterPositionY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));

        //If deltaDistance is less than the size of the Outer Circle
        if(deltaDistance < outerCircleRadius)
        {
            actuatorX = deltaX/outerCircleRadius;
            actuatorY = deltaY/outerCircleRadius;
        }

        //If deltaDistance is greater than the size of the Outer Circle
        else
        {
            actuatorX = deltaX/deltaDistance;
            actuatorY = deltaY/deltaDistance;
        }
    }

    //Reset the Position of the inner Circle
    public void resetActuator()
    {
        //Set ActuatorX to 0.0
        actuatorX = 0.0;

        //Set ActuatorY to 0.0
        actuatorY = 0.0;
    }

    //Retrieve the value of actuatorX
    public double getActuatorX()
    {
        return actuatorX;
    }

    //Retrieve the value of actuatorY
    public double getActuatorY()
    {
        return actuatorY;
    }
}
