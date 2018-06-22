/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class Player 
{
   private String Name;
   private boolean IsTurn;
   
    public String getName() 
    {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isIsTurn() {
        return IsTurn;
    }

    public void setIsTurn(boolean IsTurn) {
        this.IsTurn = IsTurn;
    }
   
   
   public Player(String name)
   {
       this.Name=name;
   }
}
