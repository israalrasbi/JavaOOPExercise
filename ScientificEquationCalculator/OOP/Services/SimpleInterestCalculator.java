package OOP.Services;

import OOP.Entities.InterestData;
import OOP.Interface.CalculatorInterface;

import java.util.Scanner;

public class SimpleInterestCalculator implements CalculatorInterface {
    //this class will use InterestData
    private InterestData interestData;

    public SimpleInterestCalculator(InterestData interestData) {
        this.interestData = interestData;
    }

    public double calculateSimpleInterest() {
        double P = interestData.getPrincipal();
        double R = interestData.getRate();
        double T = interestData.getTime();
        return (P * R * T) / 100;
    }

    public double calculateCompoundInterest() {
        double P = interestData.getPrincipal();
        double R = interestData.getRate();
        double T = interestData.getTime();
        return P * Math.pow((1 + R / 100), T) - P;
    }

    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Simple Interest Calculator Menu ---");
            System.out.println("1. Calculate Simple Interest (SI = P × R × T ÷ 100)");
            System.out.println("2. Calculate Compound Interest (CI = P × (1 + R ÷ 100)^T - P)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Simple Interest: " + calculateSimpleInterest());
                    break;
                case 2:
                    System.out.println("Compound Interest: " + calculateCompoundInterest());
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting Simple Interest Calculator.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
