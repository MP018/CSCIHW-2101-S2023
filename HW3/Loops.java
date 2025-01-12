package HW3;
import java.util.Scanner;

public class Loops {

    //NOTE: DO NOT change anything in the boiler plate
    //If I added default code it is meant to be there
    //and should not be adjusted unless otherwise noted
    //(return statments are usually changed)

    //Make a method that will return true if a given 
    //String contains between 1 and 3 'e' chars.
    //Ex.
    //loopE("eat") -> true
    //eeat -> true
    //eeeat -> true
    //eeeeat -> false

    public static boolean loopE(String str){

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                count++;

                if (count > 3) {
                    boolean result = false;
                    
                }
            }     
        }
        boolean result = count >= 1 && count <= 3; // <- this should be changed 
        System.out.println(result);
            
        return result;
        
    
    }



    //Given a String str and int n return a larger string
    //that is n copies of the original string 
    //Ex.
    //stringTimes("Code",2) ->"CodeCode"
    //stringTimes("Code",4) ->"CodeCodeCodeCode"

    public static String stringTimes(String str, int n) {
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(str);
    
        }
        String resultStringTimes = sb.toString();
        System.out.println(resultStringTimes);
        return resultStringTimes;
        //return sb.toString(); // <- this should be changed 
    } 



    //Create a method Given a string, return the string where all of the "z"
    //Have been removed. Except do not remove a z at the start
    //or end
    //Ex.
    //stringZ("zHelloz") -> "zHelloz"
    //stringZ("nozthaznks") -> "nothanks"
    //stringZ("xksiazdjaasldzsajzasdz") -> "xksiadjaasldsajasdz"

    public static String stringZ(String str){
        char[] charArray = str.toCharArray();

        for (int i = 1; i < charArray.length -1; i++) {
            if (charArray[i] == 'z' && charArray[i + 1] != '\0' && i != 1) {
                charArray[i] = '\0';
            }

        }

        String result = new String(charArray);
        System.out.println(result);
        return result; // <- this should be changed 
    }



    //Create a method that contains a while loop that allows for
    //The user to input numbers until the number 0 is entered. Each time a number is 
    //entered the total will be summed and then prompted for a second number. 
    //NOTE: I require the use of scanner here to get each integer from the user
    //Assume the numbers entered are integers
    //Also note that the method is void meaning you will not need to return anything
    //It will need to sysout the numbers however
    //Below is a sample output what I would like
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 2
    // The total so far is 24.
    // Number: 3
    // The total so far is 27.
    // Number: 0
    // TOTAL ENDED --- The total is 27.
    
    public static void sums(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("I will add up the numbers you give me....");

        int sum = 0;
        int number = -1;

        while (number != 0) {
            System.out.print("Number: ");
            number = scanner.nextInt();
            sum += number;
            System.out.println("The total so far is " + sum + ".");
        }

        System.out.println("TOTAL ENDED --- The total is " + sum + ".");

        scanner.close();
    }

    public static void main(String[] args) {
        loopE("eat");
        loopE("eeat");
        loopE("eeeat");
        loopE("eeeeat");
        stringTimes("Code",2);
        stringTimes("Code",4);
        stringZ("zHelloz");
        stringZ("nozthaznks");
        stringZ("xksiazdjaasldzsajzasdz");
        sums();

        // Add code to help test your methods here

    }
    
}
