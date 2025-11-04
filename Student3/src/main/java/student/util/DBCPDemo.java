package student.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPDemo {
		private static DataSource dbcp = null;
		static {
			try {
				dbcp = BasicDataSourceFactory.createDataSource(getProperties());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static DataSource getDataSource() {
			return dbcp;
		}
		public static Connection getConnection() throws SQLException {
			return dbcp.getConnection();
		}
		private static Properties getProperties() throws IOException {
			Properties props = new Properties();
			InputStream input = new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
			props.load(input);
			return props;
		}
		public static void release(Connection conn,Statement st, ResultSet rs) {
			closeRs(rs);
			closeSt(st);
			closeConn(conn);
			
		}
		public static void release(Connection conn,Statement st) {
			closeSt(st);
			closeConn(conn);
		}
		private static void closeConn(Connection conn) {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		private static void closeSt(Statement st) {
				if(st!=null) {
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		private static void closeRs(ResultSet rs) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
