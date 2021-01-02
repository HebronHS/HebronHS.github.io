import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elevator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elevator extends Platform
{
    final int GROUND_TOP = 338;          // y pixel location of top of ground
    
    // instance variables
    private int dy;                      // vertical velocity
    private int startY;
    private boolean elevatorDown = false;
    private boolean elevatorOn = false;
    private Mario mario;
    
    /**
     * Act - do whatever the Elevator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        willCollideWithGroundTest();
        startLocationTest();
        setLocation(getX(), getY() + dy);
    }    
    
    public void goingDown()
    {
        dy = 1;
        startY = getY();
        elevatorOn = true;
    }
    
    public void willCollideWithGroundTest()
    {
        if(getY() + getImage().getHeight()/2 + dy >= GROUND_TOP)  // is a collision going to occur
        {
            int overflow = getY() + dy - GROUND_TOP;
            dy = dy - overflow - getImage().getHeight()/2;
            setLocation(getX(), getY() + dy);
            dy = -1;
            elevatorDown = true;
            if(isTouching(Mario.class))
            {
                Actor actor = getOneIntersectingObject(Mario.class);
                mario = (Mario)actor;
                mario.setDy(0);
                mario.setLocation(100, GROUND_TOP);
            }
        }
    }
    
    public void startLocationTest()
    {
        if(elevatorDown && getY() <= startY)
        {   
            dy = 0;
            elevatorDown = false;
            elevatorOn = false;
        }
    }
    
    public boolean isElevatorOn()
    {
       return elevatorOn;   
    }
}
