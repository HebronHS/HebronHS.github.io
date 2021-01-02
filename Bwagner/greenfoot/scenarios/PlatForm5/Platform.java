import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    private int counter = 0;
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(counter % 5 == 0)
              setLocation(getX(), (int)(getY() + 1));
              
        counter++;
        
        if(getY() > getWorld().getHeight())
        {
            setLocation(getX(), 0);
        }
    }   
}
