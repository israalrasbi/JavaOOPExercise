package OOP.Services;

import OOP.Entities.CircleData;
import OOP.Interface.CalculatorInterface;

import java.util.Scanner;

public class AreaOfCircleCalculator implements CalculatorInterface {
    private CircleData circleData;

    public AreaOfCircleCalculator(CircleData circleData) {
        this.circleData = circleData;
    }

    public double calculateAreaOfCircle(){
        double PI = Math.PI;
        double radius = circleData.getRadius();
        double result = PI*radius*radius;
        return Math.round(result*Math.pow(10,2))/Math.pow(10,2);
    }

    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Area Of A Circle Calculator Menu ---");
            System.out.println("1. Calculate  Area Of A Circle (A = πr²)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" Area Of A Circle: " + calculateAreaOfCircle());
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting  Area Of A Circle Calculator.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
