package da.Temp;

import da.Core.SQLiteHelper.*;

public class HelloSqlite2 {
    static String db_url = "jdbc:sqlite:data/hello-sqlite.db";
    static String db_file = "data/hello-sqlite.db";

    public static void main(String args[]) {
        try {
            SqliteHelper h = new SqliteHelper(db_file);
            h.executeUpdate("create table test(name varchar(20));");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
