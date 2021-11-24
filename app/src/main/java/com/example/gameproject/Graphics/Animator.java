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

    //Sprite Array that the Animator will be using
    public Animator(Sprite[] SpriteArray)
    {
        this.SpriteArray = SpriteArray;
        updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
        dir = Dir.Right;
    }

/*****************************Draw Player Animations***********************************************/
    //Draws animations for Player Character
    public void drawPlayer(Canvas canvas, GameDisplay gameDisplay, Player player)
    {
        //Allow for Character to Move
        //TODO: Need to Make it Swap Left and Right
        if((player.getJoystick().getActuatorX() > 0 || player.getJoystick().getActuatorX() < 0)
                && !player.getJump())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[idxMovingFrame]);
            if(updatesBeforeNextMoveFrame == 0)
            {
                toggleIdxPlayerWalkingFrame();
                updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
            }
            else if(updatesBeforeNextMoveFrame > 0)
            {
                updatesBeforeNextMoveFrame--;
            }
        }
        //Keep Player in an Idle Position
        else if(player.getJoystick().getActuatorX() == 0)
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }

        //have Player Jump
        if(player.getJump())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[3]);
        }
        //Keep Player in an Idle Position
        else if(!player.getJump())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }

        //Player in Death Frame <-- Currently in Idle Position
        //Will be replaced later once a solution can be found
        if(!player.getIsAlive())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }
        //Keep Player in an Idle Position
        else if(player.getIsAlive())
        {
            drawFrame(canvas, gameDisplay, player, SpriteArray[0]);
        }
    }

    //Handles Walk Cycle Animations
    //TODO: Need to Make it Swap Left and Right
    private void toggleIdxPlayerWalkingFrame()
    {
        if(idxMovingFrame == 1)
            idxMovingFrame = 2;
        else
            idxMovingFrame = 1;
    }

/*************************************Draw Enemy One Animations************************************/
public void drawEnemyOne(Canvas canvas, GameDisplay gameDisplay)
{

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
    public void drawFrame(Canvas canvas, GameDisplay gameDisplay, Player player, Sprite sprite)
    {
        sprite.draw(canvas,(int) gameDisplay.gameToDisplayCoordinatesX(player.getPositionX())
                        - sprite.getWidth()/2,
                            (int) gameDisplay.gameToDisplayCoordinatesY(player.getPositionY())
                        - sprite.getHeight()/2);
    }
}