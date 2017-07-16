package setting;

import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class DBconnect {

	public void process(ServletConfig config)throws ServletException,SQLExcepiton{

		Connection con = DBManager.getConnection();



	}



}
