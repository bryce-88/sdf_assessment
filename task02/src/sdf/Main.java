package sdf;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        
        Console cons = System.console();
        
        String input;
        float $last = 0f; //this is also result of operation
        String[] arr = null; 
        String operation;
        float firstVal = 0f;
        float secondVal = 0f;


        input = cons.readLine("Welcome\n"); //assume user will type input in correct format after this
        while(true) {
            System.out.printf("> %s\n", input);
            arr = input.trim().split(" ");
            operation = arr[1];

            //user types exit
            if (arr.length < 2 && arr[0].equals("exit")) {
                System.out.println("Bye Bye");
                System.exit(1);
            } 
            
            if ((!arr[0].equals("$last"))) {
                firstVal = Float.parseFloat(arr[0]);
            } 

            if (!arr[2].equals("$last")) {
                secondVal = Float.parseFloat(arr[2]);
            }
            
            if (arr[0].equals("$last")) {
                firstVal = $last;
            } 

            if (arr[2].equals("$last")) {
                secondVal = $last;
            }

            switch (operation) {
                case Constants.PLUS: $last = firstVal + secondVal;
                break;
                case Constants.MINUS: $last = firstVal - secondVal;
                break;
                case Constants.DIVIDE: $last = firstVal / secondVal;
                break;
                case Constants.MULTIPLY: $last = firstVal * secondVal;
                break;
                default: 
            }
            

            System.out.printf("%.2f\n", $last);
            input = cons.readLine();
        }
        
    }
}