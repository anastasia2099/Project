package organization;

import java.util.Arrays;
import java.util.Comparator;

public class Department {
    private String name;
    private Employee[] employees;

    public Department(String name) {
        this.name = name;
        this.employees = new Employee[0];
    }

    public Department(Employee[] employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeesCount() {
        return this.employees.length;
    }

    public void addNewEmployee(Employee newEmployee) {
        Employee[] newEmploees = new Employee[this.employees.length + 1];
        System.arraycopy(this.employees, 0, newEmploees, 0, this.employees.length);
        newEmploees[this.employees.length] = newEmployee;
        this.employees = newEmploees;

    }

    public Employee getEmployeeName(String lastname, String firstname) {
        for (Employee employee : this.employees) {
            if (employee.getLastname().equals(lastname) && employee.getFirstname().equals(firstname)) {
                return employee;

            }

        }
        return null;
    }
    public int getSummSalary() {
        int summa = 0;
        for (Employee employee : this.employees) {
            summa += employee.getSalary();
        }
        return summa;
    }

    public void deleteEmployee(String lastName, String firstName, String position) {
        for (int removedIdx = 0; removedIdx < this.employees.length; removedIdx++) {
            Employee employee = this.employees[removedIdx];
            if (employee.getFirstname().equals(firstName) && employee.getLastname().equals(lastName)
                    && employee.getPosition().equals(position)) {

                Employee[] newEmployees = new Employee[this.employees.length - 1];
                System.arraycopy(this.employees, 0, newEmployees, 0, removedIdx);
                if (this.employees.length != removedIdx) {
                    System.arraycopy(this.employees, removedIdx + 1, newEmployees, removedIdx,
                            this.employees.length - removedIdx - 1);
                }
                this.employees = newEmployees;

                return;
            }
        }
    }

    public Employee[] getEmployees(){
        Employee[] massivEmploees = new Employee[this.employees.length];
        System.arraycopy(this.employees, 0, massivEmploees, 0, this.employees.length);
        return massivEmploees;
    }

    public Employee[] getEmployeesSortingbyName(){
        Employee[] sortEmploees = this.getEmployees();
        Arrays.sort(sortEmploees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getFirstname().equals(o2.getFirstname())) {
                    return o1.getFirstname().compareTo(o2.getFirstname());
                }
                return o1.getLastname().compareTo(o2.getLastname());
            }
        });
        return sortEmploees;
        }




        public static void main (String[] args) {
            Department department = new Department("QA department");
            Employee manualQA = new Employee("Manual Engineer", 5000, "Anastasia", "Pinchuk");
            department.addNewEmployee(manualQA);
            Employee automationQA = new Employee("Automation Engineer", 7000, "Ivan", "Mikhailov");
            department.addNewEmployee(automationQA);
            Employee teamLeadQA = new Employee("Team Lead", 15000, "Nikolay", "Ivanov");
            department.deleteEmployee("Pinchuk", "Anastasia", "Manual Engineer");

        }
    }

