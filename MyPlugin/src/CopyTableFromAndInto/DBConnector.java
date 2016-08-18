package CopyTableFromAndInto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * 两个连接，分别连接两个数据库，用于跨服务器拷贝表
 * @author Mirah
 *
 */
public class DBConnector {
	
	private static final String NAME = "com.mysql.jdbc.Driver";
	
	/*
	 * 被读取数据的数据库连接属性
	 */
	private static final String URL_From = "jdbc:mysql://127.0.0.1:3306/mcb?characterEncoding=utf8";
	private static final String USER_From = "root";
	private static final String PASSWORD_From = "mcb2016";
	
	
	/*
	 * 同步数据终点数据库的连接属性
	 */
	private static final String URL_Into = "jdbc:mysql://115.28.176.216:3306/mcbpaas?characterEncoding=utf8";
	private static final String USER_Into = "mcb";
	private static final String PASSWORD_Into = "mcb2016";
	
	private Connection conn = null;
	public static PreparedStatement pst = null;
	
	/**
	 * 连接数据库 mcb 
	 * @param sql
	 */
	public void exeConnectionMcb(String sql){
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL_From,USER_From,PASSWORD_From);
			pst = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接数据库mcbapp
	 * @param sql
	 */
	public void exeConnectionMcbapp(String sql){
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL_Into,USER_Into,PASSWORD_Into);
			pst  = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接
	 */
	public void close(){
		try {
			this.pst.close();
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
