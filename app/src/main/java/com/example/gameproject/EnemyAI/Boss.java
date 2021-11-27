package com.example.gameproject.EnemyAI;

import android.content.Context;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;

public class Boss extends Enemy{
    public Boss(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, player, positionX, positionY, radius);
    }

    int maxSpeed = (int) MAX_SPEED;
    int moveSpeed = (int) SPEED_PIXELS_PER_SECOND;
    int fallSpeed = maxSpeed;
    int healthTotal = (int) (MAX_HEALTH_POINTS*2);
    boolean facingRight = false;

    // level 3 AI (call on AI 3)
    // Once bosses health is below half, the boss will switch to phase 2
    // Level 2 AI shooting plus level 3 AI (Once AI 2 and 3 are done, they will be called upon)
}
