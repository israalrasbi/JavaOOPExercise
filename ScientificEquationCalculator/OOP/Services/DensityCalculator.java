package OOP.Services;

import OOP.Entities.PhysicsData;
import OOP.Interface.CalculatorInterface;

import java.util.Scanner;

public class DensityCalculator implements CalculatorInterface {
    private PhysicsData physicsData;
    public DensityCalculator(PhysicsData physicsData) {
        this.physicsData = physicsData;
    }

    public double calculateDensity() {
        double mass = physicsData.getMass();
        double volume = physicsData.getVolume();
        return mass / volume;
    }

    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Density Calculator Menu ---");
            System.out.println("1. Calculate Density (Density = Mass ÷ Volume)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Density: " + calculateDensity());
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting Density Calculator.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
