import java.util.*;

public class TrafficLight implements Subject{
   private int currentState;
   private int stateCount;
   private int[] stateTimes = {6,3,8};
   public int maxTimeCount;
   public ArrayList<Observer> observers;
   
   public TrafficLight(){
      currentState = 1; 
      stateCount = 0;
      maxTimeCount = 6;
      observers = new ArrayList<Observer>();
   }
   
   public int getCurrentState(){return currentState;}
   
   public int getStateCount(){return stateCount;}
      
   public void setState(int i){
      if((i > 0)&&(i < 4)){
         currentState = i;
         stateCount = 0;
         updateObservers();
      }
   }
   
   public String toString(){
      String[] colours = {"Red","Yellow","Green"};
      return colours[currentState-1] + " Traffic Light";
   }
  
   public int advanceState(){
      currentState = ++currentState % 3 + 1;
      stateCount = 0;
      updateObservers();
      return currentState;
   }
   
   public void advanceTime(){
      stateCount++;
      updateObservers();
      
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
   
   private void updateObservers(){
      for(Observer observer:observers)
         observer.update();
   }
}