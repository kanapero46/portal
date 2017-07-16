package setting;

public class SQLSource {


	private String S_insert = "SELECT * FROM p_user";


	/**
	 * 引数からSQL文を返す
	 * @param param 要求しているSQL文のパラメーター
	 * @param tName テーブル名
	 * @return
	 * 1：インサート（挿入文）
	 * 2:delete（削除文）
	 * 3:update（更新分)
	 * 4:*（全件表示)
	 */
	public String getSQL(int param , String tName){
		String rSQL = null;
		switch(param){
		case 4:
			rSQL = "SELECT * FROM " + tName;
			break;

		}
		return rSQL;
	}


}
