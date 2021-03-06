package setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.Statement;

public class DBManager {

	/**
	 * DB接続用ドライバの登録
	 */
	/** ドライバクラス名 */
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	/** 接続するDBのURL */
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	/** DB接続するためのユーザー名 */
	private static final String USER_NAME = "db_user";
	/** DB接続するためのパスワード */
	private static final String PASSWORD = "systemsss";
	/**
	 * DBと接続する
	 *
	 * @return DBコネクション
	 * @throws ClassNotFoundException
	 *             ドライバクラスが見つからなかった場合
	 * @throws SQLException
	 *             DB接続に失敗した場合
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// JDBCドライバクラスをJVMに登録
		Class.forName(DRIVER);
		// DBに接続
		Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("DBに接続しました");
		return conn;
	}

	/**
	 * DBとの接続を切断する
	 *
	 * @param connection
	 *            DBとの接続情報
	 * @throws SQLException
	 *             クローズ処理に失敗した場合に送出
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("DBと切断しました");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 *
	 * @param statement ステートメント情報
	 *
	 * @throws SQLException クローズ処理に失敗した場合に送出
	 */

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * PreparedStatementをクローズする
	 *
	 * @param preparedStatement
	 *            ステートメント情報
	 * @throws SQLException
	 *             クローズ処理に失敗した場合に送出
	 */
	public static void close(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ResultSetをクローズする
	 *
	 * @param resultSet
	 *            SQL検索結果
	 * @throws SQLException
	 *             クローズ処理に失敗した場合に送出
	 */
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
