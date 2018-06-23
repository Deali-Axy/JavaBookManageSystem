package da.Model;

import da.Core.Model.ModelBase;
import da.Core.Model.ModelHandler;
import da.Core.Model.QuerySet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserHandler extends ModelHandler {
    private static final String TableName = "User";

    protected UserHandler() throws SQLException, ClassNotFoundException {
        init(TableName);
        init();
    }

    @Override
    public ArrayList<HashMap<String, Object>> all() {
        return querySet;
    }

    @Override
    public ArrayList<HashMap<String, Object>> filter(String field, String value) {

        return null;
    }

    @Override
    protected void init() throws SQLException {
        while (resultSet.next()) {
            User u = new User();
            u.setId(resultSet.getInt("id"));
            u.setName(resultSet.getString("name"));
            u.setPassword(resultSet.getString("password"));


            HashMap<String, Object> user = new HashMap<>();
            user.put("id", resultSet.getInt("id"));
            user.put("name", resultSet.getString("name"));
            user.put("password", resultSet.getString("password"));
            querySet.add(user);
        }
    }
}
