import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HousePythonScript {
    public static void main(String[] args) {
        try {
            // Command to run the house price prediction Python script with arguments
            String[] command = {
                "python",  // Use python or python3 depending on your environment
                "c:/PythonProject/House-Price-Predict/house_price_predict_cmd.py",  // Path to the Python script
                "150",   // Luas Bangunan
                "200",   // Luas Tanah
                "3",     // Jumlah Kamar Tidur
                "2",     // Jumlah Kamar Mandi
                "1"     // Jumlah Garasi
            };

            // Start the process
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true); // Combine standard output and error streams
            Process process = processBuilder.start();

            // Capture the output of the script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print the output of the Python script
            }

            // Wait for the process to complete and get the exit status
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            // Handle any exceptions that might occur
            
        }
    }
}
