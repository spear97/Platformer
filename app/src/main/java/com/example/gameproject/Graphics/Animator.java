package com.example.gameproject.Graphics;

import android.graphics.Canvas;

import com.example.gameproject.Infrastructure.GameDisplay;
import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.GameObjects.Enemy;

public class Animator
{

    private Sprite[] SpriteArray;
    private int idxMovingFrame = 1, idxIdle=0, IdxJump=3;
    private int updatesBeforeNextMoveFrame;
    private static final int MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME = 3;

    //Sprite Array that the Animator will be using
    public Animator(Sprite[] SpriteArray)
    {
        this.SpriteArray = SpriteArray;
        updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
    }

    //Return first Frame Sprite, will be used for Collision purposes.
    public Sprite getSprite()
    {
        return SpriteArray[0];
    }

    /*****************************Draw Player Animations***********************************************/
    //Draws animations for Player Character
    public void drawPlayer(Canvas canvas, GameDisplay gameDisplay, Player player)
    {
        //Allow for Character to Move
        if((player.getJoystick().getActuatorX() > 0 || player.getJoystick().getActuatorX() < 0) && player.canMove)
        {
            if(player.getJoystick().getActuatorX() < 0)
            {
                idxIdle = 4;
                IdxJump = 7;
            }
            else if(player.getJoystick().getActuatorX() > 0)
            {
                idxIdle = 0;
                IdxJump = 3;
            }

            if(player.getJump())
            {
                drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[IdxJump]);
            }
            if(!player.getJump())
            {
                drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[idxMovingFrame]);
            }
            if(!player.getIsAlive())
            {
                drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[idxIdle]); //Temporary will change
            }

            if(updatesBeforeNextMoveFrame == 0)
            {

                if(player.getJoystick().getActuatorX() > 0)
                {
                    if(idxMovingFrame == 1)
                        idxMovingFrame = 2;
                    else
                        idxMovingFrame = 1;
                }

                else if(player.getJoystick().getActuatorX() < 0)
                {
                    if(idxMovingFrame == 5)
                        idxMovingFrame = 6;
                    else
                        idxMovingFrame = 5;
                }
                updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
            }
            else if(updatesBeforeNextMoveFrame > 0)
            {
                updatesBeforeNextMoveFrame--;
            }
        }
        //Keep Player in an Idle Position
        else if(player.getJoystick().getActuatorX() == 0 && player.canMove)
        {
            if(!player.getIsAlive())
            {
                drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[idxIdle]); //Temporary will change
            }
            if(player.getJump())
            {
                drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[IdxJump]);
            }
            else
            {
                drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[idxIdle]);
            }
        }
        else
        {
            drawPlayerFrame(canvas, gameDisplay, player, SpriteArray[idxIdle]);
        }
    }

    /*************************************Draw Enemy One Animations************************************/
    public void drawEnemyOne(Canvas canvas, GameDisplay gameDisplay, Enemy enemy)
    {
        drawEnemyFrame(canvas, gameDisplay, enemy, SpriteArray[idxMovingFrame]);

        if(idxMovingFrame == 1)
            idxMovingFrame = 2;
        else
            idxMovingFrame = 1;
    }
    /*************************************Draw Enemy Two Animations************************************/
    public void drawEnemyTwo(Canvas canvas, GameDisplay gameDisplay)
    {

    }
    /*************************************Draw Enemy Three Animations**********************************/
    public void drawEnemyThree(Canvas canvas, GameDisplay gameDisplay)
    {

    }
    /*************************************Draw Boss Animations*****************************************/
    public void drawEnemyBoss(Canvas canvas, GameDisplay gameDisplay)
    {

    }
    /*************************************Draw Frame Function******************************************/
    //Draw the Frame that the Animator will be using
    public void drawPlayerFrame(Canvas canvas, GameDisplay gameDisplay, Player player, Sprite sprite)
    {
        sprite.draw(canvas,(int) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX())
                        - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY())
                        - sprite.getHeight()/2);
    }

    public void drawEnemyFrame(Canvas canvas, GameDisplay gameDisplay, Enemy enemy, Sprite sprite)
    {
        sprite.draw(canvas,(int) gameDisplay.gameToDisplayCoordinatesX(enemy.getPositionX())
                        - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(enemy.getPositionY())
                        - sprite.getHeight()/2);
    }
}