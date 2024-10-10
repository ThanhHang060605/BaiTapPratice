package pratice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Emp_PartTime extends Employee {

    private int numberOfworkDays;

    public Emp_PartTime() {
    }

    public Emp_PartTime(int numberOfworkDays, String emplID, String empName, Date empDateOfBirth, Date startDate) {
        super(emplID, empName, empDateOfBirth, startDate);
        this.numberOfworkDays = numberOfworkDays;
    }

    public int getNumberOfworkDays() {
        return numberOfworkDays;
    }

    public void setNumberOfworkDays(int numberOfworkDays) {
        this.numberOfworkDays = numberOfworkDays;
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

            System.out.print("Enter Number Of Work Days: ");
            this.setNumberOfworkDays(sc.nextInt());
            sc.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid!!!");
        }
    }

    @Override
    public void output() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEmp ID: " + getEmplID()
                + "\n Emp Name: " + getEmpName()
                + "\n Emp Date Of Birth: " + sdf.format(getEmpDateOfBirth())
                + "\n Start Date: " + sdf.format(getStartDate())
                + "\n Number of work days: " + numberOfworkDays);

    }

    
    @Override
    public double calculateSalary() {
        return BasicSalary * numberOfworkDays/26 + calculateAllowance();
    }
    
    @Override
    public double calculateAllowance() {
        int seniority = calculateSeniority();
        if(seniority >= 10){
            return 500000;
        }
        else if(seniority <= 10){
            return 300000;
        }
        return 0;
    }

    

    

}

