import java.awt.*;
import javax.swing.*;

public class TrafficLightPanel extends JPanel{
   private JRadioButton[] buttons;
   private JButton advButton;
   private JComboBox actionList;
   private JProgressBar progressBar;
   private JSlider slider;
   private JCheckBox autoButton;
   
   public JRadioButton getRadioButton(int i){return buttons[i];}   
   public JButton getAdvButton(){return advButton;}
   public JComboBox getActionList(){return actionList;}
   public JProgressBar getProgressBar(){return progressBar;}
   public JSlider getSlider(){return slider;}
   public JCheckBox getAutoButton(){return autoButton;}
   
   public TrafficLightPanel(){
      GridBagLayout layout = new GridBagLayout();
      GridBagConstraints constraints = new GridBagConstraints();
      setLayout(layout);
            
      JLabel label1 = new JLabel("Manual");
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 0;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.NONE;
      constraints.insets = new Insets(5,5,0,0);
      layout.setConstraints(label1,constraints);
      add(label1);
      
      JLabel label2 = new JLabel("Action");
      constraints.gridx = 1;
      constraints.gridy = 0;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 0;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.NONE;
      constraints.insets = new Insets(5,5,0,0);
      layout.setConstraints(label2,constraints);
      add(label2);

      JLabel label3 = new JLabel("Advance");
      constraints.gridx = 2;
      constraints.gridy = 0;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 0;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.NONE;
      constraints.insets = new Insets(5,5,0,5);
      layout.setConstraints(label3,constraints);
      add(label3);
      
      JLabel label4 = new JLabel("Timer Progress");
      constraints.gridx = 0;
      constraints.gridy = 4;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 0;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.NONE;
      constraints.insets = new Insets(5,5,0,0);
      layout.setConstraints(label4,constraints);
      add(label4); 
      
      JPanel aPanel = new JPanel(); 
      aPanel.setLayout(new BoxLayout(aPanel,BoxLayout.Y_AXIS));
      aPanel.setBackground(Color.black); 
      ButtonGroup group = new ButtonGroup();
      buttons = new JRadioButton[3];
      for(int i = 0;i < 3;i++){
         buttons[i] = new JRadioButton("",false);
         buttons[i].setBackground(Color.black);
         aPanel.add(buttons[i]);
         group.add(buttons[i]);
      }
      buttons[0].setText("Red");       
      buttons[1].setText("Yellow");
      buttons[2].setText("Green"); 
      buttons[0].setForeground(Color.red);    
      buttons[1].setForeground(Color.yellow); 
      buttons[2].setForeground(Color.green); 
      buttons[0].setSelected(true);
      
      constraints.gridx = 0;
      constraints.gridy = 1;
      constraints.gridwidth = 1;
      constraints.gridheight = 3;
      constraints.weightx = 0;
      constraints.weighty = 1;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.BOTH;
      constraints.insets = new Insets(5,5,0,0);
      layout.setConstraints(aPanel,constraints);
      add(aPanel);
      
      String[] list = {"Stop","Yield","Go"}; 
      actionList = new JComboBox(list);
      constraints.gridx = 1;
      constraints.gridy = 1;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 1;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.NORTHWEST;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.insets = new Insets(5,0,0,0);
      layout.setConstraints(actionList,constraints);
      add(actionList);

      autoButton = new JCheckBox("Auto Advance");
      constraints.gridx = 1;
      constraints.gridy = 2;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 1;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.NORTHWEST;
      constraints.fill = GridBagConstraints.NONE;
      constraints.insets = new Insets(5,0,0,0);
      layout.setConstraints(autoButton,constraints);
      add(autoButton);
      
      slider = new JSlider(JSlider.HORIZONTAL,0,20,0);
      slider.setMajorTickSpacing(5);
      slider.setMinorTickSpacing(1);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      constraints.gridx = 1;
      constraints.gridy = 3;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;
      constraints.weightx = 1;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.NORTHWEST;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.insets = new Insets(5,0,0,0);
      layout.setConstraints(slider,constraints);
      add(slider);
      
      advButton = new JButton(new ImageIcon("traffic-lights-red.jpg"));
      constraints.gridx = 2;
      constraints.gridy = 1;
      constraints.gridwidth = 1;
      constraints.gridheight = 3;
      constraints.weightx = 0;
      constraints.weighty = 1;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.VERTICAL;
      constraints.insets = new Insets(5,2,0,5);
      layout.setConstraints(advButton,constraints);
      add(advButton);
            
      progressBar = new JProgressBar(JProgressBar.HORIZONTAL,0,6);      
      constraints.gridx = 0;
      constraints.gridy = 5;
      constraints.gridwidth = 3;
      constraints.gridheight = 1;
      constraints.weightx = 1;
      constraints.weighty = 0;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.BOTH;
      constraints.insets = new Insets(5,5,5,5);
      layout.setConstraints(progressBar,constraints);
      add(progressBar);
   }
   
}