package com.example.gameproject.GameObjects;

import android.content.Context;
import android.graphics.Canvas;

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
    private Tile[] Top, Bottom, Left, Right;

    private enum Direction
    {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    //Player Character Constructor that will setup Animations, User Input, and Position that Player
    //Exists in the world
    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator, Tilemap world)
    {
        //Inherit functionality from the Circle Class
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);

        //Set Up Joystick that will Control Player
        this.joystick = joystick;

        //Set Up the HealthBar that will Control the amount of Health the Player will have
        this.healthBar = new HealthBar(context, this);

        //Set Up the Animator what will handle the Player's Animations
        this.animator = animator;

        this.world = world;

        for(int n = 0; n < 4; n++)
        {
            switch(n)
            {
                case 0: //Top
                    for(int j = 0; j < 150; j++)
                    {
                        Top[j] = world.getTile(0, j);
                    }
                    break;
                case 1: //Bottom
                    for(int j = 0; j < 150; j++)
                    {
                        Bottom[j] = world.getTile(49, j);
                    }
                    break;
                case 2: //Left
                    for(int i = 0; i < 40; i++)
                    {
                        Left[i] = world.getTile(i, 0);
                    }
                    break;
                case 3: //Right
                    for(int i = 0; i < 4; i++)
                    {
                        Right[i] = world.getTile(i, 49);
                    }
                    break;
            }
        }
    }

    //How the Player will update for each frame that is ticked though each frame
    public void update()
    {
        movement();
    }

    private void collision()
    {
        //Determine the Direction that Player is moving

        Direction dir = Direction.RIGHT;

        if(velocityY < 0)
        {
            dir = Direction.UP;
        }
        else if(velocityY > 0)
        {
            dir = Direction.DOWN;
        }
        else if(velocityX < 0)
        {
            dir = Direction.LEFT;
        }
       else
        {
            dir = Direction.RIGHT;
        }

        //Predict which Collision Player will encounter
        switch(dir)
        {
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
        }
    }


    //Manage Player Movement
    private void movement()
    {
        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        // Update position, if Position is in Bounds
        positionX += velocityX;

        //Allows Player to Jump Up
        if(joystick.getActuatorY() < 0)
        {
            positionY += velocityY;
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