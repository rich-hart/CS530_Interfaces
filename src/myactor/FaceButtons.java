/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author richardhart
 */
public class FaceButtons extends JPanel implements ActionListener {
    protected MyActor current_actor;
    protected JButton happy, neutral, sad;
    
    FaceButtons(){
     happy = new JButton("Happy");
        happy.addActionListener(this);
        happy.setPreferredSize(new Dimension(100,100));
        neutral = new JButton("Neutral");
        neutral.addActionListener(this);
        neutral.setPreferredSize(new Dimension(100,100));
        sad = new JButton("Sad");
        sad.addActionListener(this);
        sad.setPreferredSize(new Dimension(100,100));
        add(happy);
        add(neutral);
        add(sad);
    
    }
    
    FaceButtons(MyActor new_actor){
        super();
        setActor(new_actor);
        //add(happy);
        //add(neutral);
        //add(sad);
    
    }

    public MyActor getActor(){
    return current_actor;
    }
    
    public void setActor(MyActor new_actor){
    this.current_actor=new_actor;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource().equals(happy)){
        current_actor.setEmotion(Expression.HAPPY);
        }
        
         if(e.getSource().equals(neutral)){
        current_actor.setEmotion(Expression.NEUTRAL);
        }
         
          if(e.getSource().equals(sad)){
          current_actor.setEmotion(Expression.SAD);
        }
          
         
    }
    
}
