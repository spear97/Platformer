package com.example.gameproject.GameObjects.AI;

import android.content.Context;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.Graphics.Animator;
import com.example.gameproject.Graphics.Tiles.Tilemap;
import com.example.gameproject.Infrastructure.GameLoop;

public class Lvl2AI
{private Context context;
    private Player player;
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    int maxSpeed = (int) (MAX_SPEED*0.75);
    int moveSpeed = (int) (SPEED_PIXELS_PER_SECOND*0.75);
    int fallSpeed = maxSpeed;
    boolean facingRight = false;
    boolean left = true;
    boolean right = false;
    boolean falling = true;
    double positionX;
    double positionY;
    double radius;
    Animator animator;
    Tilemap world;

    public Lvl2AI(Context context, Player player, double positionX, double positionY, double radius)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.context = context;
        this.player = player;
        this.radius = radius;
        this.animator = animator;
        this.world = world;
    }


    private void getNextPosition(){

        //movement of enemy 1
        if(left){
            positionX -= moveSpeed;
            if(positionX < -maxSpeed){
                positionX = -maxSpeed;
            }
        }
        else if(right){
            positionX += moveSpeed;
            if(positionX > maxSpeed){
                positionX = maxSpeed;
            }
        }

        if(falling){
            positionY += fallSpeed;
        }
    }

    public void updateEnemy1(){
        getNextPosition();
        //checkTileMapCollision();
        //setPosition(xtemp,ytemp);

        //switch direction if collision occurs
        if(right && positionX == 0){
            right = false;
            left = true;
            facingRight = false;
        }
        else if(left && positionX == 0){
            right = true;
            left = false;
            facingRight = true;
        }


        /*if (Collision.tileCollisionRight(this.Enemy, this.Enemy.getSpeed(), currentLevel)
            == false && (Math.abs((this.LevelTwo.getX() + this.LevelTwo.getSpeed())
            - this.player.getX()) < Collision.getXDist(this.thisEnemy, this.player)))
    {

        //Should/Can go right
        this.thisEnemy.setX(this.thisEnemy.getX() + this.thisEnemy.getSpeed());
    }
    else if (Collision.tileCollisionLeft(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
            == false && (Math.abs((this.thisEnemy.getX() - this.thisEnemy.getSpeed())
            - this.player.getX())) < Collision.getXDist(this.thisEnemy, this.player))
    {
        //Should/Can go left
        this.thisEnemy.setX(this.thisEnemy.getX() - this.thisEnemy.getSpeed());
    }

    if (Collision.tileCollisionDown(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
            == false && (Math.abs((this.thisEnemy.getY() + this.thisEnemy.getSpeed())
            - this.player.getY()) < Collision.getYDist(this.thisEnemy, this.player)))
    {

        //Should/Can go down
        this.thisEnemy.setY(this.thisEnemy.getY() + this.thisEnemy.getSpeed());
    }
    else if (Collision.tileCollisionUp(this.thisEnemy, this.thisEnemy.getSpeed(), currentLevel)
            == false && (Math.abs((this.thisEnemy.getY() - this.thisEnemy.getSpeed())
            - this.player.getY()) < Collision.getYDist(this.thisEnemy, this.player)))
    {

        //Should/Can go up
        this.thisEnemy.setY(this.thisEnemy.getY() - this.thisEnemy.getSpeed());
    }*/
    }
}
