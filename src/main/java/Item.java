// class Item is used to take and hold the information of the users id, name, stock, price, and an image of said item.
public class Item {
    private int id;
    private String name;
    private int stock;
    private int priceCents;
    private String imagePath;
/**
* 
* @param id Takes the id of the item 
* @param name Takes the name of the item
* @param stock Takes the number of the item in stock
* @param priceCents Checks for the price of the item
* @param imagePath Scans the image of the item
*/
    public Item(int id, String name, int stock, int priceCents, String imagePath) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.priceCents = priceCents;
        this.imagePath = imagePath;
    }
// Takes and returns the ID of the item
    public int getId() {
        return id;
    }
// Takes and returns the name of the item
    public String getName() {
        return name;
    }
// Takes the inventory (stock) of the item
    public int getStock() {
        return stock;
    }
// Takes the price of the item
    public int getPriceCents() {
        return priceCents;
    }
// Pulls the image of the item
    public String getImagePath() {
        return imagePath;
    }
/**
* @return Item Returns the item and the associated id, name, stock, price, and image
*/
    @Override
    public String toString() {
        return "Item{\n    " + id + ",\n    " + name + ",\n    " + stock + ",\n    " + priceCents + ",\n    " + imagePath + "\n}";
    }
}
