package rvt;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    Map<String, Integer> prices = new HashMap<>();
    Map<String, Integer> stocks = new HashMap<>();

    public void addProduct(String product, int price, int stock){
        prices.put(product, price);
        stocks.put(product, stock); 
    }
    

    public int price(String product){

        if (!prices.containsKey(product)) {
            return -99;
        }
        return prices.get(product);
    }

    public int stock(String product){
        if (!stocks.containsKey(product)) {
            return 0;
        }
        return stocks.get(product);
    }
    public boolean take(String product){
        if (!prices.containsKey(product)) {
            return false;
        }
        
        int currentStock = stocks.get(product);

        if (currentStock > 0) {
            stocks.put(product, currentStock -1 );
            return true;
        }

        return false;

    }
}
