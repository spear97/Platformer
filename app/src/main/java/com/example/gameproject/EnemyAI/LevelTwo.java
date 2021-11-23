package com.example.gameproject.EnemyAI;

import android.content.Context;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;

public class LevelTwo extends Enemy{
    public LevelTwo(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, player, positionX, positionY, radius);
        MAX_SPEED *= 0.75;
    }
}
