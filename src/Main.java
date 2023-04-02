import java.sql.*;
import java.util.Scanner;

public class Main {

//    TODO: Delete functionality and View Account

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/jdbcadvjava", "root","vatsalspatel007"
            );

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from serviceman");

            int i = 1;
            while (i<100) {
                System.out.println("Press 1 to REGISTER");
                System.out.println("Press 2 to FIND SERVICE-MAN");
                System.out.println("Press 3 to VIEW THE USER AND SERVICE-MAN DATABASE");
                System.out.println("Press 4 to EXIT");
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Press 1 to register as a User");
                        System.out.println("Press 2 to register as a Service-man");
                        System.out.print("Enter Choice: ");
                        int c= sc.nextInt();
                        if (c==1){
                            UserDAO userDAO = new UserDAO();
                            User user = new User();
                            user.setDetails();
                            userDAO.addUser(user, conn);
                        } else if (c==2) {
                            ServicemanDAO servicemanDAO = new ServicemanDAO();
                            Serviceman serviceman = new Serviceman();
                            serviceman.setDetails();
                            servicemanDAO.addUser(serviceman, conn);
                        }
                        break;
                    case 2:
                        System.out.println("These are the Services We are Provide");
                        System.out.println("Press 1 for Plumber");
                        System.out.println("Press 2 for Electrician");
                        System.out.println("Press 3 for Carpenter");
                        System.out.println("Press 4 for Mason-Work");
                        System.out.println("Press 5 for Maid");
                        System.out.println("Press 6 for Milk-Man");
                        int ch = sc.nextInt();
                        ServicemanDAO.bookService(ch, conn);
                        break;
                    case 3:
                        UserDAO.showAllData(rs);
//                        rs = st.executeQuery("select * from serviceman");
//                        ServicemanDAO.showAllData(rs);
                        break;
                    case 4:
                        rs = st.executeQuery("select count(*) from user");
                        rs.next();
                        int visit = rs.getInt(1);
                        System.out.println("\n" + visit + " Visitors Shows Their Trust and Support");
                        rs = st.executeQuery("select count(*) from serviceman");
                        rs.next();
                        int sVisit = rs.getInt(1);
                        System.out.println(sVisit + " Service-Men Shows Their Trust and Support\nLove You All 3000💖!\n");
                        System.out.println("**** THANKS ***\n! VISIT AGAIN !");
                        st.close();
                        conn.close();
                        rs.close();
                        System.exit(0);
                    default:
                        System.out.println("\nWRONG INPUT!\nPLEASE CHOOSE AGAIN.\n");
                        break;
                }
            };
            st.close();
            conn.close();
        }
        catch (Exception e) { // Handled SQLException,ClassNotFoundException particularly
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}

/* STEPS FOR JDBC
 1. import java.sql.*;
 2. load and Register Driver
   a) JDBC-ODBC bridge driver (not used above Java-8)
   b) Native-API driver
   c) Network Protocol driver
   d) Thin driver
 3. create a Connection
   a) Connection is an interface
   b) to make Object of Connection you have to use DriverManager.getConnection()
   c) getConnection() is static method
 4. create a Statement
   a) Statement // SQL statement with no parameters
   b) PreparedStatement // precompiled SQL statement input parameters
   c) CallableStatement // use to execute stored procedure like PLSQL
 5. execute the Query
 6. process the results
 7. close the resources
*/