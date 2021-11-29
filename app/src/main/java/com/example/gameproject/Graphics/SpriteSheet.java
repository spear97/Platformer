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

    //Constructor that will use SPRITE_WIDTH_PIXELS and SPRITE_HEIGHT_PIXELS to keep Frames Organized
    //For Frames used to organize Animations and Particle Effects
    public SpriteSheet(Context context, Bitmap bitmap, int SPRITE_WIDTH_PIXELS, int SPRITE_HEIGHT_PIXELS)
    {
        this.bitmap = bitmap;
        this.SPRITE_WIDTH_PIXELS = SPRITE_WIDTH_PIXELS;
        this.SPRITE_HEIGHT_PIXELS = SPRITE_HEIGHT_PIXELS;
    }

    //Character Look of Player Character and Animations that Player will Perform
    public Sprite[] getPlayerSpriteArray()
    {
        Sprite[] spriteArray = new Sprite[8];
        spriteArray[0] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[3] = new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[4] = new Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[5] = new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[6] = new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[7] = new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        //spriteArray[8] = new Sprite(this, new Rect(0*128, 2*128, 1*128, 3*128));
        return spriteArray;
    }

    //Character Look of AI One and Animations that AI One will Perform
    public Sprite[] getAIOneSpriteArray()
    {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Character Look of AI Two and Animations that AI Two will Perform
    public Sprite[] getAITwoSpriteArray()
    {
        Sprite[] spriteArray = new Sprite[12];
        spriteArray[0] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[3] = new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[4] = new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 5*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[5] = new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 6*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[6] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[7] = new Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 2*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[8] = new Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 3*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[9] = new Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 4*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[10] = new Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 5*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[11] = new Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS, 1*SPRITE_WIDTH_PIXELS, 6*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Projectile Effect Look that AI Two Could Fire
    public Sprite[] getAITwoSpriteProjArray()
    {
        Sprite[] spriteArray = new Sprite[6];
        spriteArray[0] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new  Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new  Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[3] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[4] = new  Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[5] = new  Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Character Look of AI Three and Animations that AI Three will Perform
    public Sprite[] getAIThreeSpriteArray()
    {
        Sprite[] spriteArray = new Sprite[28];
        spriteArray[0] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new  Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new  Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[3] = new  Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[4] = new  Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 5*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[5] = new  Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 6*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[6] = new  Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 7*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[7] = new  Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 8*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[8] = new  Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 9*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[9] = new  Sprite(this, new Rect(9*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 10*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[10] = new  Sprite(this, new Rect(10*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 11*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[11] = new  Sprite(this, new Rect(11*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 12*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[12] = new  Sprite(this, new Rect(12*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 13*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[13] = new  Sprite(this, new Rect(13*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 14*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[14] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[15] = new  Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[16] = new  Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[17] = new  Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[18] = new  Sprite(this, new Rect(4*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 5*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[19] = new  Sprite(this, new Rect(5*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 6*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[20] = new  Sprite(this, new Rect(6*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 7*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[21] = new  Sprite(this, new Rect(7*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 8*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[22] = new  Sprite(this, new Rect(8*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 9*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[23] = new  Sprite(this, new Rect(9*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 10*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[24] = new  Sprite(this, new Rect(10*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 11*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[25] = new  Sprite(this, new Rect(11*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 12*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[26] = new  Sprite(this, new Rect(12*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 13*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[27] = new  Sprite(this, new Rect(13*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 14*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Projectile Effect Look that AI Three Could Fire
    public Sprite[] getAIThreeProjArray()
    {
        Sprite[] spriteArray = new Sprite[10];
        spriteArray[0] = new  Sprite(this, new Rect(14*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 15*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new  Sprite(this, new Rect(15*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 16*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new  Sprite(this, new Rect(16*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 17*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[3] = new  Sprite(this, new Rect(17*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 18*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[4] = new  Sprite(this, new Rect(18*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 19*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[5] = new  Sprite(this, new Rect(14*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 15*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[6] = new  Sprite(this, new Rect(15*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 16*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[7] = new  Sprite(this, new Rect(16*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 17*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[8] = new  Sprite(this, new Rect(17*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 18*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[9] = new  Sprite(this, new Rect(18*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 19*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Character Look of Boss and Animations that Boss will Perform
    public Sprite[] getAIBossArray()
    {
        Sprite[] spriteArray = new Sprite[6];
        spriteArray[0] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new  Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[2] = new  Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[3] = new  Sprite(this, new Rect(0*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 1*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[4] = new  Sprite(this, new Rect(1*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 2*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        spriteArray[5] = new  Sprite(this, new Rect(2*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 3*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Projectile Effect Look that Boss Three Could Fire
    public Sprite[] getAIBossProjArray()
    {
        Sprite[] spriteArray = new Sprite[2];
        spriteArray[0] = new  Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 0*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS));
        spriteArray[1] = new  Sprite(this, new Rect(3*SPRITE_WIDTH_PIXELS, 1*SPRITE_HEIGHT_PIXELS, 4*SPRITE_WIDTH_PIXELS, 2*SPRITE_HEIGHT_PIXELS));
        return spriteArray;
    }

    //Return the Bitmap that is being used by SpriteSheet
    public Bitmap getBitmap() {
        return bitmap;
    }

    //Return a Dirt Tile
    public Sprite getDirtSprite() {
        return getSpriteByIndex(0, 0);
    }

    //Return a Grass Tile
    public Sprite getGrassSprite() {
        return getSpriteByIndex(0, 1);
    }

    //Return a Sky Sprite
    public Sprite getSkySprite() {
        return getSpriteByIndex(0, 2);
    }

    //Return a Water Sprite
    public Sprite getWaterSprite(){return getSpriteByIndex(0,3);}

    //Return a Sprite on the Sprite Sheet based on the row and column it exists on
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