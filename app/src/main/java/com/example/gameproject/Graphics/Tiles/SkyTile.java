package com.example.gameproject.Graphics.Tiles;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.gameproject.Graphics.Sprite;
import com.example.gameproject.Graphics.SpriteSheet;

public class SkyTile extends Tile {
    private final Sprite sprite;

    public SkyTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getSkySprite();
        setType(TileType.SKY_TILE);
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
