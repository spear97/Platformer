package com.example.gameproject.Infrastructure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.R;

public class Performance
{
    private GameLoop gameLoop;
    private Context context;

    public Performance(Context context, GameLoop gameLoop)
    {
        this.context = context;
        this.gameLoop = gameLoop;
    }

    //Draw Performance Metrics to the Screen
    public void draw(Canvas canvas)
    {

    }

    //Draw UPS(Units Per Second) to the Screen
    public void drawUPS(Canvas canvas, Player player)
    {
        String averageUPS = Double.toString(player.getPositionX());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("X: " + averageUPS, 100, 100, paint);
    }

    //Draw FPS(Frames Per Second) to the Screen
    public void drawFPS(Canvas canvas, Player player)
    {
        String averageFPS = Double.toString(player.getPositionY());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Y: " + averageFPS, 100, 200, paint);
    }
}