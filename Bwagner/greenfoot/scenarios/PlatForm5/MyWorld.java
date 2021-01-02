import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int counter = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        addPlatforms();
        
        Ground ground = new Ground();
        addObject(ground, 300, 400);
        
        Frog frog = new Frog();
        addObject(frog, 300, 290);
    }
    
    public void act()
    {
        //create random fish
        int random = Greenfoot.getRandomNumber(300) + 1;
        if(random == 1)
        {
            addFish();
        }
    }
    
    public void addPlatforms()
    {
        TopPlatform topPlatform1 = new TopPlatform();
        addObject(topPlatform1, 300, 300);
        BottomPlatform bottomPlatform1 = new BottomPlatform();
        addObject(bottomPlatform1, 300, 308);
        
        TopPlatform topPlatform2 = new TopPlatform();
        addObject(topPlatform2, 100, 200);
        BottomPlatform bottomPlatform2 = new BottomPlatform();
        addObject(bottomPlatform2, 100, 208);
        
        TopPlatform topPlatform3 = new TopPlatform();
        addObject(topPlatform3, 500, 200);
        BottomPlatform bottomPlatform3 = new BottomPlatform();
        addObject(bottomPlatform3, 500, 208);
        
        TopPlatform topPlatform4 = new TopPlatform();
        addObject(topPlatform4, 300, 100);
        BottomPlatform bottomPlatform4 = new BottomPlatform();
        addObject(bottomPlatform4, 300, 108);
        
        TopPlatform topPlatform5 = new TopPlatform();
        addObject(topPlatform5, 100, 0);
        BottomPlatform bottomPlatform5 = new BottomPlatform();
        addObject(bottomPlatform5, 100, 8);
        
        TopPlatform topPlatform6 = new TopPlatform();
        addObject(topPlatform6, 500, 0);
        BottomPlatform bottomPlatform6 = new BottomPlatform();
        addObject(bottomPlatform6, 500, 8);
    }

    public void addFish()
    {
        int direction = Greenfoot.getRandomNumber(2);
        
        if(direction == 0)  // fish swims from west to east
        {
            int speed = Greenfoot.getRandomNumber(3) + 1;
            int y = Greenfoot.getRandomNumber(getHeight() - 50) + 25 ;
            Fish fish = new Fish(speed);
            addObject(fish, 0, y);
        }
        else  // fish swims from east to west
        {
            
            int speed = Greenfoot.getRandomNumber(3) + 1;
            int y = Greenfoot.getRandomNumber(getHeight() - 50) + 25 ;
            Fish fish = new Fish(-speed);
            fish.getImage().mirrorHorizontally();
            addObject(fish, getWidth(), y);
        }
    }
}
