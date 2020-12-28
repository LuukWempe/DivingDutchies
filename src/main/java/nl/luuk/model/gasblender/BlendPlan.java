package nl.luuk;

import java.util.*;

public class BlendPlan {

  List<String> taskList = new ArrayList<>(); 
  
  public BlendPlan(){
    this.taskList.add("Tasklist for Blending"); 
  }
  
  public String toString(){
    String result = "";
    for (String t : taskList){
      result += t;
      System.out.println(t);
    }
    return result;
  }

}
