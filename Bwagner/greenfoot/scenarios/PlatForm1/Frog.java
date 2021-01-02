import greenfoot.*;

/**
 * Write a description of class Frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frog extends Actor
{
    private double initialVelocity = -9;  // initial velocity, negative moves upward
    private double dy = 0;                // vertical velocity
    private double dx = 0;                // horizontal velocity
    private double gravity = .3;
    private boolean jumping = false;      // true when jumping; false otherwise
    
    private GreenfootImage faceRight1;    // frog right facing image
    private GreenfootImage faceLeft1;     // frog left facing image
    
    /**
     * Constructor
     */
    public Frog()
    {
        faceRight1 = new GreenfootImage("frog1.png");   // east facing frog image
        faceLeft1 = new GreenfootImage("frog1.png");    // west facing frog image
        faceLeft1.mirrorHorizontally();                 // flip image so it faces west

        setImage(faceRight1);
    }
  
    public void act() 
    {      
        platformTest();
                
        movementTest();
        
        jumpTest();
       
        updateLocation();
    }   
    
    /**
     * Tests to see if the frog has collided with a platform.
     * If the frog has landed on a TopPlatform it resets vertical and horizontal velocity to zero
     *    and sets the jumping flag to false.
     * If the frog hits a BottomPlatform it sets the vertical velocity and gravity so the frog
     *    will fall straight down.
     */
    public void platformTest()
    {
        if(isTouching(TopPlatform.class))
        {
            dx = 0;
            dy = 0;
            jumping = false;
        }
        
        else if(isTouching(BottomPlatform.class))
        {
            dx = 0;
            dy = 2;
            gravity = .3; 
        }
    }
    
    /**
     * Tests to see if the left or right arrow keys have been pressed.
     * The jumping flag prevents a frog from changing directions or moving left or right 
     * while it is still in the air from a jump.
     */
    public void movementTest()
    {
        if(Greenfoot.isKeyDown("left")  && jumping == false)   // move frog left
        {
            setImage(faceLeft1);
            dx = -3;
        }
        
        if(Greenfoot.isKeyDown("right")  && jumping == false)   // move frog right 
        {
            setImage(faceRight1);
            dx = 3;
        }
    }
    
     /**
     * Tests to see if the up arrow key has been pressed. If the up key is pressed the frog jumps.
     * The jumping flag prevents the frog from jumping while it is still in the air from the 
     * previous jump It can't jump again until it lands..
     */
    public void jumpTest()
    {
        
        
    }
    
    /**
     * Updates the frogs location according to its current horizontal(dx) and vertical(dy)
     * velocities. It also applies the force of gravity to the vertical velocity(dy).
     */
    public void updateLocation()
    {
        if(getY() + dy >= 380)   // don't let the frog's vertical position fall below 380
        {
             setLocation((int)(getX() + dx), 380);
             jumping = false;
        }
        else
             setLocation((int)(getX() + dx), (int)(getY() + dy));
             
        dy = dy + gravity;   // update frog's vertical velocity by force of gravity
        
        if(jumping == false)  // if frog is not currently jumping reset hoizontal velocity to zero
            dx = 0;
    }
}
