package com.example.gameproject.GameObjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.gameproject.Graphics.Tiles.Tile;
import com.example.gameproject.Graphics.Tiles.Tilemap;
import com.example.gameproject.Infrastructure.GameDisplay;

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

   public static boolean gravity(Circle obj1, Circle obj2)
   {
       int fall = 128;
        if(isColliding(obj1, obj2) == false)
        {
            double characterYnext = obj1.positionY + fall;          //Get Next Position
            //Basically if next position is too far.
            if(true)
            {
                //This should move the character to the ground state.
                fall = 0; //No longer falling so reset the value.
            }
            else
            {
                obj1.positionY += fall; fall++;     //Otherwise continue falling like normal.
            }
        }

        return true;
    }

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