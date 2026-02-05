
/**
 * Write a description of class Exercise2_Employee here.
 * group six
 *
 * @author (mohd sheha khamis)
 * @version (5 feb 2026)
 */
public class Exercise2_Employee
{
    private String employeeId;
    private String fullName;
    private String department;
    private double basicSalary;
    private int yearsOfService;

    // Constructors
    public Exercise2_Employee() {
        this.employeeId = "Pending";
        this.fullName = "New Employee";
        this.department = "Unassigned";
        this.basicSalary = 500000;
        this.yearsOfService = 0;
    }

    public Exercise2_Employee(String employeeId, String fullName, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        setBasicSalary(basicSalary);
        this.yearsOfService = 0;
    }
     //Getters
    public String getEmployeeId() { return employeeId; }
    public String getFullName() { return fullName; }
    public String getDepartment() { return department; }
    public double getBasicSalary() { return basicSalary; }
    public int getYearsOfService() { return yearsOfService; }
    //Setters 
    public void setBasicSalary(double basicSalary) {
        if (basicSalary >= 500000) {
            this.basicSalary = basicSalary;
        } else {
            System.out.println("Error: Salary can't be below minimum wage (500,000).");
            this.basicSalary = 500000; 
        }
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService >= 0) {
            this.yearsOfService = yearsOfService;
        } else {
            System.out.println("Error: the years of service can't be negative.");
        }
    }

    public double calculateBonus() {
        double bonusPercentage = Math.min(0.50, yearsOfService * 0.10);
        return basicSalary * bonusPercentage;
    }

    public double calculateNetSalary() {
        double grossSalary = basicSalary + calculateBonus();
        double tax = grossSalary * 0.15;
        return grossSalary - tax;
    }

    public void promote(String newDepartment, double salaryIncrease) {
        this.department = newDepartment;
        this.basicSalary += salaryIncrease;
        System.out.println("PROMOTION: " + fullName + " moved to " + newDepartment);
    }

    public void displayPayslip() {
        double bonus = calculateBonus();
        double netSalary = calculateNetSalary();
        
        System.out.println("---------- PAYSLIP ----------");
        System.out.println("ID: " + employeeId + " | Name: " + fullName);
        System.out.println("Dept: " + department + " | Years: " + yearsOfService);
        System.out.println("The basic Salary: " + String.format("%,.2f", basicSalary));
        System.out.println("Bonus:        " + String.format("%,.2f", bonus));
        System.out.println("Tax (15%):   -" + String.format("%,.2f", (basicSalary + bonus) * 0.15));
        System.out.println("the net salary is:   TSh " + String.format("%,.2f", netSalary));
        System.out.println("---------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Employee Payroll Exercise ===\n");
        Exercise2_Employee emp1 = new Exercise2_Employee("EMP001", "Ali Hassan", "IT", 1500000);
        Exercise2_Employee emp2 = new Exercise2_Employee("EMP002", "Fatma Said", "HR", 1200000);
        emp1.setYearsOfService(5);
        emp2.setYearsOfService(2);
        emp1.displayPayslip();
        emp2.displayPayslip();
        emp1.promote("Senior IT", 300000);
        emp1.displayPayslip();
        System.out.println("=== Exercise Complete ===");
    }
}