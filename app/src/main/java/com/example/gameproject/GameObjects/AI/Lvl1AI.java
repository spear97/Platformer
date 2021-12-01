package com.example.gameproject.GameObjects.AI;

import android.content.Context;
import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.Graphics.Animator;
import com.example.gameproject.Graphics.Tiles.Tilemap;
import com.example.gameproject.Infrastructure.GameLoop;


public class Lvl1AI
{
    private Context context;
    private Player player;
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    int maxSpeed = (int) (MAX_SPEED*0.5);
    int moveSpeed = (int) (SPEED_PIXELS_PER_SECOND*0.5);
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

    public Lvl1AI(Context context, Player player, double positionX, double positionY, double radius, Animator animator, Tilemap world)
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
    }

}
