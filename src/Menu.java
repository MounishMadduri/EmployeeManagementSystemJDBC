import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Connection con;

    public Menu(Connection con) {
        this.con = con;
    }

    public void displayMenu() throws SQLException {
        System.out.println(" Welcome to the Employee Management System ");
        System.out.println("""
                1. Add Employee
                2. View All Employees
                3. Update Employee
                4. Delete Employee
                5. Exit""");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        int input = sc.nextInt();
        sc.nextLine();
        DatabaseUtil jdbc = new DatabaseUtil(input, this.con);
        jdbc.performCRUD();

    }
}
