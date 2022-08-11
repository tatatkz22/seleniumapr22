package mainPackge;


import java.sql.*;

public class jtdsDbConnection {
    public jtdsDbConnection() throws NoSuchFieldException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://DESKTOP-76D6SR8/AdventureWorks2019;integratedSecurity=true;authenticationScheme=JavaKerberos;encrypt=true;trustedServerCertificate=true;");
        Statement st = conn.createStatement();
        String Sql = "SELECT TOP (4) FirstName,LastName FROM AdventureWorks2019.Person.Person";
        ResultSet rs = st.executeQuery(Sql);

        /*ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        // Iterate through the data in the result set and display it.

        while (rs.next()) {
        //Print one row
            for(int i = 1 ; i <= columnsNumber; i++){

                System.out.print(rs.getString(i) + " ");

            }

            System.out.println();//Move to the next line to print the next row.

        }
    }
*/

    }
}

