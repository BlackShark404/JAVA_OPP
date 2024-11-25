package Interface;
import java.util.HashSet;
import java.util.ArrayList;

public class Interface {
    public static void main(String[] args) {
        // Create the EmployeeManager instance
        EmployeeManager manager = new EmployeeManager();

        // Adding some employees
        PermanentEmployee permanentEmployee = new PermanentEmployee("E001", "Alice", 50000, 5000);
        ContractEmployee contractEmployee = new ContractEmployee("C001", "Bob", 50, 160);
        Freelancer freelancer = new Freelancer("F001", "Charlie", 2000);

        manager.addEmployee(permanentEmployee);
        manager.addEmployee(contractEmployee);
        manager.addEmployee(freelancer);

        // Displaying all employees
        System.out.println("Displaying All Employees:");
        manager.displayAllEmployees();

        // Calculating total payroll
        double totalPayroll = manager.calculateTotalPayroll();
        System.out.println("Total Payroll : " + totalPayroll);

        // Searching for an employee by ID
        System.out.println("\nSearching for Employee with ID C001:");
        Employee searchedEmployee = manager.searchById("C001");
        if (searchedEmployee != null) {
            searchedEmployee.displayDetails();
        } else {
            System.out.println("Employee not found.");
        }
    }
}

interface Employee {
    void displayDetails();
    double calculateSalary();
    boolean validateUniqueId(String id);
}

 class PermanentEmployee implements Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    private double bonus;
    private static final HashSet<String> employeeIdList = new HashSet<String>();

    public PermanentEmployee(String employeeId, String name, double baseSalary, double bonus) {
        setEmployeeId(employeeId);
        setName(name);
        setBaseSalary(baseSalary);
        setBonus(bonus);
    }

    private boolean validateString(String value) {
         return value == null || value.isEmpty();
     }

    public void setEmployeeId(String employeeId) {
        if (validateString(employeeId) || validateUniqueId(employeeId)) {
            System.out.println("Error: Employee ID must not be null or empty and should be unique");
        } else {
            this.employeeId = employeeId;
            employeeIdList.add(employeeId);
        }
    }

    public void setName(String name) {
        if (validateString(name)) {
            System.out.println("Error: Name must not be null or empty");
        } else {
            this.name = name;
        }
    }

     public void setBaseSalary(double baseSalary) {
         if (baseSalary < 0) {
             System.out.println("Error: Base salary cannot be negative value");
         } else {
             this.baseSalary = baseSalary;
         }
     }

     public void setBonus(double bonus) {
         if (bonus < 0) {
             System.out.println("Error: Bonus cannot be negative value");
         } else {
             this.bonus = bonus;
         }
     }

     public String getEmployeeId() {
         return this.employeeId;
     }

     public String getName() {
         return this.name;
     }

     public double getBaseSalary() {
         return this.baseSalary;
     }

     public double getBonus() {
         return this.bonus;
     }

     @Override
     public void displayDetails() {
         System.out.printf("Employee ID   : %s\n", employeeId);
         System.out.printf("Name          : %s\n", name);
         System.out.printf("Base salary   : %,.2f\n", baseSalary);
         System.out.printf("Bonus         : %,.2f\n\n", bonus);
    }

    @Override
     public double calculateSalary() {
        return baseSalary + bonus;
    }

     @Override
     public boolean validateUniqueId(String id) {
         return (employeeIdList.contains(id));
     }
 }

 class ContractEmployee implements Employee {
     private String employeeId;
     private String name;
     private double hourlyRate;
     private int hoursWorked;
     private static final HashSet<String> employeeIdList = new HashSet<String>();

     public ContractEmployee(String employeeId, String name, double hourlyRate, int hoursWorked) {
         setEmployeeId(employeeId);
         setName(name);
         setHourlyRate(hourlyRate);
         setHoursWorked(hoursWorked);
     }

     private boolean validateString(String value) {
         return value == null || value.isEmpty();
     }

     public void setEmployeeId(String employeeId) {
         if (validateString(employeeId) || validateUniqueId(employeeId)) {
             System.out.println("Error: Employee ID must not be null or empty and should be unique");
         } else {
             this.employeeId = employeeId;
             employeeIdList.add(employeeId);
         }
     }

     public void setName(String name) {
         if (validateString(name)) {
             System.out.println("Error: Name must not be null or empty");
         } else {
             this.name = name;
         }
     }

     public void setHourlyRate(double hourlyRate) {
         if (hourlyRate < 0) {
             System.out.println("Error: Hourly rate cannot be negative value");
         } else {
             this.hourlyRate = hourlyRate;
         }
     }

     public void setHoursWorked(int hoursWorked) {
         if (hoursWorked < 0) {
             System.out.println("Error: Hours worked cannot be negative value");
         } else {
             this.hoursWorked = hoursWorked;
         }
     }

     public String getEmployeeId() {
         return this.employeeId;
     }

     public String getName() {
         return this.name;
     }

     public double getHourlyRate() {
         return this.hourlyRate;
     }

     public double getHoursWorked() {
         return this.hoursWorked;
     }

     @Override
     public void displayDetails() {
         System.out.printf("Employee ID   : %s\n", employeeId);
         System.out.printf("Name          : %s\n", name);
         System.out.printf("Hourly rate   : %,.2f\n", hourlyRate);
         System.out.printf("Hours worked  : %d\n\n", hoursWorked);
     }

     @Override
     public double calculateSalary() {
         return hourlyRate * hoursWorked;
     }

     @Override
     public boolean validateUniqueId(String id) {
         return (employeeIdList.contains(id));
     }
 }

 class Freelancer implements Employee {
    private String freelancerId;
    private String projectName;
    private double projectRate;
     private static final HashSet<String> freelancerIdList = new HashSet<String>();

    public Freelancer(String freelancerId, String projectName, double projectRate) {
         setFreelancerId(freelancerId);
         setProjectName(projectName);
         setProjectRate(projectRate);
     }

     private boolean validateString(String value) {
         return value == null || value.isEmpty();
     }

     public void setFreelancerId(String freelancerId) {
         if (validateString(freelancerId) || validateUniqueId(freelancerId)) {
             System.out.println("Error: Freelancer ID must not be null or empty and should be unique");
         } else {
             this.freelancerId = freelancerId;
             freelancerIdList.add(freelancerId);
         }
     }

     public void setProjectName(String projectName) {
         if (validateString(projectName)) {
             System.out.println("Error: Project name must not be null or empty");
         } else {
             this.projectName = projectName;
         }
     }

     public void setProjectRate(double projectRate) {
         if (projectRate < 0) {
             System.out.println("Error: Project rate cannot be negative value");
         } else {
             this.projectRate = projectRate;
         }
     }

     public String getFreelancerId() {
         return this.freelancerId;
     }

     public String getProjectName() {
         return this.projectName;
     }

     public double getProjectRate() {
         return this.projectRate;
     }

     @Override
     public void displayDetails() {
         System.out.printf("Freelancer ID : %s\n", freelancerId);
         System.out.printf("Project name  : %s\n", projectName);
         System.out.printf("Project rate  : %,.2f\n\n", projectRate);
     }

     @Override
     public double calculateSalary() {
         return projectRate;
     }

     @Override
     public boolean validateUniqueId(String id) {
         return (freelancerIdList.contains(id));
     }
 }

