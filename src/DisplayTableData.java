import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayTableData {
	
	private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String user = "root";
	private static final String pass = "ROOT";

	public static void main(String[] args) {
		try(Connection dbConn = DriverManager.getConnection(url, user, pass);
				Statement dbStmt = dbConn.createStatement()) {
			ResultSet resultset = dbStmt.executeQuery("SELECT * FROM employee");
			
			ResultSetMetaData metadata = resultset.getMetaData();
			int columnCount = metadata.getColumnCount();
			
			//print column names
			for(int i = 1; i <= columnCount; i++) {
				System.out.println(metadata.getColumnName(i));
				System.out.println(metadata.getColumnTypeName(i));
			}
			while(resultset.next()) {
				for(int i = 1; i < columnCount; i ++) {
					System.out.println(resultset.getString(i) + "\t");
				}
			}
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

}
