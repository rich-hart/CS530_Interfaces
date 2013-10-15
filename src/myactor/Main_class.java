/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author richardhart
 */
public class Main_class {
      private static void createAndShowGUI() {
     
        
        
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        MyActor actor_canvas = new MyActor(Expression.HAPPY,Color.BLACK,Color.BLUE);
        JFrame actor_frame = new JFrame(actor_canvas.getActorName());
        actor_frame.setLayout(new BorderLayout());
       actor_canvas.setScale(.2, .4);
    
       actor_frame.add(actor_canvas,BorderLayout.CENTER);
      //  actor_frame.setSize((int) width / 2, (int) height / 2);
        
       // JPanel panel = new JPanel(new BorderLayout());
    //   panel.add(actor_canvas, BorderLayout.CENTER);
    //    actor_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
//actor_frame.setContentPane(panel);
       // actor_frame.getContentPane().add(actor_canvas);
        actor_frame.setVisible(true);
        actor_frame.pack();
  
    
    
    
       //Create and set up the window.
        JFrame frame = new JFrame("ColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel content_pane = new JPanel();
        
        content_pane.setLayout(new BoxLayout(content_pane, BoxLayout.Y_AXIS));
        content_pane.setOpaque(true);
        //Create and set up the content pane.
        
        
        ColorChooserDemo ColorPanel = new ColorChooserDemo();
   ColorPanel.setActor(actor_canvas);
        content_pane.add(ColorPanel);
        

        //Display the window.
        FaceButtons buttons = new FaceButtons();
        buttons.setActor(actor_canvas);
        content_pane.add(buttons);
        
        
        frame.setContentPane(content_pane);
        frame.pack();
        frame.setVisible(true);
        
        
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
