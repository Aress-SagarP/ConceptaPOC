package Wrappers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CSVUploaderWithTextReplacement {
	
	public static void updateAndUploadCSV(WebDriver driver, String filePath, WebElement fileUpload, String targetText, String replacement) throws IOException {
        // Create temp file
        File originalFile = new File(filePath);
        File tempFile = File.createTempFile("updated_", ".csv");

        // Read and replace content
        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                updatedLines.add(line.replace(targetText, replacement));
            }
        }

        // Write updated content to temp file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        }

        // Upload updated file using Selenium
        //WebElement uploadElement = driver.findElement(fileUpload);
        fileUpload.sendKeys(tempFile.getAbsolutePath());

        // Optionally delete the temp file after upload
        // tempFile.deleteOnExit();
    }
	
	
	public static void updateAndUploadCSVMultipleValues(
            WebDriver driver,
            String filePath,
            WebElement fileUpload,
            Map<String, String> replacements) throws IOException {

        // Create temp file
        File originalFile = new File(filePath);
        File tempFile = File.createTempFile("updated_", ".csv");

        // Read and replace content
        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (Map.Entry<String, String> entry : replacements.entrySet()) {
                    line = line.replace(entry.getKey(), entry.getValue());
                }
                updatedLines.add(line);
            }
        }

        // Write updated content to temp file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        }

        // Upload updated file using Selenium
        fileUpload.sendKeys(tempFile.getAbsolutePath());

        // Optionally delete the temp file after upload
        // tempFile.deleteOnExit();
    }

}
