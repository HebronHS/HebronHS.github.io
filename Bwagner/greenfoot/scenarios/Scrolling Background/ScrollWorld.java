import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollWorld extends World
{
    private int SCROLL_SPEED = -3;  // background moves from right to left
    
    /**
     * Constructor for objects of class ScrollWorld.
     * 
     */
    public ScrollWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        Car car = new Car();
        addObject(car, 302, 235);    // add car
        
    }
    
    public void act()
    {
        scrollBackground();
        
        String key = Greenfoot.getKey();
        if("right".equals(key))
        {
            if(SCROLL_SPEED > -20)    // -20 is maximum speed
               SCROLL_SPEED--;        // increase speed
        }
        if("left".equals(key))
        {
            if(SCROLL_SPEED < 0)     // 0 is minimum speed
               SCROLL_SPEED++;       // decrease speed
        }
    }
    
    public void scrollBackground()
    {

        
    }
}
