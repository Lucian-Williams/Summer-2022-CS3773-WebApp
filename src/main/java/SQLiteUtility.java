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

    public static void insertAdmin(String name, int verifier) {
        if (name == null)
            return;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Admin (name, verifier) VALUES(?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, verifier);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCustomer(String name, String state, String birthDt, String creatDt, String gender) {
        if (name == null ||
                state == null ||
                birthDt == null ||
                creatDt == null ||
                gender == null) {
            return;
        }
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customer (name, state, birthDt, creatDt, gender) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, state);
            preparedStatement.setString(3, birthDt);
            preparedStatement.setString(4, creatDt);
            preparedStatement.setString(5, gender);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDiscount(String code, int percentOff, int maxDollarAmount, int status, String expireDt) {
        if (code == null || expireDt == null)
            return;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Discount (code, percentOff, maxDollarAmount, status, expireDt) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, code);
            preparedStatement.setInt(2, percentOff);
            preparedStatement.setInt(3, maxDollarAmount);
            preparedStatement.setInt(4, status);
            preparedStatement.setString(5, expireDt);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static void insertOrder(int custId, int totalPriceCents, int status, String discountCode, String orderDt) {
        if (discountCode == null || orderDt == null)
            return;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO TOrder (custId, totalPriceCents, status, discountCode, orderDt) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, custId);
            preparedStatement.setInt(2, totalPriceCents);
            preparedStatement.setInt(3, status);
            preparedStatement.setString(4, discountCode);
            preparedStatement.setString(5, orderDt);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertSale(int itemId, int percentOff, String startDt, String expireDt) {
        if (startDt == null || expireDt == null)
            return;
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
        }
    }
}
