/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Rangbuoc 
{
     public static boolean kiemtrasonguyen(String check) {
        try 
        {
            int n = 0;
            n = Integer.parseInt(check);   
            return true; 
        } 
        catch (NumberFormatException e) 
        {
        }
        return false;
}

    

}
