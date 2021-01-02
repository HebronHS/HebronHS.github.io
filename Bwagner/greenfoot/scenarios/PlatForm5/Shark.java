import greenfoot.*;

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Actor
{
    /**
     * Act - do whatever the Shark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(-6);
       
       if(getX() < -1 * getImage().getWidth() / 2)
       {
           Greenfoot.stop();
       }
    }    
}
