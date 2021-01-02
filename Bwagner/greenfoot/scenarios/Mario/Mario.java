import greenfoot.*;

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends AnimatedActor
{
    int dx = 0;                          // horizontal velocity
    int dy = 0;                          // vertical velocity
    int gravity = 0;                     // force of gravity
    final int INITIAL_VELOCITY = -15;    // initial vertical velocity
    String direction = "right";          // current direction
    boolean jumping = false;             // currently jumping?
    
    // constructor
    public Mario(String filename, int numFrames, int frameWidth, int frameHeight)
    {
        super(filename, numFrames, frameWidth, frameHeight);
    }
    
    public void act() 
    {
        super.act();
        
        movementTest();
        
        updateLocation();
        
        jumpTest();
    }
    
    public void movementTest()
    {
        if(Greenfoot.isKeyDown("right"))      // right arrow pressed
        {
            dx = 2;                           // set horizontal velocity to 2
            if(direction.equals("left"))      // if current direction is left then flip direction
            {
                setAutoAdvanceRange(0,9);     // only use right facing frames
                setFrame(0);                  // start at first right facing frame
                direction = "right";          // direction is now right
            }
        }
        else if(Greenfoot.isKeyDown("left"))   // left arrow pressed
        {
            dx = -2;                           // set horizontal velocity to -2 
            if(direction.equals("right"))      // if current direction is right then flip direction
            {
                setAutoAdvanceRange(10,19);    // only use left facing frames
                setFrame(10);                  // start at first left facing frame
                direction = "left";            // direction is now left
            }
        }
        else                                  // no key pressed
        {
            dx = 0;                           // set horizontal velocity to 0
            if(direction.equals("right"))     
            {
                setFrame(0);                  // face right
            }
            else  // left
            {
                setFrame(10);                 // face left
            }
        }  
    }
   
    public void updateLocation()
    {
        setLocation(getX() + dx, getY() + dy);
        dy = dy + gravity;
    }
    
    public void jumpTest()
    {
        
    }
}
