package com.example.gameproject.GameObjects;

import android.graphics.Canvas;

import com.example.gameproject.Infrastructure.GameDisplay;

public abstract class GameObject
{
    protected double positionX, positionY = 0.0;
    protected double velocityX, velocityY = 0.0;
    protected double directionX = 1.0;
    protected double directionY = 0.0;
    protected boolean jump = false;
    protected boolean isAlive = true;

    public GameObject(double positionX, double positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double getPositionX() { return positionX; }
    public double getPositionY() { return positionY; }

    public double getDirectionX() { return directionX; }
    public double getDirectionY() { return directionY; }

    public abstract void draw(Canvas canvas, GameDisplay gameDisplay);
    public abstract void update();

    public boolean getJump() {return jump;}

    public void setJump(boolean x) {jump = x;}

    public boolean getIsAlive(){return isAlive;}

    public void setIsAlive(boolean x){isAlive = x;}

    /**
     * getDistanceBetweenObjects returns the distance between two game objects
     * @param obj1
     * @param obj2
     * @return
     */
    public static double getDistanceBetweenObjects(GameObject obj1, GameObject obj2)
    {
        return Math.sqrt(
                Math.pow(obj2.getPositionX() - obj1.getPositionX(), 2) +
                         Math.pow(obj2.getPositionY() - obj1.getPositionY(), 2));
    }
}