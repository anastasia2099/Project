package organization;

public class Employee {
    public static String default_position = "engineer";
    public static int default_salary = 30000;

    private String position;
    private int salary;
    private String firstname;
    private String lastname;

    public Employee(String lastname, String firstname) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.setPosition(Employee.default_position);
        this.setSalary(Employee.default_salary);
    }
    public Employee(String position, int salary, String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.salary = salary;

    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static void main (String[] args) {

        Employee employee = new Employee ("Engineer",35000, "Ivan", "Ivanov");
        String firstname = employee.getFirstname();
        System.out.println(firstname);

        employee.setFirstname("Petr");
        String firstname1 = employee.getFirstname();
        System.out.println(firstname1);

        String lastname = employee.getLastname();
        System.out.println(lastname);

        employee.setLastname("Petrov");
        String lastname1 = employee.getLastname();
        System.out.println(lastname1);

        String position = employee.getPosition();
        System.out.println(position);

        employee.setPosition("Logist");
        String position1 = employee.getPosition();
        System.out.println(position1);

        int salary = employee.getSalary();
        System.out.println(salary);

        employee.setSalary(45000);
        int salary1 = employee.getSalary();
        System.out.println(salary1);
    }

}
