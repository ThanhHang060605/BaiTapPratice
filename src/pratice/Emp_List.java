package pratice;

import java.util.ArrayList;
import java.util.Scanner;

public class Emp_List {

    public ArrayList<Employee> employeeList = new ArrayList<>();

    public Emp_List() {
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addNew(Employee employee) {
        employeeList.add(employee);
    }

    public void update(String emplID) {
        for (Employee employee : employeeList) {
            if (employee instanceof Emp_FullTime && employee.getEmplID().equals(emplID)) {
                Emp_FullTime updateEmp = (Emp_FullTime) employee;
                employee.input();
                return;
            } else if (employee instanceof Emp_PartTime) {
                Emp_PartTime updateEmp2 = (Emp_PartTime) employee;
                employee.input();
                return;
            }

        }
    }

    public Employee findEmpByid(String empID) {
        if (employeeList.isEmpty()) {
            System.out.println("No Employee in list");
        } else {
            for (Employee employee : employeeList) {
                if (employee.getEmplID().equals(empID)) {
                    return employee;
                }
            }
        }
        return null;
    }

    public void delete(String empID) {
        for (Employee employee : employeeList) {
            if (employee.getEmplID().equals(empID)) {
                employeeList.remove(employee);
            }
        }
    }

    public void displayAllEmplyee() {
        if (employeeList.isEmpty()) {
            System.out.println("No employee in list");
        } else {
            for (Employee employee : employeeList) {
                employee.output();

            }
        }
    }
    
    //public void

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n**Choice an option**"
                    + "\n1. Add New Employee"
                    + "\n2. Update Employee By ID"
                    + "\n3. Find Employee By ID"
                    + "\n4. Delete Employee By ID"
                    + "\n5. Display All Employees"
                    + "\n6. Exit"
                    + "\n ------Enter number------"
            );

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("-----Add new Employee----");
                    System.out.println("1. Add new full time"
                            + "\n2. Add new part time");
                    System.out.print("Choose type: ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    Employee employee;

                    if (type == 1) {
                        employee = new Emp_FullTime();
                    } else {
                        employee = new Emp_PartTime();
                    }

                    employee.input();
                    addNew(employee);
                    break;
                case 2:
                    System.out.println("-----Update Employee By ID------");
                    System.out.print("Enter ID to Update: ");
                    String idToUpdate = sc.nextLine();
                    update(idToUpdate);
                    break;
                case 3:
                    System.out.println("----Find Employee By ID------");
                    System.out.print("Enter ID to Find: ");
                    String idToFind = sc.nextLine();
                    Employee findEmployee = findEmpByid(idToFind);
                    if (findEmployee != null) {
                        findEmployee.output();
                    }
                    break;

                case 4:
                    System.out.println("----Delete Employee-----");
                    System.out.print("Enter ID to delete: ");
                    String idToDelete = sc.nextLine();
                    delete(idToDelete);
                    System.out.println("Employee To Delete sucessfully");
                    break;
                case 5:
                    System.out.println("----Display all employees----");
                    displayAllEmplyee();
                    break;
                case 6:
                    run = false;
                    System.out.println("The end programming!!!");
                    break;

                default:
                    System.out.println("Invalid!!!");
            }

        }
    }
}
