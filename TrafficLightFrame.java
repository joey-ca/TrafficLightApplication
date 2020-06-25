import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TrafficLightFrame extends JFrame implements Observer{
   
   private TrafficLight model;
   private TrafficLightPanel view;
   private ActionListener comboBoxListener;
   private Timer aTimer;
   
   public TrafficLightFrame(String name,TrafficLight aModel,TrafficLightPanel aView){
      super(name);
      model = aModel;
      view = aView;
      setContentPane(view);
      
      for(int i = 0; i < 3; i++){
         view.getRadioButton(i).addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               handleRadioButtonEvent((JRadioButton)e.getSource());
            }
         });
      }
      
      view.getActionList().addActionListener(comboBoxListener = new ActionListener(){
         public void actionPerformed(ActionEvent e){
            handleComboBoxEvent((JComboBox)e.getSource());
         }
      });
      
      view.getAdvButton().addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            handleAdvanceButtonEvent();
         }
      });
      
      view.getAutoButton().addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            handleAutoButtonPress((JCheckBox)e.getSource());
         }
      });
      
      aTimer = new Timer(1000,new ActionListener(){
         public void actionPerformed(ActionEvent e){
            handleTimerTick();
         }
      });
      
      view.getSlider().addChangeListener(new ChangeListener(){
         public void stateChanged(ChangeEvent e){
            handleSliderEvent((JSlider)e.getSource());
         }
      });
      
      model.registerObserver(this);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(400,250);
   }
   
   private void handleRadioButtonEvent(JRadioButton source){
      for(int i = 0; i < 3; i++){
         if(view.getRadioButton(i) == source)
            model.setState(i+1);
      }
   }
   
   private void handleComboBoxEvent(JComboBox source){
      model.setState(source.getSelectedIndex()+1);
   }

   private void handleAdvanceButtonEvent(){
      model.advanceState();
   }
   
   private void handleAutoButtonPress(JCheckBox source){
      if(source.isSelected())
         aTimer.start();
      else
         aTimer.stop();
   }
   
   private void handleTimerTick(){
      model.advanceTime();
   }
   
   private void handleSliderEvent(JSlider source){
      if(!source.getValueIsAdjusting()){
         int delay = source.getValue();
         aTimer.setDelay(delay*1000);
         if(aTimer.isRunning())
            aTimer.restart();
      }
   }
   
   public void update(){
      view.getActionList().removeActionListener(comboBoxListener);
      radioButtonUpdate();
      comboBoxUpdate();
      advButtonUpdate();
      progressBarUpdate();
      view.getActionList().addActionListener(comboBoxListener);
   }
   
   private void radioButtonUpdate(){
      for(int i = 0; i < 3; i++){
         view.getRadioButton(i).setSelected(model.getCurrentState() == (i+1));     
      }
   }
   
   private void comboBoxUpdate(){
      view.getActionList().setSelectedIndex(model.getCurrentState()-1);
   }
   
   private void advButtonUpdate(){
      String[] imageName = {"traffic-lights-red.jpg","traffic-lights-yellow.jpg","traffic-lights-green.jpg"};
      view.getAdvButton().setIcon(new ImageIcon(imageName[model.getCurrentState()-1]));
   }
   
   private void progressBarUpdate(){
      view.getProgressBar().setValue(model.getStateCount());
      view.getProgressBar().setMaximum(model.maxTimeCount);
   }  
   
   public static void main(String args[]){
/*    TrafficLight aModel = new TrafficLight();
      TrafficLightFrame frameA = new TrafficLightFrame("Traffic Light A (tied with B)", aModel, new TrafficLightPanel());
      frameA.setVisible(true);
      TrafficLightFrame frameB = new TrafficLightFrame("Traffic Light B (tied with A)", aModel, new TrafficLightPanel());
      frameB.setVisible(true);
*/
      TrafficLightFrame frameC = new TrafficLightFrame("Traffic Light C (alone)", new TrafficLight(), new TrafficLightPanel());
      frameC.setVisible(true);
      
      //frame.aTimer.start();
   }
}