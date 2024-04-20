import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // initialise the JDBC connection
        String url = "jdbc:postgresql://localhost:5432/demo1";
        String user = "postgres";
        String password = "Gprec$123";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("connection established");
        Menu menu = new Menu(con);
        menu.displayMenu();
        System.out.println("connection ended!");
        }
    }
