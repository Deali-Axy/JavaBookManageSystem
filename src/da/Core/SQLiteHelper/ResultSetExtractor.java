package da.Core.SQLiteHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集 处理接口
 * @param <T>
 */
public interface ResultSetExtractor<T> {
    /**
     * 导出数据
     * @param rs
     * @return
     * @throws SQLException
     */
    public abstract T extractData(ResultSet rs) throws SQLException;
}