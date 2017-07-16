package srv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest req,HttpServletResponce res)throws ServletException , IOException{
    	//ページの表示
    	String sql = setting.SQLSource.getSQL(1);
    }

}

