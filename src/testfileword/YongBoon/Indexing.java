/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileword.YongBoon;

import testfileword.Main;

/**
 *
 * @author User
 */
public class Indexing {
    public void start(){
        String input;
        while (true) {
            while (true) {
                Main.clearScreen();
                 MenuUI();
                 input = Main.scan.nextLine();
                 
                 if (Main.checkInputMenu(2, input)) {
                     break;
                 }
  
            }// end Menu Loop
            if (input.equals("2")) {
                break;
            }
            
            switch(input) {
                case "1":
                    StudentIDHash as = new StudentIDHash();
                    as.start();
                    break;
//                case "2":
//                    RegistrationIDHash rs = new RegistrationIDHash();
//                    rs.start();
//                    break;
            }
            
        }// End Module Loop
        
       
    }
    
    private void MenuUI() {
        System.out.println("Select Following Action : ");
        System.out.println("1. Student ID");
       // System.out.println("2. Registration ID");
        System.out.println("2. Return");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }
}
