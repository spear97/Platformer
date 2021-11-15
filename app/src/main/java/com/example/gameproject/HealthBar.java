package com.example.gameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class HealthBar
{
    private Player player;
    private int width, height, margin;
    private Paint healthPaint;

    public HealthBar(Context context, Player player)
    {
        //
        this.player = player;
        this.width = 100;
        this.height = 20;
        this.margin = 2;

        //Initialize healthPaint
        this.healthPaint = new Paint();
        int healthColor = ContextCompat.getColor(context, R.color.healthBar);
        healthPaint.setColor(healthColor);
    }

    public void draw(Canvas canvas)
    {
        //Calculate the percentage of the HealthBar
        float x = (float) player.getX();
        float y = (float) player.getY();
        float dist = 45;
        float percentage = (float) player.getCurrHealth() / player.getMaxHealth();

        //Draw HealthBar
        float Left = x - width/2,
        Bottom = y - dist;
        float healthWidth = width - 2*margin,
        healthHeight = height - 2*margin,
        healthLeft = Left + margin,
        healthTop = Bottom - healthHeight,
        healthRight = healthLeft + healthWidth*percentage,
        healthBottom = Bottom - margin;
        canvas.drawRect(healthLeft, healthTop, healthRight, healthBottom, healthPaint);
    }
}
