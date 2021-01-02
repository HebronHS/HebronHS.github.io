import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Write a description of class BoxBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tracker extends Actor
{
    private GreenfootImage background;
    private int prevX = -1;
    private int prevY = -1;
    private Graphics2D g2 = null;
    
    public void startTrack()
    {
        background = getWorld().getBackground();
        BufferedImage img = background.getAwtImage();
        g2 = (Graphics2D)img.getGraphics();
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(1));
        prevX = getX();
        prevY = getY();
    }
    
    public void startTrack(Color color, int thickness)
    {
        background = getWorld().getBackground();
        BufferedImage img = background.getAwtImage();
        g2 = (Graphics2D)img.getGraphics();
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        prevX = getX();
        prevY = getY();
    }
     
    public void endTrack()
    {
        g2.drawLine(prevX, prevY, getX(), getY());
        prevX = getX();
        prevY = getY();
    }

}
