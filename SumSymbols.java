import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class SumSymbols {

    public static void main(String[] args) {
        // Files and their encodings
        String[][] files = {
            {"/Users/kamalkuumarroy/Downloads/q-unicode-data/data1.csv", "Cp1252"},
            {"/Users/kamalkuumarroy/Downloads/q-unicode-data/data2.csv", "UTF-8"},
            {"/Users/kamalkuumarroy/Downloads/q-unicode-data/data3.txt", "UTF-16"}
        };

        // Symbols to match
        Set<String> targetSymbols = new HashSet<>(Arrays.asList("–", "ž", "”"));

        double totalSum = 0.0;

        for (String[] fileInfo : files) {
            Path path = Paths.get(fileInfo[0]);
            Charset encoding = Charset.forName(fileInfo[1]);

            try (BufferedReader reader = Files.newBufferedReader(path, encoding)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;

                    // Split on comma or tab
                    String[] parts = line.split("[,\t]");
                    if (parts.length < 2) continue;

                    String symbol = parts[0].trim();
                    String valueStr = parts[1].trim();

                    if (targetSymbols.contains(symbol)) {
                        try {
                            double value = Double.parseDouble(valueStr);
                            totalSum += value;
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid number: " + valueStr + " in file " + fileInfo[0]);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + fileInfo[0]);
                e.printStackTrace();
            }
        }

        System.out.println("Total sum of matching symbols: " + totalSum);
    }
}