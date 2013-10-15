/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

/**
 *
 * @author richardhart
 */
public class ActorFrame extends JFrame implements ComponentListener{
    protected MyActor current_actor;
    double screen_width;
    double screen_height;
    double default_width;
    double default_height;
    double current_width;
    double current_height;
    ActorFrame(){
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen_width = screenSize.getWidth();
        screen_height = screenSize.getHeight();
        default_width =(int)screen_width/4;
        default_height=(int)screen_height/2;
        current_width=default_width;
        current_height=default_height;
        this.setSize((int)default_width, (int)default_height);
        current_actor= new MyActor();
        this.setTitle(current_actor.getActorName());
        this.addComponentListener(this);
        this.add(current_actor);
        this.setVisible(true);
        
    }
    
      public static void main(String[] args) {
      new ActorFrame();
      }
      
      public void setActor(MyActor new_actor){
          this.remove(current_actor);
          this.add(new_actor);
      current_actor=new_actor;
      
      this.repaint();
      }

    @Override
    public void componentResized(ComponentEvent e) {
       current_width=this.getSize().getWidth();
        
       current_height=this.getSize().getHeight();
       
       current_actor.setScale(current_width/default_width, current_height/default_height);
       this.repaint();
    }
    
    public int getActorWidthSize(){
    return (int) this.getSize().getWidth();
    }
    
    
     public int getActorHeightSize(){
    return (int) this.getSize().getHeight();
    }
    
    public void UpdateFrameLable(String new_name){
    this.setTitle(new_name);
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
    
}
