package com.example.gameproject.Graphics;

import android.graphics.Canvas;

import com.example.gameproject.Infrastructure.GameDisplay;
import com.example.gameproject.GameObjects.Player;

public class Animator
{
    private Sprite[] SpriteArray;
    private int idxNotMovingFrame = 0;
    private int idxMovingFrame = 1;
    private int updatesBeforeNextMoveFrame;
    private static final int MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME = 5;

    public Animator(Sprite[] SpriteArray)
    {
        this.SpriteArray = SpriteArray;
    }

    //Draws animations for Player Character
    public void drawPlayer(Canvas canvas, GameDisplay gameDisplay, Player player)
    {
        switch (player.getPlayerState().getState())
        {
            //Idle Animation
            case NOT_MOVING:
                drawFrame(canvas, gameDisplay, player, SpriteArray[idxNotMovingFrame]);
                break;
            //Walking Animation
            case STARTED_MOVING:
                updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
                drawFrame(canvas, gameDisplay, player, SpriteArray[idxMovingFrame]);
                break;
            //Walking Animation
            case IS_MOVING:
                updatesBeforeNextMoveFrame--;
                if(updatesBeforeNextMoveFrame == 0) {
                    updatesBeforeNextMoveFrame = MAX_UPDATES_BEFORE_NEXT_MOVE_FRAME;
                    toggleIdxWalkingFrame();
                }
                drawFrame(canvas, gameDisplay, player, SpriteArray[idxMovingFrame]);
                break;
            default:
                break;
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