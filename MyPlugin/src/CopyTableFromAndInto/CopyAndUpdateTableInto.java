package CopyTableFromAndInto;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 创建两个JDBC，分别连接两个不同服务器的数据库，
 * 			将一个服务器数据库中的一个表拷贝到另一个服务器数据库的表中（要求表结构相同）
 * @author Mirah
 *
 */
public class CopyAndUpdateTableInto{
	
	//从192.168.120.172服务器mcb数据库center_shop_online_tongji表中读取数据
	private static String  SQL = " select * from center_shop_online_tongji ";
	
	
	//将读取的数据传入192.168.120.31服务器mcbapp数据库center_shop_online_tongji表中
	private static String  SQLInput = "replace into center_shop_online_tongji"
			+ "(id,shop_id,shop_name,create_date,online_time_length,opentable_nums,"
			+ "opentable_rate,all_people,all_money,perpeople_money,last_update_time,online_time_string)" 
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	//被读取的数据库的连接对象
	private DBConnector dbc_from= new DBConnector();
	//被写入的数据库的连接对象
	private DBConnector dbc_into= new DBConnector();
	//存放临时数据实体对象的集合
	private List<Statistics> tempData = new ArrayList();
	
	private ResultSet ret = null;
	
	public void  moveTable(){
		dbc_from.exeConnectionMcb(SQL);
		try {
			ret = dbc_from.pst.executeQuery(); 
			while(ret.next()){
				//每一条数据条目对象
				Statistics statistics = new Statistics();
				//将查询出来的数据注入数据条目对象中
				statistics.setId(ret.getString("id"));
				statistics.setAll_money(ret.getDouble("all_money"));
				statistics.setAll_people(ret.getInt("all_people"));
				statistics.setLast_update_time(ret.getInt("last_update_time"));
				statistics.setOnline_time_length(ret.getInt("online_time_length"));
				statistics.setOnline_time_string(ret.getString("online_time_string"));
				statistics.setOpentable_nums(ret.getInt("opentable_nums"));
				statistics.setPerpeople_money(ret.getDouble("perpeople_money"));
				statistics.setShop_id(ret.getInt("shop_id"));
				statistics.setShop_name(ret.getString("shop_name"));
				statistics.setCreate_date(ret.getDate("create_date"));
				statistics.setOpentable_rate(ret.getInt("opentable_rate"));
//				System.out.println(statistics.getAll_money()+","+statistics.getId());
				tempData.add(statistics);
				System.out.println("将查询出来的一条数据放入statistics对象集合中");
			}
			System.out.println(tempData.size());
			if( !ret.next() ){
				dbc_from.close();
				dbc_into.exeConnectionMcbapp(SQLInput);
				for(Statistics st : tempData){
					dbc_into.pst.setString(1,st.getId());
					System.out.println(st.getId());
					dbc_into.pst.setInt(2,st.getShop_id());
					dbc_into.pst.setString(3,st.getShop_name());
					dbc_into.pst.setDate(4, (Date) st.getCreate_date());
					dbc_into.pst.setInt(5,st.getOnline_time_length());
					dbc_into.pst.setInt(6, st.getOpentable_nums());
					dbc_into.pst.setInt(7, st.getOpentable_rate());
					dbc_into.pst.setInt(8,st.getAll_people());
					System.out.println(st.getAll_people());
					dbc_into.pst.setDouble(9,st.getAll_money());
					dbc_into.pst.setDouble(10,st.getPerpeople_money());
					dbc_into.pst.setInt(11,st.getLast_update_time());
					dbc_into.pst.setString(12,st.getOnline_time_string());
					dbc_into.pst.execute();
					System.out.println("将一条数据转移");
				}
				dbc_into.close();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 执行跨服务器同步数据库表内容
	 */
	public void exeUpdateInfoList(){
		AlwaysRun ar = new AlwaysRun();
		ar.start();
	}
	
	/*
	 * main方法测试
	 */
	public static void main(String[] args) {
		CopyAndUpdateTableInto ct = new CopyAndUpdateTableInto();
		ct.exeUpdateInfoList();
	}
	
}
