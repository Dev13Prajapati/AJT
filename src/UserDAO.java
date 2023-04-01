import java.sql.*;

// Data Access Object (DAO)
public class UserDAO {

    void addUser(User user, Connection conn) {
        try {
            String query = "insert into user(name,mail,mono,hno,soc,city) values (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, user.name);
            pst.setString(2, user.email);
            pst.setLong(3, user.mono);
            pst.setString(4, user.hno);
            pst.setString(5, user.soc);
            pst.setString(6, user.city);
            pst.executeUpdate();
            pst.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void showAllData(ResultSet rs) {
        try {
            System.out.println("\nid" + "\t" + "name" + "\t" + "email" + "\t" + "mobile" + "\t" + "house no" + "\t" + "society" + "\t" + "city");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("mail");
                String mono = rs.getString("mono");
                String hno = rs.getString("hno");
                String soc = rs.getString("soc");
                String city = rs.getString("city");
                System.out.println(id + "\t" + name + "\t" + email + "\t" + mono + "\t" + hno + "\t" + soc + "\t" + city);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}