package com.example.gameproject.object;
import android.graphics.Canvas;

/*
* GameObject is an abstract class which is the foundation of all world objects
* in the game.
*/
public abstract class GameObject
{
    protected double x;
    protected double y;
    protected double velocityX;
    protected double velocityY;

    public GameObject(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Canvas canvas);
    public abstract void update();
}
