import greenfoot.*;

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{ 
    public Ground()
    {
        GreenfootImage img = new GreenfootImage("platform.png");
        GreenfootImage image = new GreenfootImage(img.getWidth()*6, img.getHeight());
        for(int i = 0; i < 6; i++)
        {
            image.drawImage(img, img.getWidth() * i, 0);
        }
        setImage(image);
    }

}