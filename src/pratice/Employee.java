
package pratice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

    
abstract class Employee implements IEmployee{
    private String emplID;
    private String empName;
    private Date empDateOfBirth;
    private Date startDate;

    public Employee() {
    }

    public Employee(String emplID, String empName, Date empDateOfBirth, Date startDate) {
        this.emplID = emplID;
        this.empName = empName;
        this.empDateOfBirth = empDateOfBirth;
        this.startDate = startDate;
    }

    
    public String getEmplID() {
        return emplID;
    }

    public void setEmplID(String emplID) {
        this.emplID = emplID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getEmpDateOfBirth() {
        return empDateOfBirth;
    }

    public void setEmpDateOfBirth(Date empDateOfBirth) {
        this.empDateOfBirth = empDateOfBirth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void input(){
        
    }
    public void output(){
        
    }

    public int calculateSeniority(){
       return (int) ChronoUnit.YEARS.between((Temporal) startDate, LocalDate.now());
   }

    
    
    
}
