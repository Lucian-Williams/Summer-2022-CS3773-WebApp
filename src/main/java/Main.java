public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:/" + System.getProperty("user.dir") + "\\src\\main\\resources\\shopDB.db";

        System.out.println("Hello world!");

        try {
            SQLiteUtility.connect(jdbcUrl, "", "");
            System.out.println(SQLiteUtility.insertAdmin("Paul", 16));
            System.out.println(SQLiteUtility.insertDiscount("RAIDSHADOWLEGENDS", 50, java.time.LocalDate.now().toString(), "2022-8-3"));
            System.out.println(SQLiteUtility.insertItem("Fancy Chess Queen", 0, 200, 1000,
                System.getProperty("user.dir") + "\\src\\main\\resources\\fancy_chess_queen.png"));
            System.out.println(SQLiteUtility.insertSale(1, 20, java.time.LocalDate.now().toString(), "2022-8-2"));
            SQLiteUtility.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
