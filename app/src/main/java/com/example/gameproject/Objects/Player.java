package com.example.gameproject.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

import com.example.gameproject.Graphics.Sprite;
import com.example.gameproject.Infrastructure.GameLoop;
import com.example.gameproject.Infrastructure.Joystick;
import com.example.gameproject.Objects.GameObject;
import com.example.gameproject.Objects.HealthBar;
import com.example.gameproject.R;

public class Player extends GameObject
{
    private static final double SPEED_PIXELS_PER_SECOND = 600.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/ GameLoop.MAX_UPS;
    private double r;
    private final HealthBar healthbar;
    private Paint paint;
    private Bitmap bitmap;
    private Sprite sprite;

    public Player(Context context, double x, double y, double r)
    {
        //Set Position of Player
        super(x, y);
        this.r = r;

        //Set Look of Player
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.playerspritesheet);
        sprite = new Sprite(context,
                            bitmap,
                            new Rect(0, 0, 105, 264));

        //Set Health Bar above Player
        this.healthbar = new HealthBar(context, this);
    }

    @Override
    public void draw(Canvas canvas)
    {
        //Draw Player
        //canvas.drawCircle((float) x, (float) y, (float) r, paint);
        sprite.draw(canvas);

        //Draw Health Bar
        healthbar.draw(canvas);
    }

    //Update the Position of Player
    public void update(Joystick joystick)
    {
        //Set the Speed of along X-Axis for Player
        velocityX = joystick.getActuatorX()*MAX_SPEED;

        //Set the Speed of along Y-Axis for Player
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        //Set x
        x += velocityX;

        //Set y
        y += velocityY;

        //
        sprite.update(new Rect((int)x-64, (int)y-30, (int)x+41, (int)y+234));
    }
}