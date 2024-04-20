        import java.sql.*;
        import java.util.Scanner;

        public class DatabaseUtil {

            private final int option;
            private final Connection con;
            public DatabaseUtil(int option, Connection con) {
                this.option = option;
                this.con = con;
            }

            public void performCRUD() throws SQLException {
                Scanner sc = new Scanner(System.in);

                if(this.option == 1){
                    //add employee details
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = sc.nextLine();

                    Employee emp = new Employee(id, name, department);

                    String sql = "insert into employeedetailstable values(?,?,?)";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, emp.getId());
                    st.setString(2, emp.getName());
                    st.setString(3, emp.getDepartment());
                    st.execute();
                    con.close();
                } else if (this.option ==2){
                    String sql = "select * from employeedetailstable";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    System.out.println("ID     | Name         | Department\n" +
                            "----------------------------------");
                    while(rs.next()){
                        System.out.println(rs.getInt(1)+"    | "+rs.getString(2)+"     | "+rs.getString(3));
                    }
                } else if (this.option == 3) {
                    System.out.print("Enter employee ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name for employee: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new department for employee: ");
                    String department = sc.nextLine();
                    Employee emp = new Employee(id, name, department);
                    String sql = "update employeedetailstable set name = ?, dept = ? where id = ?";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, emp.getName());
                    st.setString(2, emp.getDepartment());
                    st.setInt(3, emp.getId());
                    st.execute();
                    con.close();

                    System.out.print("Employee updated successfully.");
                } else if (this.option == 4) {
                    System.out.print("Enter employee ID to delete: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Employee emp = new Employee(id);
                    String sql = "delete from employeedetailstable where id = ?";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, emp.getId());
                    st.execute();
                    con.close();
                    System.out.println("Employee deleted successfully.");
                } else if(this.option == 5){
                    sc.close();
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    System.exit(0);
                }

            }
        }
