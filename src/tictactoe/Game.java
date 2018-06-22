/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class Game 
{
       private int PlayerTurn=0; //play turn value of 0 is player 1 and 1 is player two
       private boolean IsGameEnd=false; // determine if game has ended  
       private String Winner=""; 
       private  GameBoard GameBoard; //list of dynamic control
       private final String[] WINTEST={"O","X"};   //store value of either game draw or the player name that won the game
       private String CurrentPlayerToken="O";
       
    
    
//constructor
     public Game() 
     {
       // Board=new LinkedList<>();
         GameBoard=new GameBoard();
       // PrepareGameBoard();
    }
     
     
     //return the value of Board
    public LinkedList<LinkedList<String>> getBoard() 
    {
        return GameBoard.getBoard();
    }
    
    //return the value of currenPlayerTOken
    public String getCurrentPlayerToken() 
    {
        return CurrentPlayerToken;
    }
    //return the value of PlayerTurn
    public int getPlayerTurn() 
    {
        return PlayerTurn;
    }
    
    //return the value of IsGameEnd
     public boolean isIsGameEnd() 
     {
        return IsGameEnd;
     }
     
     //return the value of Winner
    public String getWinner() 
    {
        return Winner;
    }
         
     //method for a player to take turn
     //method accept the last character of the name of the control
     //the player click.
     //either a label, or button
     public void takeTurn(int name,int column)
     {         
      //  name=name-1;
        int row;
         if (name<=3)  //the value of name is <=2 than it's row 0 of Board
         {
             row=0;
            // upDateBoard(row,column);//method call to update board
             GameBoard.upDateBoard(row, column,this.PlayerTurn==0?WINTEST[0]:WINTEST[1]);
         }
         else if(name>3 && name<=6) //the value of name is <=6 than it's row 1 of Board
         {
           row=1;
         //  upDateBoard(row,column);//method call to update board
            GameBoard.upDateBoard(row, column,this.PlayerTurn==0?WINTEST[0]:WINTEST[1]);
         }
         else  //row 2
         {
           row=2;
          // upDateBoard(row,column);//method call to update board
            GameBoard.upDateBoard(row, column,this.PlayerTurn==0?WINTEST[0]:WINTEST[1]);
         }
        // updateControlText(button);
         this.determineGameEnd(); //method call
         
         if (this.isIsGameEnd()) //IsGameEnd is true
         {
             
         }
            
         else //IsGameEnd is false
         {
             //if the value of playerTurn is 0 then the value of PlayerTurn is set to 1 else it's set to 0
            if (PlayerTurn==0)  
            {
                PlayerTurn=1;
                this.CurrentPlayerToken=WINTEST[1];
            }  
            else if(PlayerTurn==1)
            {
                PlayerTurn=0;
                this.CurrentPlayerToken=WINTEST[0];
            }
         }
       
        
     }
     
       
    //determine if the game has ended
    private void determineGameEnd()
    {
          if (checkRowForWinner())
            {
                IsGameEnd = true;
                Winner = (PlayerTurn == 0) ? "Player 1 wins" : "Player2 wins";      
                return;
            }
          
            if (checkDiagonalForWinner())
            {
                IsGameEnd = true;
                Winner = (PlayerTurn == 0) ? "Player 1 wins" : "Player2 wins";
                return;
            }

           if (checkColumnForWinner())
            {
                IsGameEnd = true;
                Winner = (PlayerTurn == 0) ? "Player 1 wins" : "Player2 wins";
                return;
            }
           
           if (checkForDraw()) 
           {
             IsGameEnd = true;
             Winner = "Game Draw";
           }
    }
    
    //check each row for a winner
    private boolean checkRowForWinner()
    {
            boolean win = false;
            for (String item : WINTEST)
            {
                
                for (int i = 0; i < GameBoard.getBoard().size(); i++)
                {
                    if (GameBoard.getBoard().get(i).get(0).equals(item) && GameBoard.getBoard().get(i).get(1).equals(item) && GameBoard.getBoard().get(i).get(2).equals(item))
                    {
                        win = true;
                    }
                }
            }
            return win;
    }
    
    //check column row for a winner
     private boolean checkColumnForWinner()
    {
            boolean win = false;
            for (String item : WINTEST)
            {
                for (int i = 0; i < GameBoard.getBoard().size(); i++)
                {
                    if (GameBoard.getBoard().get(0).get(i).equals(item) && GameBoard.getBoard().get(1).get(i).equals(item) && GameBoard.getBoard().get(2).get(i).equals(item))
                    {
                        win = true;
                    }
                }
            }
            return win;
    }
     
     //check each each diagonal for a winner
    private boolean checkDiagonalForWinner()
    {
          boolean win = false; //deterine if there is a winnner
            for (String item : WINTEST) //for each item in WINTEST
            {
                //if the item at each location equals item
                    if (GameBoard.getBoard().get(0).get(0).equals(item) && GameBoard.getBoard().get(1).get(1).equals(item) && GameBoard.getBoard().get(2).get(2).equals(item))
                    {
                        win = true; //win is set to true
                    }
                    
                else if(GameBoard.getBoard().get(0).get(2).equals(item) && GameBoard.getBoard().get(1).get(1).equals(item) && GameBoard.getBoard().get(2).get(0).equals(item))
                {
                    win = true;
                }
            }
            return win;
    }
    
    //method to check if the game draw;
    private boolean checkForDraw()
    {
      boolean isDraw=true;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) 
            {
                if (GameBoard.getBoard().get(i).get(j).length()<1) 
                {
                    isDraw=false;
                    break;
                }      
            }
            if (isDraw==false) 
            {
                break;
            }
        }
      return isDraw;
    }
}
