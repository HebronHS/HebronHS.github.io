import greenfoot.*;

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    private int speed = 0;
    
    public Fish(int s)
    {
        speed = s;
        
        // make fish a little smaller
        getImage().scale(65, 45);   // original size 75 x 55
    }
    
    public void act() 
    {
        setLocation(getX() + speed, getY());
        
        
        // remove fish after it swims across screen 
        if(speed < 0 && getX() + getImage().getWidth()/2 < 0)  // left moving fish
        {
            getWorld().removeObject(this);   // remove this fish from world
        }
        
        if(speed > 0 && getX() - getImage().getWidth()/2 > getWorld().getWidth())  // right moving
        {
            getWorld().removeObject(this);   // remove this fish from world
        }
        
    }    
}
