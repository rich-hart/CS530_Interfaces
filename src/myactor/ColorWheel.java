/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import com.bric.swing.ColorPicker;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author richardhart
 */
public class ColorWheel extends JFrame {
    
    
    
    
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        ColorWheel c = new ColorWheel();
      
       Color newColor = ColorPicker.showDialog(c, Color.BLACK);
       
       
    }
}
