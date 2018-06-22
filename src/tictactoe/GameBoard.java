/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  Represent the Game board
 */
package tictactoe;

import java.util.LinkedList;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class GameBoard 
{
      private  LinkedList<LinkedList<String>> Board; //game board
      
      //constructor
      public GameBoard()
      {
        Board=new LinkedList<>();
        PrepareGameBoard();
      }
      
      //return the value of Board
    public LinkedList<LinkedList<String>> getBoard() 
    {
        return Board;
    }
      
       //prepare the game board
    //add items to Board list
     private void PrepareGameBoard()
     {
         for (int i = 0; i < 3; i++) 
         {
             LinkedList<String> list=new LinkedList();
             for (int j = 0; j < 3; j++) 
             {
                  list.add("");
             }
             Board.add(list);
         }
     }
     
     //method to update the value of Board 
     //the row,column and value to update  to  must be pass as argument
      public void upDateBoard(int row, int column,String value)
     {                    
         this.Board.get(row).set(column,String.valueOf(value));        
     }
     
     
}
