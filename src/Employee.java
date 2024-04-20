public class Employee {
    private final int id;
    private String name;
    private String department;
    public Employee(int id){
        this.id = id;
    }
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
