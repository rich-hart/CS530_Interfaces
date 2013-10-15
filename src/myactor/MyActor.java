/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

import java.awt.*;
import javax.swing.*;

public class MyActor extends Canvas {
    
    String name = "Bob";
    double screen_width;
    double screen_height;
    double x_scale = 1.0;
    double y_scale = 1.0;
    Expression emotion;
    Color torso_color;
    Color pants_color;
    
    

    public MyActor() {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen_width = screenSize.getWidth();
        screen_height = screenSize.getHeight();
        emotion=Expression.HAPPY;
        torso_color=Color.YELLOW;
        pants_color=Color.BLUE;
       

    }
    
    public MyActor(Expression emotion, Color torso_color, Color pants_color) {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen_width = screenSize.getWidth();
        screen_height = screenSize.getHeight();
        this.emotion=emotion;
        this.torso_color=torso_color;
        this.pants_color=pants_color;
        
        
    }

    public void paint(Graphics graphics) {
        
        graphics.setColor(Color.WHITE);
        drawFace(graphics);
        drawLegs(graphics);
        drawTorso(graphics);
        //drawName(graphics);
       

    }
    
    private void drawName(Graphics graphics){
    graphics.setColor(Color.BLACK);
     graphics.drawString(name, 20, 20);
    }

    private void drawFace(Graphics graphics) {
        
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int)(0* x_scale), (int) (0*y_scale), (int)(400*x_scale), (int) (400*y_scale));
        graphics.setColor(Color.BLACK);
        graphics.drawOval((int)(100* x_scale),(int) (100*y_scale), (int)(100* x_scale), (int) (100*y_scale));
        graphics.drawOval((int)(120* x_scale), (int) (125*y_scale), (int)(20* x_scale), (int) (20*y_scale));
        graphics.drawOval((int)(160* x_scale), (int) (125*y_scale), (int)(20* x_scale), (int) (20*y_scale));

        switch (emotion) {
            
            case HAPPY:
                graphics.drawOval((int)(125* x_scale), (int)(165* y_scale), (int)(50* x_scale), (int)(20* y_scale));
                graphics.setColor(Color.WHITE);
                graphics.fillRect((int)(125* x_scale), (int)(150* y_scale), (int)(50* x_scale), (int)(25* y_scale));
                break;
            case SAD:
                graphics.drawOval((int)(125* x_scale), (int)(165* y_scale), (int)(50* x_scale), (int)(20* y_scale));
                graphics.setColor(Color.WHITE);
                graphics.fillRect((int)(125* x_scale), (int)(175* y_scale), (int)(50* x_scale), (int)(18* y_scale));
                break;
            case NEUTRAL:
                graphics.drawLine((int)(125* x_scale), (int)(170* y_scale), (int)(175* x_scale), (int)(170* y_scale));
                break;

        }


    }

    private void drawTorso(Graphics graphics) {
        
        graphics.setColor(torso_color);
        graphics.fillRect((int)(50* x_scale), (int)(200* y_scale), (int)(200* x_scale), (int)(40* y_scale));
        graphics.fillRect((int)(100* x_scale), (int)(240* y_scale), (int)(100* x_scale), (int)(40* y_scale));

    }

    private void drawLegs(Graphics graphics) {
        
        graphics.setColor(pants_color);
        int[] xPoints = {(int)(200* x_scale), (int)(300* x_scale), (int)(0* x_scale), (int)(100* x_scale), (int)(200* x_scale)};
        int[] yPoints = {(int)(280* y_scale), (int)(380* y_scale), (int)(400* y_scale), (int)(280* y_scale), (int)(280* y_scale)};

        graphics.fillPolygon(xPoints, yPoints, 5);
        graphics.setColor(Color.WHITE);
        int[] trixPoints = {(int)(0* x_scale), (int)(400* x_scale), (int)(150* x_scale)};
        int[] triyPoints = {(int)(400* y_scale), (int)(400* y_scale), (int)(310* y_scale)};

        graphics.fillPolygon(trixPoints, triyPoints, 3);

    }
    
    public void setPantsColor(Color pants_color){
           this.pants_color=pants_color;
          this.repaint();
          
    }
    
    public void setTorsoColor(Color torso_color){
           this.torso_color=torso_color;
          this.repaint();
          
    }
    
    public void setEmotion(Expression emotion){
           this.emotion=emotion;
           this.repaint();
    }
    
      public void setActorName(String name){
           this.name=name;
           this.repaint();
    }
      
       public String getActorName(){
           return this.name; 
    }

      public void setScale(double x, double y){
      x_scale=x;
      y_scale=y;
      this.repaint();
      }

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        MyActor canvas = new MyActor(Expression.HAPPY,Color.BLACK,Color.BLUE);
   
        canvas.setPreferredSize(new Dimension(100,100));
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        //frame.setSize((int) width / 2, (int) height / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
    }
}