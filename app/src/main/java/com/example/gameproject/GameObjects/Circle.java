package com.example.gameproject.GameObjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.gameproject.Graphics.Sprite;
import com.example.gameproject.Graphics.Tiles.SkyTile;
import com.example.gameproject.Graphics.Tiles.Tile;
import com.example.gameproject.Graphics.Tiles.Tilemap;
import com.example.gameproject.Infrastructure.GameDisplay;
import static com.example.gameproject.Graphics.Tiles.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.gameproject.Graphics.Tiles.MapLayout.TILE_WIDTH_PIXELS;

import java.util.List;

public abstract class Circle extends GameObject
{
    protected double radius;
    protected Paint paint;
    protected Tilemap world;
    protected List<Tile> tiles;

    public Circle(Context context, int color, double positionX, double positionY, double radius, Tilemap world)
    {
        super(positionX, positionY);
        this.radius = radius;

        // Set colors of circle
        paint = new Paint();
        paint.setColor(color);

        //The World that Circle would be Interacting with
        this.world = world;
    }

    /**
     * isColliding checks if two circle objects are colliding, based on their positions and radii.
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean isColliding(Circle obj1, Circle obj2)
    {
        double distance = getDistanceBetweenObjects(obj1, obj2);
        double distanceToCollision = obj1.getRadius() + obj2.getRadius();
        if (distance < distanceToCollision) {
            return true;
        }
        else
            return false;
    }

    public Tile getTileCollision(Sprite sprite, double newX, double newY)
    {
        double fromX = Math.min(getPositionX(), newX);
        double fromY = Math.min(getPositionY(), newY);
        double toX = Math.max(getPositionX(), newX);
        double toY = Math.max(getPositionY(), newY);

        // get the tile locations
        int fromTileX = (int)(TILE_WIDTH_PIXELS*fromX);
        int fromTileY = (int)(TILE_HEIGHT_PIXELS*fromY);
        int toTileX = (int)(TILE_WIDTH_PIXELS*(toX + sprite.getWidth() - 1));
        int toTileY = (int)(TILE_HEIGHT_PIXELS*(toY + sprite.getHeight() - 1));

        // check each tile for a collision
        Tile[][] tilemap = world.getTileMap();
        for (int x=fromTileX; x<=toTileX; x++) {
            for (int y=fromTileY; y<=toTileY; y++) {
                if (x < 0 || x >= tilemap[0].length /*|| world.getTile(x, y).TileType[] !=*/)
                {
                    // collision found, return the tile
                    return world.getTile(x, y);
                }
            }
        }
        // no collision found
        return null;
    }

   /* public static boolean gravity(Circle obj1, Circle obj2){
        if(collisionDown == false) {
            characterYnext = characterY + fall;          //Get Next Position
            if(NextMovementCollides()){                  //Basically if next position is too far.
                characterYnext += difference_between(CharacterY,Ground);     //This should move the character to the ground state.
                fall = 0;                                                   //No longer falling so reset the value.
            }
            else{
                characterY += fall; fall++;     //Otherwise continue falling like normal.
            }
        }
    }*/

    public void draw(Canvas canvas, GameDisplay gameDisplay)
    {
        canvas.drawCircle(
                (float) gameDisplay.gameToDisplayCoordinatesX(positionX),
                (float) gameDisplay.gameToDisplayCoordinatesY(positionY),
                (float) radius,
                paint
        );
    }

    public double getRadius()
    {
        return radius;
    }
}