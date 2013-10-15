/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author richardhart
 */
public class Height_Width_Panel extends JPanel implements ComponentListener, ActionListener {

    JTextField width_field;
    JTextField height_field;
    JLabel height_label;
    JLabel width_label;
    ActorFrame actor_frame;
    int current_width_field;
    int current_height_field;

    Height_Width_Panel() {
        this.setLayout(new FlowLayout());

        actor_frame = new ActorFrame();
        height_label = new JLabel("Height");
        width_label = new JLabel("Width");
        width_field = new JTextField(3);

        height_field = new JTextField(3);

        this.add(width_label);
        this.add(width_field);

        this.add(height_label);
        this.add(height_field);
        current_width_field = ((int) actor_frame.getSize().getWidth());
        width_field.setText("" + current_width_field);
        current_height_field = ((int) actor_frame.getSize().getHeight());
        height_field.setText("" + current_height_field);
        actor_frame.addComponentListener(this);
        width_field.addActionListener(this);
        height_field.addActionListener(this);
       
  

    }
    
    public  void setActorFrame(ActorFrame actor_frame){
         this.actor_frame= actor_frame;
         actor_frame.addComponentListener(this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        //frame.setSize((int) width / 2, (int) height / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Height_Width_Panel());
        frame.pack();
        frame.setVisible(true);
    }

    public void componentResized(ComponentEvent e) {
        width_field.removeActionListener(this);
        height_field.removeActionListener(this);
        System.out.println("componentResized");
        width_field.setText("" + actor_frame.getActorWidthSize());
        height_field.setText("" + actor_frame.getActorHeightSize());
        actor_frame.repaint();
      width_field.addActionListener(this);
        height_field.addActionListener(this);
   
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("componentMoved");
    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println("componentShown");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("componentHidden");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actor_frame.removeComponentListener(this);
        if(e.getSource().equals(width_field)){
        
        String read_width_field = width_field.getText();
        int new_width;
        read_width_field = read_width_field.replaceAll("[\\D]", "");
        
        if (read_width_field.length() > 0) {

            new_width = Integer.parseInt(read_width_field);

            if (0 < new_width && new_width <= 400) {
               
                current_width_field=new_width;
                 
            } 
            
        }
       
        }
        
        if(e.getSource().equals(height_field)){
        String read_height_field = height_field.getText();
        int new_height;
        read_height_field = read_height_field.replaceAll("[\\D]", "");
        
        if (read_height_field.length() > 0) {

            new_height = Integer.parseInt(read_height_field);

            if (0 < new_height && new_height <= 400) {
               
                current_height_field=new_height;
               
            } 
            
        }
         
        }
        

       height_field.setText("" + current_height_field);
       width_field.setText("" + current_width_field);
         actor_frame.setSize(current_width_field, current_height_field);
        actor_frame.addComponentListener(this);
    }
}
