package da.Core.SQLiteHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class SqliteTest {

    @Test
    public void testHelper() {
        try {
            SqliteHelper h = new SqliteHelper("data/testHelper.db");
            h.executeUpdate("drop table if exists test;");
            h.executeUpdate("create table test(name varchar(20),value varchar(20));");
            h.executeUpdate("insert into test values('sqliteHelper test','hello');");
            h.executeUpdate("insert into test values('sqliteHelper 1','hello');");
            h.executeUpdate("insert into test values('sqliteHelper 2','hello');");
            h.executeUpdate("insert into test values('sqliteHelper 3','hello');");
            h.executeUpdate("insert into test values('sqliteHelper 4','hello');");
            List<String> sList = h.executeQuery("select * from test", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int index) throws SQLException {
                    return rs.getString("value");
                }
            });
            for (String s : sList) {
                System.out.println(s);
            }

            String temp = h.executeQuery("select * from test", new ResultSetExtractor<String>() {
                @Override
                public String extractData(ResultSet rs) throws SQLException {
                    return rs.getString("name");
                }
            });
            System.out.println(temp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}