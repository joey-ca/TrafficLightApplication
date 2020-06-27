import java.util.*;

/**
* The model of the TrafficLight app.
* Making the model implement the Subject interface allows it to inform all of the observers whenever there has been a change
*
* @author Guannan Zhao
* @version %I%, %G%
* @since 1.0
*/
public class TrafficLight implements Subject{
   
   // 1=red, 2=yellow, 3=green
   private int currentState;
   
   // Amount of time in this state
   private int stateCount;
   
   // The number of seconds (i.e., time units) that the traffic light remains in each state e.g. 6 for red light, 3 for yellow light, 8 for green light
   private int[] stateTimes = {6,3,8};
   
   public int maxTimeCount;
   public ArrayList<Observer> observers;
   
   // Constructor that makes a red traffic light
   public TrafficLight(){
      currentState = 1; 
      stateCount = 0;
      maxTimeCount = 6;
      observers = new ArrayList<Observer>();
   }
   
   // Return the state of the traffic light (as a number from 1 to 3)
   public int getCurrentState(){return currentState;}
   
   // Return the amount of time spent in the current state
   public int getStateCount(){return stateCount;}
   
   // Set the state of the traffic light (as a number from 1 to 3)
   // If the integer is out of range, do nothing
   public void setState(int i){
      if((i > 0)&&(i < 4)){
         currentState = i;
         stateCount = 0;
         
         // Tell the observer applications about this change
         updateObservers();
      }
   }
   
   // Return a string representation of the traffic light
   public String toString(){
      String[] colours = {"Red","Yellow","Green"};
      return colours[currentState-1] + " Traffic Light";
   }
   
   // Advance the traffic light to the next state
   public int advanceState(){
      currentState = ++currentState % 3 + 1;
      stateCount = 0;
      
      // Tell the observer applications about this change
      updateObservers();
      
      return currentState;
   }
   
   // Simulate a single time unit of time passing by
   public void advanceTime(){
      
      // Advance the time spent in the current state
      stateCount++;
      
      // Tell the observer applications about this change
      updateObservers();
      
      // Check if we have reached time limit for current state
      if(stateCount > stateTimes[currentState - 1]){
         advanceState();  
         maxTimeCount = stateTimes[currentState - 1];
         updateObservers(); 
      }                 
   }
      
   public void registerObserver(Observer observer){
      observers.add(observer);
   }
   
   public void unregisterObserver(Observer observer){
      observers.remove(observer);
   }
   
   // This method is called whenever there is a change to the model.
   // It informs all registered observer applications of the change.
   private void updateObservers(){
      for(Observer observer:observers)
         observer.update();
   }
}
