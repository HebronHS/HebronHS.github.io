import greenfoot.*;      // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;   // Color

/**
 * Write a description of class BoxBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBug extends Tracker
{  
    public void act() 
    {
        startTrack();      // start making tracks
        move(200);         // move forward 200 units in current direction
        turn(90);          // turn 90 degrees clock-wise
        endTrack();        // stop making tracks
    }  
}
