package com.example.gameproject.EnemyAI;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.Infrastructure.GameLoop;

public class LevelTwo extends Enemy{
    public static final double SPEED_PIXELS_PER_SECOND = 300.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public static final int MAX_HEALTH_POINTS = 1;
    public LevelTwo(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, player, positionX, positionY, radius);
    }
}
