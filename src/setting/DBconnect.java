package setting;

import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class DBconnect {

	public void process(ServletConfig config)throws ServletException,SQLExcepiton{

		String sql = "SELECT * from p_user";

		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			ResuleSet rs = smt.executeQuery(sql);
		}



	}



}
