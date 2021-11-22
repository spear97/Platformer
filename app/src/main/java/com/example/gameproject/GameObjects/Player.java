package com.example.gameproject.GameObjects;

import android.content.Context;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

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
    private PlayerState playerState;

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator)
    {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.animator = animator;
        this.playerState = new PlayerState(this);
    }

    public void update()
    {

        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        // Update position, if Position is in Bounds
        if(getPositionX() > 1200 && getPositionX() < 8330)
        {
            positionX += velocityX;
        }
        else if(getPositionX() <= 1200 && joystick.getActuatorX() > 0 || getPositionX() >= 8330 && joystick.getActuatorX() < 0)
        {
            positionX += velocityX;
        }

        positionY += velocityY;

        // Update direction
        if (velocityX != 0 || velocityY != 0)
        {
            // Normalize velocity to get direction (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX/distance;
            directionY = velocityY/distance;
        }

        playerState.update();
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay)
    {
        animator.draw(canvas, gameDisplay, this);

        healthBar.draw(canvas, gameDisplay);
    }

    public int getHealthPoint()
    {
        return healthPoints;
    }

    public void setHealthPoint(int healthPoints)
    {
        // Only allow positive values
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }

    public PlayerState getPlayerState()
    {
        return playerState;
    }
}