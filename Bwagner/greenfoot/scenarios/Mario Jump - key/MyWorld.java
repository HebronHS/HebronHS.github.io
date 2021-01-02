import greenfoot.*;

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Mario mario = new Mario("marioSheet1.png", 9, 40, 48);
        addObject(mario, 40, 314);
        
        // set Animated Actor Attributes
        mario.setAutoAdvance(true);
        mario.setAdvanceSpeed(2);
        mario.setLooping(true);
        mario.setAutoAdvanceRange(0, 8);
        mario.show();
        
        Platform platform = new Platform();
        addObject(platform, getWidth()/2, 260);
        
        Elevator elevator = new Elevator();
        addObject(elevator, 216,260);
    }
}
