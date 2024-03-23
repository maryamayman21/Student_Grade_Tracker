import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Mariam
 */
public class StudentGradeTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<Double> studentGrades = new ArrayList<Double>();
        double gradesSum = 0;      
        Scanner input = new Scanner(System.in);
        
        // Validation for number of students input
        int studentCount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter number of students:");
                studentCount = input.nextInt();
                if (studentCount <= 0) {
                    System.out.println("Please enter a valid number of students (greater than 0).");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer number for the count of students.");
                input.next(); // Consume invalid input
            }
        }
              
        System.out.println("Enter students' grades:");
       
        // Input validation and processing
        for (int i = 0; i < studentCount; i++) {
            try {
                System.out.println("Enter grade for student " + (i + 1) + ":");
                double grade = input.nextDouble();
                // Validate grade range
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                    i--; // Decrement i to re-enter grade for current student
                    continue;
                }
                gradesSum += grade;
                studentGrades.add(grade);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numeric grade.");
                input.next(); // Consume invalid input
                i--; // Decrement i to re-enter grade for current student
            }
        }
        
        double averageStudentGrades = gradesSum / studentCount;
        // Print average grade 
        System.out.println("Average students' grade: " + averageStudentGrades);
        
        // Calculating max and min grades 
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        
        for (double grade : studentGrades) {
            if (max < grade)
                max = grade;
            
            if (min > grade)
                min = grade;
        }
        
        // Print max and min grades 
        System.out.println("Max student grade: " + max);
        System.out.println("Min student grade: " + min);
        
        System.out.println("Students' grades:");
        System.out.println(studentGrades);
        
        input.close();
        
        
    }
    
}
