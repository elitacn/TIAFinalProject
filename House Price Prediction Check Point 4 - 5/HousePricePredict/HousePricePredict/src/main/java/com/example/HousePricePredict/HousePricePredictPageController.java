package com.example.HousePricePredict;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HousePricePredictPageController {

    @GetMapping("/")
    public String home() {
        // Mengarahkan ke template house_price_prediction.html
        return "house_price_prediction";
    }
}
