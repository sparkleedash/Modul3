import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restauran {
    private static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) {
        initializeMenu();
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Selamat datang di Restoran Safwa!");
        while (true) {
            System.out.println("Pilih kategori makanan (ketik nomor atau 'done' untuk selesai):");
            for (int i = 0; i < categories.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, categories.get(i).getName());
            }

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            int categoryIndex = Integer.parseInt(input) - 1;
            if (categoryIndex >= 0 && categoryIndex < categories.size()) {
                displayMenuItems(categories.get(categoryIndex), order, scanner);
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        order.printReceipt();
        scanner.close();
    }

    private static void initializeMenu() {

        Category mainDishes = new Category("Makanan Utama");
        mainDishes.addItem(new MenuItem("Nasi Goreng", 20000));
        mainDishes.addItem(new MenuItem("Mie Goreng", 18000));
        mainDishes.addItem(new MenuItem("Ayam Penyet", 25000));
        categories.add(mainDishes);

        Category drinks = new Category("Minuman");
        drinks.addItem(new MenuItem("Es Teh", 5000));
        drinks.addItem(new MenuItem("Jus Jeruk", 15000));
        drinks.addItem(new MenuItem("Kopi", 10000));
        categories.add(drinks);

        Category snacks = new Category("Snack");
        snacks.addItem(new MenuItem("Keripik", 7000));
        snacks.addItem(new MenuItem("Kue Cubir", 12000));
        categories.add(snacks);
    }

    private static void displayMenuItems(Category category, Order order, Scanner scanner) {
        System.out.println("Menu " + category.getName() + ":");
        for (int i = 0; i < category.getItems().size(); i++) {
            MenuItem item = category.getItems().get(i);
            System.out.printf("%d. %s - Rp%.2f%n", i + 1, item.getName(), item.getPrice());
        }

        System.out.println("Pilih item (ketik nomor atau 'back' untuk kembali):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("back")) {
                break;
            }

            int itemIndex = Integer.parseInt(input) - 1;
            if (itemIndex >= 0 && itemIndex < category.getItems().size()) {
                order.addItem(category.getItems().get(itemIndex));
                System.out.println("Item ditambahkan: " + category.getItems().get(itemIndex).getName());
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}

