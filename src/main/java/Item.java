public class Item {
    private int id;
    private String name;
    private int stock;
    private int priceCents;
    private String imagePath;

    public Item(int id, String name, int stock, int priceCents, String imagePath) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.priceCents = priceCents;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getPriceCents() {
        return priceCents;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Item{\n    " + id + ",\n    " + name + ",\n    " + stock + ",\n    " + priceCents + ",\n    " + imagePath + "\n}";
    }
}
