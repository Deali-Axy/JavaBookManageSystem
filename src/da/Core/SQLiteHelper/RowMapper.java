package da.Core.SQLiteHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集行数据 处理接口
 *
 * @param <T>
 */
public interface RowMapper<T> {
    /**
     * 结果行 数据选择
     *
     * @param rs
     * @param index
     * @return
     * @throws SQLException
     */
    public abstract T mapRow(ResultSet rs, int index) throws SQLException;
}