package srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBDate;
import setting.DBManager;

/**
 * Servlet implementation class SServlet
 */
@WebServlet("/SServlet")
public class SServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		// String sql = setting.SQLSource.getSQL(4, "p_user");
		String sql = "SELECT * FROM p_user";

		Connection con = null;
		Statement smt = null;

		try {
			con = DBManager.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			List<DBDate> list = new ArrayList<DBDate>();

			while (rs.next()) {
				out.println("ID=" + rs.getInt("Id"));

				DBDate url = new DBDate();
				url.setId(rs.getInt("Id"));
				url.setURL(rs.getString("url"));
				url.setName(rs.getString("name"));

				list.add(url);
				System.out.println("call SQL");
			}

			req.setAttribute("url", list);

		} catch (SQLException e) {
			throw new ServletException(e);

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			// DBとの切断処理
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {

				}
			}
		}

		req.getRequestDispatcher("/show.jsp").forward(req, res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
