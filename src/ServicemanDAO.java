import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServicemanDAO {
    static void bookService(int ch, Connection conn) throws Exception{
        ResultSet rs;
        String query = "select * from serviceman where occupation=?";
        PreparedStatement pst = conn.prepareStatement(query);
        switch (ch) {
            case 1 -> {
                pst.setString(1, "Plumber");
                rs = pst.executeQuery();
                ServicemanDAO.showAllData(rs);
                pst.close();
                rs.close();
            }
            case 2 -> {
                pst.setString(1, "Bhasan");
                rs = pst.executeQuery();
                ServicemanDAO.showAllData(rs);
                pst.close();
                rs.close();
            }
        }
    }

    void addUser(Serviceman serviceman, Connection conn) {
        try {
            String query = "insert into serviceman(name,occupation,mono,area,city,visitcharge) values (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, serviceman.name);
            pst.setString(2, serviceman.occupation);
            pst.setLong(3, serviceman.mono);
            pst.setString(4, serviceman.area);
            pst.setString(5, serviceman.city);
            pst.setInt(6, serviceman.visitCharge);
            pst.executeUpdate();
            pst.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void showAllData(ResultSet rs) {
        try {
            System.out.println("\nid" + "\t" + "name" + "\t" + "mobile" + "\t" + "occupation" + "\t" + "area" + "\t\t" + "city" + "\t" + "visitCharge");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String mono = rs.getString("mono");
                String occupation = rs.getString("occupation");
                String area = rs.getString("area");
                String city = rs.getString("city");
                String visitCharge = rs.getString("visitcharge");
                System.out.println(id + "\t" + name + "\t" + mono + "\t" + occupation + "\t" + area + "\t" + city + "\t" + visitCharge);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
