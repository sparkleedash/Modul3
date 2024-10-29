import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<MenuItem> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
//ini update
