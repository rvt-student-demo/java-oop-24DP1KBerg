package rvt;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    Map<String, Integer> prices = new HashMap<>();

    public void addProduct(String product, int price, int stock){
        prices.put(product, price);
    }

    public int price(String product){

        if (!prices.containsKey(product)) {
            return -99;
        }
        return prices.get(product);
    }
}
