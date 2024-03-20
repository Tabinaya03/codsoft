import java.util.Scanner;
public class GradeCalculator
 {
    public static void main(String[] args) 
      {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Grade Calculator!");
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        double[] grades = new double[numGrades];
        double[] weights = new double[numGrades];
        double totalWeight = 0;
        for (int i = 0; i < numGrades; i++)
        {
            System.out.printf("Enter grade #%d: ", i + 1);
            grades[i] = scanner.nextDouble();
            System.out.printf("Enter weight for grade #%d: ", i + 1);
            weights[i] = scanner.nextDouble();
            totalWeight += weights[i];
        }
        double weightedSum = 0;
        for (int i = 0; i < numGrades; i++) 
        {
            weightedSum += (grades[i] * (weights[i] / totalWeight));
        }

        System.out.printf("Weighted average grade: %.2f\n", weightedSum);

        scanner.close();
    }
}
