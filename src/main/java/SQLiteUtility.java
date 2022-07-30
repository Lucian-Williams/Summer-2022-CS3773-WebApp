import java.awt.image.BufferedImage;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static int insertAdmin(String name, int verifier) {
        int retVal;
        ResultSet resultSet;
        if (name == null)
            return -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Admin (name, verifier) VALUES(?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, verifier);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT last_insert_rowid()");
            retVal = resultSet.getInt(1);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return retVal;
    }

    public static int insertDiscount(String code, int percentOff, String startDt, String expireDt) {
        if (code == null || startDt == null || expireDt == null)
            return -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Discount (code, percentOff, startDt, expireDt) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, code);
            preparedStatement.setInt(2, percentOff);
            preparedStatement.setString(3, startDt);
            preparedStatement.setString(4, expireDt);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    public static int insertItem(String name, int itemType, int stock, int priceCents, String imagePath) {
        int retVal;
        ResultSet resultSet;
        if (name == null || imagePath == null)
            return -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Item (name, itemType, stock, pricecents, imagepath) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, itemType);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, priceCents);
            preparedStatement.setString(5, imagePath);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT last_insert_rowid()");
            retVal = resultSet.getInt(1);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return retVal;
    }

    public static int insertSale(int itemId, int percentOff, String startDt, String expireDt) {
        if (startDt == null || expireDt == null)
            return -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Sale (itemId, percentOff, startDt, expireDt) VALUES(?, ?, ?, ?)");
            preparedStatement.setInt(1, itemId);
            preparedStatement.setInt(2, percentOff);
            preparedStatement.setString(3, startDt);
            preparedStatement.setString(4, expireDt);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }
}
