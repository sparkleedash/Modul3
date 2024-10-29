import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private static final double TAX_RATE = 0.1; // 10% pajak
    private static final double DISCOUNT_THRESHOLD = 100000; // Batas diskon
    private static final double DISCOUNT_RATE = 0.1; // Diskon 10%

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double subtotal = 0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        double tax = subtotal * TAX_RATE;
        double discount = (subtotal > DISCOUNT_THRESHOLD) ? subtotal * DISCOUNT_RATE : 0;
        return subtotal + tax - discount;
    }



    public void printReceipt() {
        System.out.println("----- Nota Pemesanan -----");
        for (MenuItem item : items) {
            System.out.printf("%s - Rp%.2f%n", item.getName(), item.getPrice());
        }
        System.out.printf("Total setelah pajak dan diskon: Rp%.2f%n", calculateTotal());
    }
}

