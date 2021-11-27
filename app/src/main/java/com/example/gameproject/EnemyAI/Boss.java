package com.example.gameproject.EnemyAI;

import android.content.Context;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;

public class Boss extends Enemy{
    public Boss(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, player, positionX, positionY, radius);
    }
}
