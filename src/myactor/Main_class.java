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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
        ActorFrame actor_frame = new ActorFrame();
        actor_frame.setActor(actor_canvas);
     
    
      
      //  actor_frame.setSize((int) width / 2, (int) height / 2);
        
       // JPanel panel = new JPanel(new BorderLayout());
    //   panel.add(actor_canvas, BorderLayout.CENTER);
    //    actor_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
//actor_frame.setContentPane(panel);
       // actor_frame.getContentPane().add(actor_canvas);
       
    
    
    
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
        
        
        ActorNameField name_field = new ActorNameField();
        name_field.setActor(actor_canvas);
        name_field.setFrame(actor_frame);
        
        content_pane.add(name_field);
        
        Height_Width_Panel hwp = new Height_Width_Panel();
        hwp.setActorFrame(actor_frame);
        content_pane.add(hwp);
        
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
