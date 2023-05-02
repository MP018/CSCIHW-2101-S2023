package HW2;
import java.util.Scanner;

public class MathGames {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //call pythagorean method
        System.out.println("What is the base of the triangle:");
        double a = input.nextDouble();
        System.out.print("What is the perpendicular of the triangle:");
        double b = input.nextDouble();
        pythagorean(a, b);

        //call grade value
        System.out.println("What is your grade:");
        double grade = input.nextDouble();
        grade(grade);

        //call tip per person
        System.out.println("What is the total bill:");
        double total = input.nextDouble();
        System.out.println("How many people are splitting the bill:");
        int people = input.nextInt();
        System.out.println("What is the tip percentage (whole number):");
        double tip = input.nextDouble();
        
        billing(total, people, tip);
    
        input.close();
    }

    public static double pythagorean(double a, double b) {
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        
        System.out.println("The hypotenuse of the triangle is " + c);
        
        return c;
    }

    public static String grade(double grade) {

        double roundup = Math.ceil(grade);
        String letterGrade;

        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        System.out.println("Your grade is " + letterGrade);

        return letterGrade;
}

    public static double billing(double total, int people, double tip){
        double tipAmount = total * (tip/100);
        double totalAmount = Math.ceil(total + tipAmount);
        double perPerson = Math.ceil(totalAmount/people);
        
        System.out.println("The total bill, including tip is $" + totalAmount + " and each person owes $" + perPerson);

        return perPerson;
    }

}




// You can either create a tester class or put your code here
    //public static void main(String[] args){
        
    //}
//}
