package com.example.gameproject.Infrastructure;

import android.graphics.Rect;

public class LevelBounds
{
    private Rect bound;

    public LevelBounds(Rect bound)
    {
        this.bound = bound;
    }

    public boolean atLeft(int x)
    {
        if(x == bound.left)
        {
            return true;
        }
        return false;
    }

    public boolean atRight(int x)
    {
        if(x == bound.right)
        {
            return true;
        }
        return false;
    }

    public boolean atTop(int y)
    {
        if(y == bound.top)
        {
            return true;
        }
        return false;
    }

    public boolean atBottom(int y)
    {
        if(y == bound.bottom)
        {
            return true;
        }
        return false;
    }
}
