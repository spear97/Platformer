package com.example.gameproject.Graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite
{
    private Bitmap bitmap;
    private Rect rect;
    private Rect transform;

    public Sprite(Context context, Bitmap bitmap, Rect rect)
    {
        this.bitmap = bitmap; //The Bitmap that will be used
        this.rect = rect;
        this.transform = rect;
    }

    //Draw the Sprite to the World
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap, rect, transform, null);
    }
}