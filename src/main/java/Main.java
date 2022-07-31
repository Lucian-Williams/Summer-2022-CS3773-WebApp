public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:/" + System.getProperty("user.dir") + "\\src\\main\\resources\\shopDB.db";

        System.out.println("Hello world!");

        try {
            SQLiteUtility.connect(jdbcUrl, "", "");
            System.out.println(SQLiteUtility.insertAdmin("Paul", 16));
            System.out.println(SQLiteUtility.insertDiscount("RAIDSHADOWLEGENDS", 50, java.time.LocalDate.now().toString(), "2022-8-3"));
            System.out.println(SQLiteUtility.insertItem("Fancy Chess Queen", 200, 1000,
                System.getProperty("user.dir") + "\\src\\main\\resources\\fancy_chess_queen.png"));
            System.out.println(SQLiteUtility.insertSale(1, 20, java.time.LocalDate.now().toString(), "2022-8-2"));
            System.out.println(SQLiteUtility.updateItem(1, "Chess Queen", null, 500, null));
            Item item = SQLiteUtility.getItem(1);
            if (item == null) {
                System.out.println("getItem failed.");
            } else {
                System.out.println();
                System.out.println(item.getId());
                System.out.println(item.getName());
                System.out.println(item.getStock());
                System.out.println(item.getPriceCents());
                System.out.println(item.getImagePath());
            }
            SQLiteUtility.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}