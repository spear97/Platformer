package com.example.gameproject.GameObjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

import com.example.gameproject.Graphics.Tiles.Tile;
import com.example.gameproject.Graphics.Tiles.Tilemap;
import com.example.gameproject.Infrastructure.GameDisplay;
import com.example.gameproject.Infrastructure.GameLoop;
import com.example.gameproject.Graphics.Animator;
import com.example.gameproject.Infrastructure.Joystick;
import com.example.gameproject.R;
import com.example.gameproject.Infrastructure.Utils;

public class Player extends Circle
{
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public static final int MAX_HEALTH_POINTS = 5;
    private Joystick joystick;
    private HealthBar healthBar;
    private int healthPoints = MAX_HEALTH_POINTS;
    private Animator animator;
    private Tilemap world;
    public boolean canMove = true;

    //Player Character Constructor that will setup Animations, User Input, and Position that Player
    //Exists in the world
    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator, Tilemap world)
    {
        //Inherit functionality from the Circle Class
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius, world);

        //Set Up Joystick that will Control Player
        this.joystick = joystick;

        //Set Up the HealthBar that will Control the amount of Health the Player will have
        this.healthBar = new HealthBar(context, this);

        //Set Up the Animator what will handle the Player's Animations
        this.animator = animator;
    }

    //How the Player will update for each frame that is ticked though each frame
    public void update()
    {
        movement();
    }

    private void collision()
    {
        Tile closest = getTileCollision(animator.getSprite(), positionX, positionY);
        Rect closestRect = closest.mapLocationRect, playerRect = animator.getSprite().getRect();
    }

    //Manage Player Movement
    private void movement()
    {
        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        // Update position, if Position is in Bounds
        if(canMove)
        {
            positionX += velocityX;
        }

        //Allows Player to Jump Up
        if(velocityY < 0 && canMove)
        {
            //positionY += velocityY;
        }

        // Update direction
        if (velocityX != 0 || velocityY != 0)
        {
            // Normalize velocity to get direction (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX/distance;
            directionY = velocityY/distance;
        }
    }

    //Draws Animations and HealthBar
    public void draw(Canvas canvas, GameDisplay gameDisplay)
    {
        animator.drawPlayer(canvas, gameDisplay, this);
        healthBar.draw(canvas, gameDisplay);
    }


    //Return the HealthPoints that Player currently has
    public int getHealthPoint()
    {
        return healthPoints;
    }

    //Update the HealthPoint
    public void setHealthPoint(int healthPoints)
    {
        // Only allow positive values
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }

    //Return the Joystick that Controls the Joystick
    public Joystick getJoystick()
    {
        return joystick;
    }

    //Return the Animator that the controls Animations for Player
    public Animator getAnimator() {return animator;}
}