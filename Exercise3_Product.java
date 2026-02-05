
/**
 * Write a description of class Exercise3_Product here.
 * group six
 * @author (mohd sheha khamis)
 * @version (5 feb 2026)
 */
public class Exercise3_Product
{
    //attributes
    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;

    //constructors
    public Exercise3_Product() {
        this.productCode = "N/A";
        this.productName = "Unknown";
        this.category = "General";
        this.unitPrice = 0.0;
        this.quantityInStock = 0;
        this.reorderLevel = 10;
    }

    public Exercise3_Product(String productCode, String productName, String category, double unitPrice, int quantityInStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        setUnitPrice(unitPrice);
        setQuantityInStock(quantityInStock);
        this.reorderLevel = 10;
    }

    public String getProductCode() { return productCode; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantityInStock() { return quantityInStock; }
    public int getReorderLevel() { return reorderLevel; }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice > 0) {
            this.unitPrice = unitPrice;
        } else {
            System.out.println("Warning: Price must be positive!");
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        } else {
            System.out.println("Warning: Stock cannot be negative!");
        }
    }

    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel > 0) {
            this.reorderLevel = reorderLevel;
        }
    }
    
    public void addStock(int quantity) {
        if (quantity > 0) {
            this.quantityInStock += quantity;
            System.out.println("Added " + quantity + " units to " + productName);
        }
    }

    public boolean sellProduct(int quantity) {
        if (quantity <= quantityInStock) {
            this.quantityInStock -= quantity;
            System.out.println("Sold " + quantity + " units of " + productName);
            return true;
        } else {
            System.out.println("Error: Not enough stock for " + productName);
            return false;
        }
    }

    public double calculateStockValue() {
        return unitPrice * quantityInStock;
    }

    public boolean needsReorder() {
        return quantityInStock <= reorderLevel;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage < 100) {
            double discountAmount = unitPrice * (percentage / 100);
            unitPrice -= discountAmount;
            System.out.println("Applied " + percentage + "% discount to " + productName);
        }
    }

    public void displayProductInfo() {
        System.out.println("Product: " + productName + " [" + productCode + "]");
        System.out.println("Category: " + category + " | Price: " + unitPrice);
        System.out.println("Stock: " + quantityInStock + " | Reorder Level: " + reorderLevel);
        if (needsReorder()) {
            System.out.println("!!! LOW STOCK ALERT !!!");
        }
        System.out.println("Total Value: " + calculateStockValue());
        System.out.println("-----------------------------------");
    }

    
    public static void main(String[] args) {
        System.out.println("=== Product Inventory Exercise ===\n");

        Exercise3_Product p1 = new Exercise3_Product("PRD001", "Laptop", "Electronics", 1500000, 25);
        Exercise3_Product p2 = new Exercise3_Product("PRD002", "Office Chair", "Furniture", 350000, 8);
        Exercise3_Product p3 = new Exercise3_Product("PRD003", "Notebook", "Stationery", 5000, 100);
        
        p1.displayProductInfo();
        p2.displayProductInfo();
        p3.displayProductInfo();
        p1.sellProduct(20);
        
        if (p2.needsReorder()) {
            System.out.println(p2.getProductName() + " Needs to Restocked!");
        }
        
        p2.addStock(50);
        p3.applyDiscount(15);
        System.out.println("\n--- FINAL INVENTORY STATUS ---");
        p1.displayProductInfo();
        p2.displayProductInfo();
        p3.displayProductInfo();
        System.out.println("\n=== Exercise Complete ===");
    }
}
