package com.example.gameproject.Graphics.Tiles;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.gameproject.Graphics.Sprite;
import com.example.gameproject.Graphics.SpriteSheet;

public class DirtTile extends Tile
{
    private final Sprite sprite;

    public DirtTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getDirtSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, getRect().left, getRect().top);
    }
}
