package com.example.gameproject.Graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.gameproject.R;

public class SpriteSheet
{
    private int SPRITE_WIDTH_PIXELS;
    private int SPRITE_HEIGHT_PIXELS;
    private Bitmap bitmap;

    public SpriteSheet(Context context, Bitmap bitmap, int SPRITE_WIDTH_PIXELS, int SPRITE_HEIGHT_PIXELS)
    {
        this.bitmap = bitmap;
        this.SPRITE_WIDTH_PIXELS = SPRITE_WIDTH_PIXELS;
        this.SPRITE_HEIGHT_PIXELS = SPRITE_HEIGHT_PIXELS;
    }

    public Sprite[] getPlayerSpriteArray()
    {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0, 1*SPRITE_WIDTH_PIXELS, SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0, 2*SPRITE_WIDTH_PIXELS, SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0, 3*SPRITE_WIDTH_PIXELS, SPRITE_HEIGHT_PIXELS));

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