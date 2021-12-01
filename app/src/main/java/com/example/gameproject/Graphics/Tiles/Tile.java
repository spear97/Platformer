package com.example.gameproject.Graphics.Tiles;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.Graphics.SpriteSheet;

public abstract class Tile
{
    public enum TileType
    {
        DIRT_TILE, // 0
        GRASS_TILE, // 1
        SKY_TILE, // 2
        WATER_TILE // 3
    }
    public Rect mapLocationRect;
    private TileType type;

    public Tile(Rect mapLocationRect)
    {
        this.mapLocationRect = mapLocationRect;
    }

    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect)
    {
        switch(TileType.values()[idxTileType])
        {
            case DIRT_TILE:
                return new DirtTile(spriteSheet, mapLocationRect);
            case GRASS_TILE:
                return new GrassTile(spriteSheet, mapLocationRect);
            case SKY_TILE:
                return new SkyTile(spriteSheet, mapLocationRect);
            case WATER_TILE:
                return new WaterTile(spriteSheet, mapLocationRect);
            default:
                return null;
        }
    }

    public void setType(TileType type){this.type = type;}

    public TileType getType()
    {
        return type;
    }

    public abstract void draw(Canvas canvas);
}
