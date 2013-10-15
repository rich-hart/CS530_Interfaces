/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author richardhart
 */
public class ActorNameField extends JTextField implements DocumentListener{
    protected ActorFrame current_actor_frame;
    protected MyActor current_actor;
    ActorNameField(){
        setPreferredSize(new Dimension(100,30));
        current_actor_frame = new ActorFrame();
    this.getDocument().addDocumentListener(this);
    }
    
    public void setFrame(ActorFrame new_actor_frame){
    current_actor_frame=new_actor_frame;
    }
    
    
    public void setActor(MyActor new_actor){
    current_actor=new_actor;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        current_actor_frame.UpdateFrameLable(this.getText());
       current_actor.setActorName(this.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        current_actor_frame.UpdateFrameLable(this.getText());
        current_actor.setActorName(this.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        current_actor_frame.UpdateFrameLable(this.getText());
       current_actor.setActorName(this.getText());
    }
}
