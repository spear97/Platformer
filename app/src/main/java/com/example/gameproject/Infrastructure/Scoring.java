package com.example.gameproject.Infrastructure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.R;

//Refactor to make it Scoring Class
public class Scoring
{
    private GameLoop gameLoop;
    private Context context;

    public Scoring(Context context, GameLoop gameLoop)
    {
        this.context = context;
        this.gameLoop = gameLoop;
    }

    //Draw Performance Metrics to the Screen
    public void draw(Canvas canvas)
    {
        drawScore(canvas);
    }

    //Draw UPS(Units Per Second) to the Screen
    public void drawScore(Canvas canvas)
    {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Score: 0  Lives: 3", 100, 100, paint);
    }
}