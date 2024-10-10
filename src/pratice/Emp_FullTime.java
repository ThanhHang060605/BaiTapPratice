package pratice;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Emp_FullTime extends Employee {

    private double coefficientsSalary;

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public Emp_FullTime() {
    }

    public Emp_FullTime(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public void input() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Emp ID: ");
            this.setEmplID(sc.nextLine());

            System.out.print("Enter Emp Name: ");
            this.setEmpName(sc.nextLine());

            System.out.print("Enter Emp Date Of Birth(dd/MM/yyyy): ");
            String date = sc.nextLine();
            this.setEmpDateOfBirth(sdf.parse(date));

            System.out.print("Enter Start Day(dd/MM/yyyy): ");
            String date2 = sc.nextLine();
            this.setEmpDateOfBirth(sdf.parse(date2));

            System.out.print("Enter Coefficients Salary: ");
            this.setCoefficientsSalary(sc.nextDouble());
            sc.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid!!!!");
        }

    }

    public void output() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEmp ID: " + getEmplID()
                + "\n Emp Name: " + getEmpName()
                + "\n Emp Date Of Birth: " + sdf.format(getEmpDateOfBirth())
                + "\n Start Date: " + sdf.format(getStartDate())
                + "\n Coefficents Salry: " + coefficientsSalary);

    }

    @Override
    public double calculateSalary() {
        return BasicSalary * coefficientsSalary + calculateAllowance();
    }

    
        @Override
    public double calculateAllowance() {
        int seniority = calculateSeniority();
        if(seniority >= 10){
            return 1000000;
        }
        else if(seniority <= 5){
            return 500000;
        }
        return 0;
    }

    
    
    
    
    

}
