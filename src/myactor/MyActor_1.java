/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author richardhart
 */
   

public class MyActor_1 {
    
    
    MyActor_1(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        MyActor canvas = new MyActor();
        JFrame frame = new JFrame();
        frame.setSize((int) width / 2, (int) height / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MyActor_1();
    }
}
