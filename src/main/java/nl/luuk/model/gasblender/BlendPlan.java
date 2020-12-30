package nl.luuk.model.gasblender;

import java.util.*;

public class BlendPlan {

  List<String> taskList = new ArrayList<>(); 
  
  public BlendPlan(){
    this.taskList.add("\n[-- Tasklist for Blending --] \n"); 
  }
  
  public String toString(){
    String result = "";
    for (String t : taskList){
      result += t + ",";
      
      System.out.println(t);
    }
    return result;
  }

}
