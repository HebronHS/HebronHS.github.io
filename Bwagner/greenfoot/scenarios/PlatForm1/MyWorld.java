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
        super(600, 400, 1, false); 
        
        TopPlatform topPlatform1 = new TopPlatform();
        addObject(topPlatform1, 300, 300);
        BottomPlatform bottomPlatform1 = new BottomPlatform();
        addObject(bottomPlatform1, 300, 308);
        
        TopPlatform topPlatform2 = new TopPlatform();
        addObject(topPlatform2, 100, 180);
        BottomPlatform bottomPlatform2 = new BottomPlatform();
        addObject(bottomPlatform2, 100, 188);
        
        TopPlatform topPlatform3 = new TopPlatform();
        addObject(topPlatform3, 500, 180);
        BottomPlatform bottomPlatform3 = new BottomPlatform();
        addObject(bottomPlatform3, 500, 188);
        
        Ground ground = new Ground();
        addObject(ground, 300, 400);
        
        Frog frog = new Frog();
        addObject(frog, 130, 380);
    }


}
