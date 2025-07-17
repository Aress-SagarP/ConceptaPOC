package Wrappers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ExtractHTMLTable {

    public static void extractTestResultsTable(String inputHtmlFile, String emailBodyFile) {
        try {
            // Parse the input HTML file
            File inputFile = new File(inputHtmlFile);
            Document document = Jsoup.parse(inputFile, "UTF-8");

            // Find the specific table by checking headers
            Element matchingTable = null;
            Elements tables = document.select("table");

            for (Element table : tables) {
                Elements headers = table.select("th");
                boolean hasRequiredHeaders = headers.stream()
                        .map(Element::text)
                        .anyMatch(header -> header.equalsIgnoreCase("Name")) &&
                        headers.stream()
                        .map(Element::text)
                        .anyMatch(header -> header.equalsIgnoreCase("Passed")) &&
                        headers.stream()
                        .map(Element::text)
                        .anyMatch(header -> header.equalsIgnoreCase("Failed"));

                if (hasRequiredHeaders) {
                    matchingTable = table;
                    break;
                }
            }

            // Create the email body with table styling
            StringBuilder emailBody = new StringBuilder();

            // Add email greeting and introduction
            emailBody.append("<html><head><title>Test Results</title>");
            emailBody.append("<style>");
            emailBody.append("table { border-collapse: collapse; width: 24%; font-size: 12px; text-align: left; } ");
            emailBody.append("th, td { border: 1px solid #dddddd; padding: 8px; } ");
            emailBody.append("th { background-color: #f4f4f4; } ");
            emailBody.append("tr:nth-child(even) { background-color: #f9f9f9; } ");
            emailBody.append("tr:hover { background-color: #f1f1f1; } ");
            emailBody.append("</style></head><body>");

            emailBody.append("<p>Hi Team,</p>");
            emailBody.append("<p>Please find the attached Regression Live execution report.</p>");
			emailBody.append("<p>Below is the Execution Report Summary:</p>");

            // If a matching table is found, add it to the email body
            if (matchingTable != null) {
                emailBody.append(matchingTable.outerHtml());
            } else {
                emailBody.append("<p>No matching test results table found.</p>");
            }

            // Add closing remarks
            emailBody.append("<p>Best regards,</p>");
            emailBody.append("<p>Atharva</p>");
            emailBody.append("</body></html>");

            // Save the email body to a file
            try (FileWriter writer = new FileWriter(emailBodyFile)) {
                writer.write(emailBody.toString());
            }

            //System.out.println("Email body generated and saved to: " + emailBodyFile);

        } catch (IOException e) {
            System.err.println("Error processing HTML file: " + e.getMessage());
        }
    }

    public static String GetReportPath() {
        File folder = new File(System.getProperty("user.dir") + "/reports/");
        String path = null;

        // Check if the folder exists and is a directory
        if (folder.exists() && folder.isDirectory()) {
            // Get the list of files in the folder, sorted by last modified date
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().contains("report"));
            if (files != null && files.length > 0) {
                Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
                path = files[0].getAbsolutePath(); // Return the most recently modified report
            }
        }
        return path;
    }

    public static void main(String[] args) {
        // Specify the paths to your input and output files
        String inputHtmlFile = "C:\\path\\to\\RegressionSuiteLive_29_11_2024.html"; // Update with your input file path
        String emailBodyFile = "C:\\path\\to\\emailBody.html"; // Update with your email body file path

        // Extract the table and generate the email body
        extractTestResultsTable(inputHtmlFile, emailBodyFile);
    }
}
