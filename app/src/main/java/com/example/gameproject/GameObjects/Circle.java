package com.example.gameproject.GameObjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.gameproject.Graphics.Tiles.Tile;
import com.example.gameproject.Infrastructure.Bounds;
import com.example.gameproject.Infrastructure.Game;
import com.example.gameproject.Infrastructure.GameDisplay;

public abstract class Circle extends GameObject
{
    protected double radius;
    protected Paint paint;
    protected Game game;
    protected Bounds bounds;
    protected Tile tile;

    public Circle(Context context, int color, double positionX, double positionY, double radius)
    {
        super(positionX, positionY);
        this.radius = radius;

        //Get the Bounds of the Level
        bounds = game.getBounds();

        // Set colors of circle
        paint = new Paint();
        paint.setColor(color);
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

}