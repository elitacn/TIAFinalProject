package com.example.HousePricePredict;

import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/house-price")
public class HousePricePredictController {

    @PostMapping("/predict")
    public Map<String, String> predictHousePrice(@RequestBody HousePricePredictInput input) {
        Map<String, String> response = new HashMap<>();

        try {
            // Log input data yang diterima
            System.out.println("Received input: LB=" + input.getLB() + ", LT=" + input.getLT() + ", KT=" + input.getKT() + ", KM=" + input.getKM() + ", GRS=" + input.getGRS());

            // Path ke file Python untuk prediksi harga rumah
            String pythonFilePath = "C:\\PythonProject\\House-Price-Predict\\house_price_predict_cmd.py";

            // Menjalankan script Python dengan parameter input
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "python", pythonFilePath,
                    String.valueOf(input.getLB()),  // Luas Bangunan
                    String.valueOf(input.getLT()),  // Luas Tanah
                    String.valueOf(input.getKT()),  // Jumlah Kamar Tidur
                    String.valueOf(input.getKM()),  // Jumlah Kamar Mandi
                    String.valueOf(input.getGRS())  // Jumlah Garasi
            );

            // Set direktori untuk menjalankan Python script
            processBuilder.directory(new File("C:\\PythonProject\\House-Price-Predict\\"));
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            // Membaca output dari script Python
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            process.waitFor(); // Menunggu proses Python selesai

            // Log output dari Python untuk memastikan output benar
            System.out.println("Python output: " + output.toString());

            // Menghapus newline di akhir output
            String prediction = output.toString().trim();

            // Menyimpan hasil prediksi dalam response
            response.put("prediction", prediction);
        } catch (Exception e) {
            e.printStackTrace(); // Gunakan logging untuk produksi
            response.put("error", "Terjadi kesalahan: " + e.getMessage());
        }

        return response;
    }
}