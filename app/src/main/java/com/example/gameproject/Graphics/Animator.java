package com.example.gameproject.Graphics;

import android.graphics.Canvas;

import com.example.gameproject.Infrastructure.GameDisplay;
import com.example.gameproject.GameObjects.Player;

public class Animator
{
    enum Dir
    {
        Right,
        Left
    }

    private Dir dir;
    private Sprite[] SpriteArray;
    private int idxMovingFrame = 1;
    private int updatesBeforeNextMoveFrame;
    private static final int MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME = 3;

    public Animator(Sprite[] SpriteArray)
    {
        this.SpriteArray = SpriteArray;
        updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
        dir = Dir.Right;
    }

    //Draws animations for Player Character
    public void drawPlayer(Canvas canvas, GameDisplay gameDisplay, Player player)
    {
        if((player.getJoystick().getActuatorX() > 0 || player.getJoystick().getActuatorX() < 0) && !player.getJump())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[idxMovingFrame]);
            if(updatesBeforeNextMoveFrame == 0)
            {
                toggleIdxWalkingFrame();
                updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
            }
            else if(updatesBeforeNextMoveFrame > 0)
            {
                updatesBeforeNextMoveFrame--;
            }
        }
        else if(player.getJoystick().getActuatorX() == 0)
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }

        if(player.getJump())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[3]);
        }
        else if(!player.getJump())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }

        if(!player.getIsAlive())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }
        else if(player.getIsAlive())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }
    }

    //Handles Walk Cycle Animations
    private void toggleIdxWalkingFrame()
    {
        if(idxMovingFrame == 1)
            idxMovingFrame = 2;
        else
            idxMovingFrame = 1;
    }

    public void drawFrame(Canvas canvas, GameDisplay gameDisplay, Player player, Sprite sprite)
    {
        sprite.draw(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX()) - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY()) - sprite.getHeight()/2
        );
    }
}