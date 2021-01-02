import greenfoot.*;

public class Mario extends AnimatedActor
{
    // constants
    final int INITIAL_VELOCITY = -18;    // initial vertical velocity
    final int GROUND_TOP = 338;          // y pixel location of top of ground
    
    // instance variables
    private int dx;                          // horizontal velocity
    private int dy;                          // vertical velocity
    private int gravity;                     // force of gravity
    private String direction = "right";      // current direction
    private boolean jumping = false;         // currently jumping?
    private boolean onPlatform = false;      // currently on platform?
    
    private String key;
    
    // constructor
    public Mario(String filename, int numFrames, int frameWidth, int frameHeight)
    {
        super(filename, numFrames, frameWidth, frameHeight);
    }
    
    public void act() 
    {
        super.act();
        
        movementTest();
        
        wrapAroundTest();
        
        jumpTest();
        
        //collideWithGroundTest();
        
        willCollideWithGroundTest();
        
        platformTest();
        
        elevatorTest();
        
        updateLocation();
    }
    
    public void movementTest()
    {
        boolean keypressed = false;
        if(Greenfoot.isKeyDown("right"))
        {
            dx = 2;
            keypressed = true;
            if(direction.equals("left"))
            {
                setAutoAdvanceRange(0,8);
                setFrame(0);
                direction = "right";
            }    
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            dx = -2;
            keypressed = true;
            if(direction.equals("right"))
            {
                setAutoAdvanceRange(0,8);
                setFrame(0);
                direction = "left";
            }  
            else
              getImage().mirrorHorizontally();
        }
        
        if(!keypressed || Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right"))   // no key pressed
        {
            dx = 0;
            setFrame(0);
            if(direction.equals("left"))
            getImage().mirrorHorizontally();         
        } 
    }
   
    public void wrapAroundTest()
    {
       int w = this.getImage().getWidth();
       
       if(getX() < -w) 
           setLocation(getWorld().getWidth() + getImage().getWidth(), getY());
       if(getX() > getWorld().getWidth() + w)
           setLocation(-w, getY());
    }
    
    public void jumpTest()
    {
        key = Greenfoot.getKey();
        if("up".equals(key) && jumping == false)   // starting jump
        {
            gravity = 1;
            dy = INITIAL_VELOCITY;
            jumping = true;
        }
    }
    
    public void updateLocation()
    {
        setLocation(getX() + dx, getY() + dy);
        dy = dy + gravity;
    }
    
    
    public void collideWithGroundTest()
    {
        if(getY() >= GROUND_TOP)      // landed on the ground
        {
            setLocation(getX(), GROUND_TOP - getHeight()/2);
            gravity = 0;
            dy = 0;
            jumping = false;
        }
    }
    
    public void willCollideWithGroundTest()
    {
        if(getY() + getImage().getHeight()/2 + dy >= GROUND_TOP)  // is a collision going to occur
        {
            int overflow = getY() + dy - GROUND_TOP;
            dy = dy - overflow - getImage().getHeight()/2;
            setLocation(getX(), getY() + dy);
            gravity = 0;
            dy = 0;
            jumping = false;
        }
    }
    
    public void platformTest()
    {
        Actor platform = getOneIntersectingObject(Platform.class);   // get reference of a platform that has collided with Mario
        if(platform != null)   // yes we got one
        {
            if(jumping && dy >= 0)
            {
                if(dy >= 0)    // collides with platform on the way down (platform top)
                {
                    dy = 0;
                    gravity = 0;
                    jumping = false;
                    // position Mario's feet on top of platform
                    setLocation(getX(), platform.getY() - (platform.getImage().getHeight()/2 + getHeight()/2));
                    onPlatform = true;
                }
            }
            else if(jumping && dy < 0)  // collides with platform on the way up (platform bottom)
            {
                dy = 0;
                gravity = 1;
                jumping = false;
                // position Mario's head on bottom of platform
                setLocation(getX(), platform.getY() + platform.getImage().getHeight()/2 + getHeight()/2);
            }
        }
        // check to see if Mario has walked off the edge of the platform
        else if(!jumping && onPlatform && getOneObjectAtOffset(0, getHeight()/2, Platform.class) == null)
        {
            dx = 0; 
            dy = 2;
            gravity = 1;
            onPlatform = false;
        }
    }
    
    public void elevatorTest()
    {
       if("down".equals(key))
       {
            Actor actor = this.getOneObjectAtOffset(0, getHeight()/2 + 5, Elevator.class);
            Elevator elevator = (Elevator)actor;
            if(elevator != null && !elevator.isElevatorOn())
            {
                {
                   elevator.goingDown();
                   dy = 1;
                }
            }
       }
    }
    
    public void setDy(int dy)
    {
        this.dy = dy;
    }

}
