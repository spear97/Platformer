package com.example.gameproject.Graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.gameproject.R;

public class SpriteSheet
{
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;
    private Bitmap bitmap;

    public SpriteSheet(Context context, Bitmap bitmap)
    {
        this.bitmap = bitmap;
    }

    public Sprite[] getPlayerSpriteArray()
    {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(0*64, 0, 1*64, 64));
        spriteArray[1] = new Sprite(this, new Rect(1*64, 0, 2*64, 64));
        spriteArray[2] = new Sprite(this, new Rect(2*64, 0, 3*64, 64));
        return spriteArray;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Sprite getDirtSprite() {
        return getSpriteByIndex(0, 0);
    }

    public Sprite getGrassSprite() {
        return getSpriteByIndex(0, 1);
    }

    public Sprite getSkySprite() {
        return getSpriteByIndex(0, 2);
    }

    public Sprite getWaterSprite(){return getSpriteByIndex(0,3);}

    private Sprite getSpriteByIndex(int idxRow, int idxCol)
    {
        return new Sprite(this, new Rect(
                idxCol*SPRITE_WIDTH_PIXELS,
                idxRow*SPRITE_HEIGHT_PIXELS,
                (idxCol + 1)*SPRITE_WIDTH_PIXELS,
                (idxRow + 1)*SPRITE_HEIGHT_PIXELS
        ));
    }
}