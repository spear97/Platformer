package com.example.gameproject.Infrastructure;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.gameproject.GameObjects.Player;
import com.example.gameproject.Graphics.Animator;
import com.example.gameproject.Graphics.SpriteSheet;
import com.example.gameproject.Graphics.Tiles.Tile;
import com.example.gameproject.Graphics.Tiles.Tilemap;
import com.example.gameproject.R;

import java.util.logging.Level;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
    private final Tilemap tilemap;
    private final GameOver gameOver;
    private final Performance performance;
    private final Player player;
    private final GameDisplay gameDisplay;
    private GameLoop gameLoop;
    private Joystick joystick;
    private int height, width, spawnX, spawnY;
    private Tile playerSpawnPoint;
    private Bounds bounds;

    //Constructor
    public Game(Context context)
    {
        super(context);

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        // Get the height and width of the Device Game is Launched on
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels - 200;
        width = 250;

        // Set gameLoop to be able to handle Execution of Game Functionality
        gameLoop = new GameLoop(surfaceHolder, this);

        // Initialize UI
        performance = new Performance(context, gameLoop);
        gameOver = new GameOver(context);
        joystick = new Joystick(width, height, 150, 75);

        // Initialize Bitmap Options
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;

        //Create PlayerSpriteSheet
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.playerspritesheet, bitmapOptions);
        SpriteSheet spriteSheet = new SpriteSheet(context, bitmap, 128, 128);

        //Initialize TileMapSheet
        Bitmap TileMapBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tilesheet, bitmapOptions);
        SpriteSheet TileMapSheet = new SpriteSheet(context, TileMapBitmap, 64, 64);

        // Initialize Tilemap
        tilemap = new Tilemap(TileMapSheet);

        //Initialize Bounds for Level
        Tile Left = tilemap.getTile(19,0), Right = tilemap.getTile(19,149), Top = tilemap.getTile(0,74), Bottom = tilemap.getTile(39,74);
        bounds = new Bounds(new Rect(Left.getRect().left, Top.getRect().top, Right.getRect().right, Bottom.getRect().bottom));

        // Initialize and Set Spawn Location for Player Character
        playerSpawnPoint = tilemap.getTile(18, 10);
        spawnX = playerSpawnPoint.getRect().left;
        spawnY = playerSpawnPoint.getRect().top;

        //Initialize Player
        Animator playerAnimator = new Animator(spriteSheet.getPlayerSpriteArray());
        player = new Player(context, joystick, spawnX, spawnY, 64, playerAnimator);

        // Initialize display and center it around the player
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels, player);

        // Enable view's focus event for touch mode
        setFocusable(true);
    }

    //get Instance of Bounds
    public Bounds getBounds()
    {
        return bounds;
    }

    //get Instance of Player Character
    public Player getPlayer()
    {
        return player;
    }

    //When the Context is Created
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder)
    {
        gameLoop.startLoop();
    }

    //When the Context is Changed
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2)
    {
        Log.d("Game.java", "surfaceChanged()");
    }

    //When Game is Destroyed
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder)
    {
        Log.d("Game.java", "surfaceDestroyed()");
    }

    //Allow for Input for the Screen
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // Handle user input touch event actions
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(joystick.isPressed((double)event.getX(), (double)event.getY()))
                {
                    joystick.setIsPressed(true);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed())
                {
                    joystick.setActuator((double)event.getX(), (double)event.getY());
                }
                return true;
            case MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
                return true;
        }
        return super.onTouchEvent(event);
    }

    //Displays Content onto the Screen
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        // Draw Tilemap
        tilemap.draw(canvas, gameDisplay);

        joystick.draw(canvas);
        player.draw(canvas, gameDisplay);

        performance.drawFPS(canvas);
        performance.drawUPS(canvas);
    }

    //Update Joystick, Player, and GameDisplay as Game Proceeds to run
    public void update()
    {
        joystick.update();
        player.update();
        gameDisplay.update();
    }
}