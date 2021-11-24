package com.example.gameproject.EnemyAI;

import android.content.Context;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;

public class LevelTwo extends Enemy{
    public LevelTwo(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, player, positionX, positionY, radius);
        MAX_SPEED *= 0.75;

        if (Collision.tileCollisionRight(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
                == false && (Math.abs((this.thisEnemy.getX() + this.thisEnemy.getSpeed())
                - this.player.getX()) < Collision.getXDist(this.thisEnemy, this.player))) {
            //Should/Can go right
            this.thisEnemy.setX(this.thisEnemy.getX() + this.thisEnemy.getSpeed());
        } else if (Collision.tileCollisionLeft(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
                == false && (Math.abs((this.thisEnemy.getX() - this.thisEnemy.getSpeed())
                - this.player.getX())) < Collision.getXDist(this.thisEnemy, this.player)) {
            //Should/Can go left
            this.thisEnemy.setX(this.thisEnemy.getX() - this.thisEnemy.getSpeed());
        }

        if (Collision.tileCollisionDown(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
                == false && (Math.abs((this.thisEnemy.getY() + this.thisEnemy.getSpeed())
                - this.player.getY()) < Collision.getYDist(this.thisEnemy, this.player))) {
            //Should/Can go down
            this.thisEnemy.setY(this.thisEnemy.getY() + this.thisEnemy.getSpeed());
        } else if (Collision.tileCollisionUp(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
                == false && (Math.abs((this.thisEnemy.getY() - this.thisEnemy.getSpeed())
                - this.player.getY()) < Collision.getYDist(this.thisEnemy, this.player))) {
            //Should/Can go up
            this.thisEnemy.setY(this.thisEnemy.getY() - this.thisEnemy.getSpeed());
        }
    }
}
