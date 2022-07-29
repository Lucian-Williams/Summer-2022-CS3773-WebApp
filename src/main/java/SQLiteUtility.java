import java.awt.image.BufferedImage;
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

    public static void insertItem(String name, int itemType, int stock, int priceCents, String imagePath) {
        if (name == null || imagePath == null)
            return;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Item (name, itemType, stock, pricecents, imagepath) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, itemType);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, priceCents);
            preparedStatement.setString(5, imagePath);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
