package CopyTableFromAndInto;


/**
 * 每10分钟进行一次跨服务器同步数据库表数据
 * @author Mirah
 *
 */
public class AlwaysRun extends Thread{
	public CopyAndUpdateTableInto ct = new CopyAndUpdateTableInto();
	
	public void run() {
		while(true){
			try {
				ct.moveTable();
				//每10分钟  将表拷贝一次
				sleep(600000);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}