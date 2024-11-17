import OOP.Entities.*;
import OOP.Services.*;

import java.util.Scanner;

public class CalculatorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Scientific Equation Calculator!");

        //input for MotionData
        System.out.println("\n--- Enter Motion Data ---");
        System.out.print("Enter Initial Velocity (u): ");
        double initialVelocity = scanner.nextDouble();
        System.out.print("Enter Acceleration (a): ");
        double acceleration = scanner.nextDouble();
        System.out.print("Enter Time (t): ");
        double time = scanner.nextDouble();
        MotionData motionData = new MotionData(initialVelocity, acceleration, time, new BaseData("1", "Motion Data Example"));

        //input for CircleData
        System.out.println("\n--- Enter Circle Data ---");
        System.out.print("Enter Radius (r): ");
        double radius = scanner.nextDouble();
        CircleData circleData = new CircleData(radius, new BaseData("2", "Circle Data Example"));

        //input for InterestData
        System.out.println("\n--- Enter Interest Data ---");
        System.out.print("Enter Principal (P): ");
        double principal = scanner.nextDouble();
        System.out.print("Enter Rate (R): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter Time (T): ");
        double interestTime = scanner.nextDouble();

        //input for PhysicsData
        System.out.println("\n--- Enter Physics Data ---");
        System.out.print("Enter Mass (m): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter Volume (v): ");
        double volume = scanner.nextDouble();
        PhysicsData physicsData = new PhysicsData(mass, acceleration, motionData, volume);

        InterestData interestData = new InterestData(principal, rate, interestTime, physicsData);

        //calculators
        FinalVelocityCalculator finalVelocityCalculator = new FinalVelocityCalculator(motionData);
        AreaOfCircleCalculator areaOfCircleCalculator = new AreaOfCircleCalculator(circleData);
        SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator(interestData);
        ForceCalculator forceCalculator = new ForceCalculator(physicsData);
        DensityCalculator densityCalculator = new DensityCalculator(physicsData);

        //main Menu
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Scientific Equation Calculator Main Menu ---");
            System.out.println("1. Final Velocity Calculator");
            System.out.println("2. Area of Circle Calculator");
            System.out.println("3. Simple Interest Calculator");
            System.out.println("4. Force Calculator");
            System.out.println("5. Density Calculator");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    finalVelocityCalculator.calculate();
                    break;
                case 2:
                    areaOfCircleCalculator.calculate();
                    break;
                case 3:
                    simpleInterestCalculator.calculate();
                    break;
                case 4:
                    forceCalculator.calculate();
                    break;
                case 5:
                    densityCalculator.calculate();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the Scientific Equation Calculator");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }


}
