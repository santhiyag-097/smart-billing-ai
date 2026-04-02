package smartbilling_ai.demo.controller;

import smartbilling_ai.demo.service.BillingService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BillingController {

    private final BillingService service;

    public BillingController(BillingService service) {
        this.service = service;
    }

    @PostMapping("/bill")
    public Map<String, Object> generateBill(@RequestBody Map<String, List<String>> data) {
        int total = service.calculateTotal(data.get("items"));
        return Map.of("total", total);
    }

    @PostMapping("/check-theft")
    public Map<String, Boolean> check(@RequestBody Map<String, List<String>> data) {
        boolean result = service.detectTheft(
                data.get("detected"),
                data.get("billed")
        );
        return Map.of("theftDetected", result);
    }
}