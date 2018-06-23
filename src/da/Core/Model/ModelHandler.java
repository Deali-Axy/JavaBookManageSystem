package da.Core.Model;

import da.Config.Database;
import da.Core.SQLiteHelper.SqliteHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Core ObjectsBase
 */
public abstract class ModelHandler {
    protected SqliteHelper sqlite;
    protected ResultSet resultSet;
    protected ArrayList<ModelBase> objects;
    protected ArrayList<HashMap<String, Object>> querySet;

    public abstract ArrayList<HashMap<String, Object>> all();

    public abstract ArrayList<HashMap<String, Object>> filter(String field, String value);

    protected abstract void init() throws SQLException;


    protected ModelHandler() throws SQLException, ClassNotFoundException {
        sqlite = new SqliteHelper(Database.FilePath);
        querySet = new ArrayList<>();
    }

    protected void init(String tableName) throws SQLException, ClassNotFoundException {
        resultSet = sqlite.executeQuery("select * from " + tableName);
    }
}
