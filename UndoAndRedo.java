/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dja.project;

/**
 *
 * @author nianc
 */

//-------------------------------------------Question 1---------------------------------------------------------
import java.util.Stack;

//this is basically 1.4 but the original code for 1.2 before I changed it for 1.4 is in my word document.

public class UndoAndRedo {
    private static final int maxSize = 5;//add a constant max value of 5 actions
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    
    public UndoAndRedo(){
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
    
    public String undo(int steps){
        StringBuilder function = new StringBuilder();
        for(int i = 1; i <= steps && !undoStack.isEmpty(); i++){
            String perform = undoStack.pop();
            redoStack.push(perform);
            function.append("Undo action " + i + ":" + perform);
        }
        
        if (function.length() == 0){
            return "Nothing to undo";
        }else {
            return function.toString();
        }
    }
    
    public String redo(int steps){
        StringBuilder function = new StringBuilder();
        for(int i = 1; i <= steps && !redoStack.isEmpty(); i++){
            String perform = redoStack.pop();
            undoStack.push(perform);
            function.append("Redo action " + i + ":" + perform);
        }
        
        if (function.length() == 0){
            return "Nothing to redo";
        }else {
            return function.toString();
        }
    }
    
    public void DoAction(String perform){
        
        if (undoStack.size() == maxSize){ //ensuring doesnt go past 5 actions
            undoStack.remove(0);
        }
        undoStack.push(perform);
        redoStack.clear();
    }
  
    public static void main(String[] args){
        UndoAndRedo action = new UndoAndRedo();
        
        action.DoAction(" 1 ");
        action.DoAction(" 2 ");
        action.DoAction(" 3 ");
        action.DoAction(" 4 ");
        action.DoAction(" 5 ");
        action.DoAction(" 6 ");
        
        System.out.println(action.undo(6));
        System.out.println(action.redo(2));
    }
}