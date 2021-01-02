import greenfoot.*;

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    // constants 
    private final int SPEED = 3;
    
    // variables
    private boolean flipped = false;
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
           moveSnake();
            
           collisionCheck();
           
           //flipImage();
    }    
    
    public void collisionCheck()
    {

        
    }
    
    public void moveSnake()
    {
           if(Greenfoot.isKeyDown("right"))
            {
                setLocation(getX() + SPEED, getY());
                setRotation(0);
            }
            
            if(Greenfoot.isKeyDown("left"))
            {
                setLocation(getX() - SPEED, getY());
                setRotation(180);
            }
            
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY() - SPEED);
            }
            
            if(Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(), getY() + SPEED);
            }
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
