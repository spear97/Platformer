package com.example.gameproject.Graphics.Tiles;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.gameproject.Graphics.Sprite;
import com.example.gameproject.Graphics.SpriteSheet;

public class GrassTile extends Tile {
    private final Sprite sprite;

    public GrassTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getGrassSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
