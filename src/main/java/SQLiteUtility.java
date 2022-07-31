import javax.xml.transform.Result;
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

    public static int insertItem(String name, int stock, int priceCents, String imagePath) {
        int retVal;
        if (name == null || imagePath == null)
            return -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Item (name, stock, pricecents, imagepath) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, stock);
            preparedStatement.setInt(3, priceCents);
            preparedStatement.setString(4, imagePath);
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

    public static int updateCustomer(int id, String status) {
        if (status == null)
            return -1;
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customer SET status = ? WHERE id = ?");
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    public static int updateItem(int id, String name, Integer stock, Integer priceCents, String imagePath) {
        String start = "UPDATE Item SET ";
        String end = " WHERE id = ?";
        String sets = "";
        int countChanges = 0;
        if (name != null) {
            countChanges++;
            sets = sets + "name = ?, ";
        }
        if (stock != null) {
            countChanges++;
            sets = sets + "stock = ?, ";
        }
        if (priceCents != null) {
            countChanges++;
            sets = sets + "pricecents = ?, ";
        }
        if (imagePath != null) {
            countChanges++;
            sets = sets + "imagepath = ?, ";
        }
        if (countChanges == 0)
            return -1;
        sets = sets.substring(0, sets.length() - 2);
        try {
            preparedStatement = connection.prepareStatement(start + sets + end);
            int i = 1;
            if (name != null) {
                preparedStatement.setString(i, name);
                i++;
            }
            if (stock != null) {
                preparedStatement.setInt(i, stock);
                i++;
            }
            if (priceCents != null) {
                preparedStatement.setInt(i, priceCents);
                i++;
            }
            if (imagePath != null) {
                preparedStatement.setString(i, imagePath);
                i++;
            }
            preparedStatement.setInt(i, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    public static Admin getAdmin(int id) {
        Admin admin;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Admin WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            admin = new Admin(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return admin;
    }

    public static Customer getCustomer(int id) {
        Customer customer;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            customer = new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return customer;
    }

    public static DiscountCode getDiscountCode(String code) {
        DiscountCode discount;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Discount WHERE code = ?");
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            discount = new DiscountCode(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getString(4));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return discount;
    }

    public static Item getItem(int id) {
        Item item;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Item WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            item = new Item(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getInt(4), resultSet.getString(5));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return item;
    }

    public static Order getOrder(int id) {
        Order order;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM TOrder WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            order = new Order(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return order;
    }
}