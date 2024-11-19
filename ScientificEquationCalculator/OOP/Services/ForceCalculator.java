package OOP.Services;

import OOP.Entities.PhysicsData;
import OOP.Interface.CalculatorInterface;

import java.util.Scanner;

public class ForceCalculator implements CalculatorInterface {
    private PhysicsData physicsData;

    public ForceCalculator(PhysicsData physicsData) {
        this.physicsData = physicsData;
    }

    public double calculateForce() {
        double m = physicsData.getMass();
        double a = physicsData.getAcceleration();
        return m * a;
    }

    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Force Calculator Menu ---");
            System.out.println("1. Calculate Force (F = ma)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Force: " + calculateForce());
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting Force Calculator.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
