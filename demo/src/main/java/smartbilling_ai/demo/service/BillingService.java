package smartbilling_ai.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BillingService {

    private Map<String, Integer> priceList = Map.of(
            "milk", 50,
            "bread", 30,
            "rice", 100
    );

    public int calculateTotal(List<String> items) {
        int total = 0;
        for (String item : items) {
            total += priceList.getOrDefault(item, 0);
        }
        return total;
    }

    public boolean detectTheft(List<String> detected, List<String> billed) {
        Map<String, Integer> d = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();

        for (String i : detected) d.put(i, d.getOrDefault(i, 0) + 1);
        for (String i : billed) b.put(i, b.getOrDefault(i, 0) + 1);

        return !d.equals(b);
    }
}