package com.example.gameproject.Objects;

import android.graphics.Paint;

public abstract class GameObject
{
    protected double x;
    protected double y;
    protected Paint paint;
    protected int currHealth = 100;
    protected int maxHealth = 100;
    protected double velocityX;
    protected double velocityY;

    public GameObject(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    protected int getCurrHealth()
    {
        return currHealth;
    }

    protected int getMaxHealth()
    {
        return maxHealth;
    }
}
