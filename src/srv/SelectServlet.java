package srv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.eclipse.jdt.internal.compiler.ast.Statement;

import setting.DBManager;

public class SelectServlet extends HttpServlet{


	public void doGet(HttpServletRequest req , HttpServletResponce res)throws ServletException,IOException{
		PrintWriter out = responce.getWriter();

		String sql = setting.SQLSource.getSQL(4,"p_user");

		Connection con = null;
		Statement smt = null;

		try {
			con = DBManager.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()){
				out.println("ID=" + re.getInt("Id"));

			}

		}catch(SQLException e){
			throw new ServletException(e);

		}finally{
			if(smt != null){
				try {
					smt.close();
				}catch(SQLException ignore){

				}
			}
			if(con != null){
				try {
					con.close();
				}catch(SQLException ignore){

				}
			}
		}



	}

}
