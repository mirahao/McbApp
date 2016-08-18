package CopyTableFromAndInto;


import java.util.Date;

/**
 * center_shop_online_tongji
 * 数据库表每条数据对象实体
 * @author Mirah
 *
 */
public class Statistics {
	
	private String id;
	private int shop_id;
	private String shop_name;
	private Date create_date;
	private int online_time_length;
	private int opentable_nums;
	private int opentable_rate;
	private int all_people;
	private double all_money;
	private double perpeople_money;
	private int last_update_time;
	private String online_time_string;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getOnline_time_length() {
		return online_time_length;
	}
	public void setOnline_time_length(int online_time_length) {
		this.online_time_length = online_time_length;
	}
	public int getOpentable_nums() {
		return opentable_nums;
	}
	public void setOpentable_nums(int opentable_nums) {
		this.opentable_nums = opentable_nums;
	}
	public int getOpentable_rate() {
		return opentable_rate;
	}
	public void setOpentable_rate(int opentable_rate) {
		this.opentable_rate = opentable_rate;
	}
	public int getAll_people() {
		return all_people;
	}
	public void setAll_people(int all_people) {
		this.all_people = all_people;
	}
	public double getAll_money() {
		return all_money;
	}
	public void setAll_money(double all_money) {
		this.all_money = all_money;
	}
	public double getPerpeople_money() {
		return perpeople_money;
	}
	public void setPerpeople_money(double perpeople_money) {
		this.perpeople_money = perpeople_money;
	}
	public int getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(int last_update_time) {
		this.last_update_time = last_update_time;
	}
	public String getOnline_time_string() {
		return online_time_string;
	}
	public void setOnline_time_string(String online_time_string) {
		this.online_time_string = online_time_string;
	}
	
}
