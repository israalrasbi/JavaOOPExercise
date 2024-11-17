package OOP.Services;

import OOP.Entities.MotionData;
import OOP.Interface.CalculatorInterface;

import java.util.Scanner;

public class FinalVelocityCalculator implements CalculatorInterface {
    private MotionData motionData;

    public double calculateFinalVelocity() {
        double u = motionData.getInitialVelocity();
        double a = motionData.getAcceleration();
        double t = motionData.getTime();
        return u + a * t;
    }

    public double calculateDisplacement() {
        double u = motionData.getInitialVelocity();
        double a = motionData.getAcceleration();
        double t = motionData.getTime();
        return u * t + 0.5 * a * t * t;
    }

    public double calculateFinalVelocitySquared() {
        double u = motionData.getInitialVelocity();
        double a = motionData.getAcceleration();
        //call the calculateDisplacement function to complete the equation
        double s = calculateDisplacement();
        return u * u + 2 * a * s;
    }

    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Final Velocity Calculator Menu ---");
            System.out.println("1. Calculate Final Velocity (v = u + at)");
            System.out.println("2. Calculate Displacement (s = ut + ½at²)");
            System.out.println("3. Calculate Final Velocity Squared (v² = u² + 2as)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Final Velocity: " + calculateFinalVelocity());
                    break;
                case 2:
                    System.out.println("Displacement: " + calculateDisplacement());
                    break;
                case 3:
                    System.out.println("Final Velocity Squared: " + calculateFinalVelocitySquared());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Final Velocity Calculator.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
