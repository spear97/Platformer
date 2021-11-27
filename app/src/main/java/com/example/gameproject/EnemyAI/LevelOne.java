package com.example.gameproject.EnemyAI;

import android.content.Context;

import com.example.gameproject.GameObjects.Enemy;
import com.example.gameproject.GameObjects.Player;

public class LevelOne extends Enemy{
    public LevelOne(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, player, positionX, positionY, radius);
    }

    int maxSpeed = (int) (MAX_SPEED*0.5);
    int moveSpeed = (int) (SPEED_PIXELS_PER_SECOND*0.5);
    int fallSpeed = maxSpeed;
    boolean facingRight = false;

    private void getNextPosition(){

        //movement of enemy 1
        if(left){
            dx -= moveSpeed;
            if(dx < -maxSpeed){
                dx = -maxSpeed;
            }
        }
        else if(right){
            dx += moveSpeed;
            if(dx > maxSpeed){
                dx = maxSpeed;
            }
        }

        if(falling){
            dy += fallSpeed;
        }
    }

    public void updateEnemy1(){
        getNextPosition();
        checkTileMapCollision();
        setPosition(xtemp,ytemp);

        //switch direction if collision occurs
        if(right && dx == 0){
            right = false;
            left = true;
            facingRight = false;
        }
        else if(left && dx == 0){
            right = true;
            left = false;
            facingRight = true;
        }
    }

    //animation flip
    public void draw(){

        if(notOnScreen()) return;

        setMapPosition();

        if(facingRight){
            g.drawImage(animation.getImage(), (int) (x+xmap-width/2), (int) (y+ymap-height/2),null);
        }
        else{
            g.drawImage(animation.getImage(), (int) (x+xmap-width/2+width), (int) (y+ymap-height/2), -width, height, null);
        }
    }


}
