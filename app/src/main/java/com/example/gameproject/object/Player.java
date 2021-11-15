package com.example.gameproject.object;
import android.content.Context;
import com.example.gameproject.GameLoop;
import com.example.gameproject.Joystick;


/*
* Player Character of the Game, that will be controlled via the virtual joystick
*/
public class Player extends Circle
{
    private static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/ GameLoop.MAX_UPS;
    private final Joystick joystick;

    public Player(Context context, Joystick joystick, double x, double y, double r)
    {
        super(context, x, y, r);
        this.joystick = joystick;
    }

    public void update()
    {
        //Update Velocity based on actuator of joystick
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        //Update Position
        x += velocityX;
        y += velocityY;
    }
}
