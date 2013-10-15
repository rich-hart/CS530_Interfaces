/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/* ColorChooserDemo.java requires no other files. */
public class ColorChooserDemo extends JPanel
                              implements ChangeListener,ActionListener,DocumentListener  {

    protected JColorChooser pants_color_chooser,shirt_color_chooser;
 
    protected JLabel banner;
    protected MyActor current_actor;
    protected JButton happy, neutral, sad;
    protected JTextField name_field;
     
    public ColorChooserDemo() {
        
        super(new GridLayout(2,0));
        AbstractColorChooserPanel[] color_panels;
        current_actor = new MyActor();
        current_actor.setPreferredSize(new Dimension(200, 600));
        //Set up the banner at the top of the window
        banner = new JLabel("Welcome to the Tutorial Zone!",
                            JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(200, 200));

        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

 
        
                //Set up color chooser for setting pants
        shirt_color_chooser = new JColorChooser(banner.getForeground());
        shirt_color_chooser.setDragEnabled(true);
        shirt_color_chooser.getSelectionModel().addChangeListener(this);
        shirt_color_chooser.setBorder(BorderFactory.createTitledBorder(
                                             "Shirt"));
        //remove the preview panel
        shirt_color_chooser.setPreviewPanel(new JPanel());
        color_panels = shirt_color_chooser.getChooserPanels();
        
        //remove all color chooser panels except for one.
        for(int i =0; i<color_panels.length;i++){
            if(!(i==2)){
            shirt_color_chooser.removeChooserPanel(color_panels[i]);
            }
        }
        
        add(shirt_color_chooser);

        
               //Set up color chooser for setting pants
        pants_color_chooser = new JColorChooser(banner.getForeground());
        pants_color_chooser.getSelectionModel().addChangeListener(this);
        pants_color_chooser.setBorder(BorderFactory.createTitledBorder(
                                             "Pants"));
        //remove the preview panel
        pants_color_chooser.setPreviewPanel(new JPanel());
       color_panels = pants_color_chooser.getChooserPanels();
        
        //remove all color chooser panels except for one.
        for(int i =0; i<color_panels.length;i++){
            if(!(i==2)){
            pants_color_chooser.removeChooserPanel(color_panels[i]);
            }
        }
        
        add(pants_color_chooser);
 
        
        //add(bannerPanel);
        
        //add(new_actor);
        
        
        
        happy = new JButton("Happy");
        happy.addActionListener(this);
        happy.setPreferredSize(new Dimension(100,100));
        neutral = new JButton("Neutral");
        neutral.addActionListener(this);
        neutral.setPreferredSize(new Dimension(100,100));
        sad = new JButton("Sad");
        sad.addActionListener(this);
        sad.setPreferredSize(new Dimension(100,100));
        //add(happy);
        //add(neutral);
        //add(sad);
        
        
         //defining the name field
        
        name_field   = new JTextField(20);
        name_field.setPreferredSize(new Dimension(100,30));
        name_field.addActionListener(this);
     name_field.getDocument().addDocumentListener(this);
       // add(name_field);
        
    }
    public MyActor getActor(){
    return current_actor;
    }
    
    public void setActor(MyActor new_actor){
    this.current_actor=new_actor;
    }
    
    
    public void stateChanged(ChangeEvent e) {
        Color newColor; 
        
        if(e.getSource().equals(pants_color_chooser.getSelectionModel())){
          newColor  = pants_color_chooser.getColor();
        current_actor.setPantsColor(newColor);
        }
        
        if(e.getSource().equals(shirt_color_chooser.getSelectionModel())){
             newColor  = shirt_color_chooser.getColor();
        current_actor.setTorsoColor(newColor);
        }
       
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ColorChooserDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(happy)){
       // current_actor.setEmotion(Expression.HAPPY);
        }
        
         if(e.getSource().equals(neutral)){
      //  current_actor.setEmotion(Expression.NEUTRAL);
        }
         
          if(e.getSource().equals(sad)){
        //  current_actor.setEmotion(Expression.SAD);
        }
          
          if(e.getSource().equals(name_field)){
   
          }
    }
    
  
    @Override
    public void insertUpdate(DocumentEvent e) {
       current_actor.setActorName(name_field.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        current_actor.setActorName(name_field.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
       current_actor.setActorName(name_field.getText());
    }
}