/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author richardhart
 */
public class All_Actors extends JFrame {
    public JPanel panel;
    public MyActor canvas;
    
    public All_Actors(){
    
      panel = new JPanel();
      canvas = new MyActor();
      
        
    }
    
    public void paint(Graphics graphics) {
        /* We would be using this method only for the sake
         * of brevity throughout the current section. Note
         * that the Graphics class has been acquired along
         * with the method that we overrode. */
    }
    
}
