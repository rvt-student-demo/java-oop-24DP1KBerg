package rvt;

import java.util.ArrayList;

public class Box {

    private double capacity;
    private ArrayList<packables> items;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void add(packables item) {
        if (totalWeight() + item.weight() <= capacity) {
            items.add(item);
        }
    }

    private double totalWeight() {
        double total = 0;
        for (packables item : items) {
            total += item.weight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + totalWeight() + " kg";
    }
}