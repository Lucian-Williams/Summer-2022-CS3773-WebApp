public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:/" + System.getProperty("user.dir") + "\\src\\main\\resources\\shopDB.db";

        System.out.println("Hello world!");

        try {
            SQLiteUtility.connect(jdbcUrl, "", "");
            System.out.println(SQLiteUtility.insertAdmin("Paul Jones", 16));
            System.out.println(SQLiteUtility.insertDiscount("RAIDSHADOWLEGENDS", 50, java.time.LocalDate.now().toString(), "2022-8-3"));
            int itemId = SQLiteUtility.insertItem("Fancy Chess Queen", 200, 1000,
                    System.getProperty("user.dir") + "\\src\\main\\resources\\fancy_chess_queen.png");
            System.out.println(itemId);
            System.out.println(SQLiteUtility.insertSale(itemId, 20, java.time.LocalDate.now().toString(), "2022-8-2"));
            System.out.println(SQLiteUtility.updateItem(itemId, "Chess Queen", null, 500, null));
            Item item = SQLiteUtility.getItem(itemId);
            if (item == null) {
                System.out.println("getItem failed.");
            } else {
                System.out.println();
                System.out.println(item);
            }
            Admin[] admins = SQLiteUtility.getAdmins(0, 3, "name", SortDirection.ASCENDING);
            if (admins == null) {
                System.out.println("getAdmins failed.");
            } else {
                for (int i = 0; i < admins.length; i++) {
                    System.out.println(admins[i]);
                }
            }
            System.out.println(SQLiteUtility.getOrder(1));
            System.out.println("--------------START TEST-------------");
            Order[] orders = SQLiteUtility.getOrders(0, 8, "totalPriceCents", SortDirection.DESCENDING);
            for (int i = 0; i < orders.length; i++) {
                System.out.println();
                System.out.println(orders[i]);
            }
            SQLiteUtility.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}