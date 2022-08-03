import cs3773.application.data.entity.Item;

import java.sql.*;
import java.sql.SQLException;

public class SQLiteUtility {
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void connect(String url, String user, String password) throws Exception {
        connection = DriverManager.getConnection(url, user, password);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    }

    public static void disconnect() throws Exception {
        connection.close();
    }

    public static void insertItem(Item item) {

    }
}
