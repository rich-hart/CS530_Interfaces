/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
 

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class Main {
  public static void main(String[] argv) {
      JFrame frame = new JFrame();
    JColorChooser chooser = new JColorChooser();
   AbstractColorChooserPanel[] color_panels= chooser.getChooserPanels();
    for(int i =0; i<color_panels.length;i++){
            if(i==2){
              AbstractColorChooserPanel temp_panel =  color_panels[i];
             Component random_comp =  temp_panel.getComponent(0);
             random_comp.setVisible(false);
           //temp_panel.remove(random_comp);
            }
            
        }
    chooser.addChooserPanel(new MyChooserPanel());
    frame.add(chooser);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class MyChooserPanel extends AbstractColorChooserPanel {
  public void buildChooser() {
    setLayout(new GridLayout(0, 3));
    makeAddButton("Red", Color.red);
    makeAddButton("Green", Color.green);
    makeAddButton("Blue", Color.blue);
  }

  public void updateChooser() {
  }

  public String getDisplayName() {
    return "MyChooserPanel";
  }

  public Icon getSmallDisplayIcon() {
    return null;
  }
  public Icon getLargeDisplayIcon() {
    return null;
  }
  private void makeAddButton(String name, Color color) {
    JButton button = new JButton(name);
    button.setBackground(color);
    button.setAction(setColorAction);
    add(button);
  }

  Action setColorAction = new AbstractAction() {
    public void actionPerformed(ActionEvent evt) {
      JButton button = (JButton) evt.getSource();

      getColorSelectionModel().setSelectedColor(button.getBackground());
    }
  };
}
