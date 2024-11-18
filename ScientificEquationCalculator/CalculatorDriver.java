import OOP.Entities.*;
import OOP.Services.*;

import java.util.Scanner;

public class CalculatorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Scientific Equation Calculator!");

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
                case 1: {
                    //final Velocity Calculator
                    System.out.println("\n--- Enter Motion Data ---");
                    System.out.print("Enter Initial Velocity (u): ");
                    double initialVelocity = scanner.nextDouble();
                    System.out.print("Enter Acceleration (a): ");
                    double acceleration = scanner.nextDouble();
                    System.out.print("Enter Time (t): ");
                    double time = scanner.nextDouble();
                    MotionData motionData = new MotionData(initialVelocity, acceleration, time, new BaseData("1", "Motion Data Example"));
                    FinalVelocityCalculator finalVelocityCalculator = new FinalVelocityCalculator(motionData);
                    finalVelocityCalculator.calculate();
                    break;
                }
                case 2: {
                    //area of Circle Calculator
                    System.out.println("\n--- Enter Circle Data ---");
                    System.out.print("Enter Radius (r): ");
                    double radius = scanner.nextDouble();
                    CircleData circleData = new CircleData(radius, new BaseData("2", "Circle Data Example"));
                    AreaOfCircleCalculator areaOfCircleCalculator = new AreaOfCircleCalculator(circleData);
                    areaOfCircleCalculator.calculate();
                    break;
                }
                case 3: {
                    //simple Interest Calculator
                    System.out.println("\n--- Enter Interest Data ---");
                    System.out.print("Enter Principal (P): ");
                    double principal = scanner.nextDouble();
                    System.out.print("Enter Rate (R): ");
                    double rate = scanner.nextDouble();
                    System.out.print("Enter Time (T): ");
                    double time = scanner.nextDouble();
                    //the mass and acceleration will not be used to calculate the simple interest
                    //it will be used for the PhysicsData that is part of InterestData
                    System.out.print("Enter Mass (m) (for dependent PhysicsData): ");
                    double mass = scanner.nextDouble();
                    System.out.print("Enter Acceleration (a) (for dependent PhysicsData): ");
                    double acceleration = scanner.nextDouble();
                    PhysicsData physicsData = new PhysicsData(mass, acceleration, null, 0.0);
                    InterestData interestData = new InterestData(principal, rate, time, physicsData);
                    SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator(interestData);
                    simpleInterestCalculator.calculate();
                    break;
                }
                case 4: {
                    //force Calculator
                    System.out.println("\n--- Enter Physics Data ---");
                    System.out.print("Enter Mass (m): ");
                    double mass = scanner.nextDouble();
                    System.out.print("Enter Acceleration (a): ");
                    double acceleration = scanner.nextDouble();
                    MotionData motionData = new MotionData(0.0, acceleration, 0.0, new BaseData("1", "Default Motion Data"));
                    PhysicsData physicsData = new PhysicsData(mass, acceleration, motionData, 0.0);
                    ForceCalculator forceCalculator = new ForceCalculator(physicsData);
                    forceCalculator.calculate();
                    break;
                }
                case 5: {
                    //density Calculator
                    System.out.println("\n--- Enter Physics Data ---");
                    System.out.print("Enter Mass (m): ");
                    double mass = scanner.nextDouble();
                    System.out.print("Enter Volume (v): ");
                    double volume = scanner.nextDouble();
                    PhysicsData physicsData = new PhysicsData(mass, 0.0, null, volume);
                    DensityCalculator densityCalculator = new DensityCalculator(physicsData);
                    densityCalculator.calculate();
                    break;
                }
                case 6: {
                    exit = true;
                    System.out.println("Exiting the Scientific Equation Calculator");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        scanner.close();
    }


}
