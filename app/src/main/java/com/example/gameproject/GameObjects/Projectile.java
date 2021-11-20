package com.example.gameproject.GameObjects;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.gameproject.Infrastructure.GameLoop;
import com.example.gameproject.R;

public class Projectile extends Circle
{
    public static final double SPEED_PIXELS_PER_SECOND = 800.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Projectile(Context context, Player spellcaster)
    {
        super(
                context,
                ContextCompat.getColor(context, R.color.spell),
                spellcaster.getPositionX(),
                spellcaster.getPositionY(),
                25
        );
        velocityX = spellcaster.getDirectionX()*MAX_SPEED;
        velocityY = spellcaster.getDirectionY()*MAX_SPEED;
    }

    @Override
    public void update()
    {
        positionX = positionX + velocityX;
        positionY = positionY + velocityY;
    }
}