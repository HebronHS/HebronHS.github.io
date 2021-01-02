import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Mario mario = new Mario("mario.gif", 20, 32, 48);
        addObject(mario, 140, 325);
        mario.setAutoAdvance(true);
        mario.setAdvanceSpeed(2);
        mario.setLooping(true);
        mario.setAutoAdvanceRange(0, 9);
        mario.show();
    }
}
