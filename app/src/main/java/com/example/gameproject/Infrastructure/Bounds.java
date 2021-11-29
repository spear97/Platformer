package com.example.gameproject.Infrastructure;

import android.graphics.Rect;

public class Bounds
{
    //The Bounds for the World
    private int left = 47, right = 9555, top=54, bottom=2488;

    public Bounds() {/*Constructor*/}

    //Is Location the Left Location?
    public boolean atLeft(int x)
    {
        if(x==left)
        {
            return true;
        }
        return false;
    }

    //Is Location the Right Location?
    public boolean atRight(int x)
    {
        if(x==right)
        {
            return true;
        }
        return false;
    }

    //Is Location the Top Location?
    public boolean atTop(int y)
    {
        if(y==top)
        {
            return true;
        }
        return false;
    }

    //Is Location the Bottom Location?
    public boolean atBottom(int y)
    {
        if(y==bottom)
        {
            return true;
        }
        return false;
    }
}