class EmployeeManager {
    // A collection to hold all employees (Permanent, Contract, and Freelancers)
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    // Method to add an employee to the collection
    public void addEmployee(Employee employee) {
        // Check if the employee ID or freelancer ID is unique before adding
        if (employee instanceof PermanentEmployee) {
            PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
            // Check if the ID is already used by any employee
            if (isEmployeeIdExist(permanentEmployee.getEmployeeId())) {
                System.out.println("Error: Employee ID " + permanentEmployee.getEmployeeId() + " is already in use.");
            } else {
                employees.add(employee);
            }
        }

        if (employee instanceof ContractEmployee) {
            ContractEmployee contractEmployee = (ContractEmployee) employee;
            // Check if the ID is already used by any employee
            if (isEmployeeIdExist(contractEmployee.getEmployeeId())) {
                System.out.println("Error: Employee ID " + contractEmployee.getEmployeeId() + " is already in use.");
            } else {
                employees.add(employee);
            }
        }

        if (employee instanceof Freelancer) {
            Freelancer freelancer = (Freelancer) employee;
            // Check if the ID is already used by any freelancer
            if (isFreelancerIdExist(freelancer.getFreelancerId())) {
                System.out.println("Error: Freelancer ID " + freelancer.getFreelancerId() + " is already in use.");
            } else {
                employees.add(employee);
            }
        }
    }

    // Method to check if the employee ID exists in the manager's list
    private boolean isEmployeeIdExist(String id) {
        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                if (((PermanentEmployee) employee).getEmployeeId().equals(id)) {
                    return true;
                }
            } else if (employee instanceof ContractEmployee) {
                if (((ContractEmployee) employee).getEmployeeId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to check if the freelancer ID exists in the manager's list
    private boolean isFreelancerIdExist(String id) {
        for (Employee employee : employees) {
            if (employee instanceof Freelancer) {
                if (((Freelancer) employee).getFreelancerId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to display details of all employees
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employees) {
                employee.displayDetails();
            }
        }
    }

    // Method to calculate the total payroll
    public double calculateTotalPayroll() {
        double totalPayroll = 0.0;
        for (Employee employee : employees) {
            totalPayroll += employee.calculateSalary();
        }
        return totalPayroll;
    }

    // Method to search for an employee by their unique ID
    public Employee searchById(String id) {
        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                if (((PermanentEmployee) employee).getEmployeeId().equals(id)) {
                    return employee;
                }
            } else if (employee instanceof ContractEmployee) {
                if (((ContractEmployee) employee).getEmployeeId().equals(id)) {
                    return employee;
                }
            } else if (employee instanceof Freelancer) {
                if (((Freelancer) employee).getFreelancerId().equals(id)) {
                    return employee;
                }
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return null;
    }
}