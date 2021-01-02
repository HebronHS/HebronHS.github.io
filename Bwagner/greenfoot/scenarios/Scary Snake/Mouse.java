import greenfoot.*;

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    // variables
    private boolean danger = false;
    private int runAwayDirection = 0;
    private boolean flipped = false;
   
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(danger == true)
        {
            setRotation(runAwayDirection);
            move(2);
            flipImage();
        }
    } 
    
    public void runAway(int direction)
    {
        danger = true;
        runAwayDirection = direction;
    }
    
    public void flipImage()
    {
        if(getRotation() == 0 && flipped == true)
        {
            getImage().mirrorVertically();
            flipped = false;
        }
        else if(getRotation() == 180 && flipped == false)
        {
            getImage().mirrorVertically();
            flipped = true;
        }
    }
}
