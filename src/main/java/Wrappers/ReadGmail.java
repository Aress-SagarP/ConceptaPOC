package Wrappers;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
 
public class ReadGmail {
 
    public String getButtonURL(String buttonName) throws Exception {
        final String username = "aresssoftwareconceptaautomatio@gmail.com";
        final String password = "uqyo gmxn rbak nzxp"; // Use App Password for Gmail
 
        String buttonURL = null;
 
        // ✅ IMAP Properties
        Properties props = new Properties();
        props.put("mail.store.protocol", "imap");
        props.put("mail.imap.host", "imap.gmail.com");
        props.put("mail.imap.port", "993");
        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.ssl.trust", "*");
        props.put("mail.imap.auth", "true");
        props.put("mail.imap.connectiontimeout", "15000");
        props.put("mail.imap.timeout", "15000");
        props.put("mail.imap.writetimeout", "15000");
        System.setProperty("java.net.preferIPv4Stack", "true");
 
        // ✅ Create session and enable debug
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
 
        Store store = session.getStore("imap");
        boolean connected = false;
        int retryCount = 0;
 
        // ✅ Retry logic for connecting to Gmail
        while (!connected && retryCount < 3) {
            try {
                store.connect("imap.gmail.com", username, password);
                connected = true;
            } catch (MessagingException e) {
                retryCount++;
                System.out.println("Connection failed (attempt " + retryCount + "): " + e.getMessage());
                if (retryCount == 3) {
                    e.printStackTrace();
                    return null;
                }
                Thread.sleep(3000); // wait before retrying
            }
        }
 
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
 
        // ✅ Get the latest email
        Message[] messages = inbox.getMessages();
        int boxSize = messages.length;
        if (boxSize == 0) {
            System.out.println("No emails found!");
            return null;
        }
 
        Message latestMessage = messages[boxSize - 1]; // Last email
        String emailContent = getEmailContent(latestMessage);
        emailContent = emailContent.replaceAll("=\\r?\\n", "");
        emailContent = emailContent.replaceAll("=3D", "=");
 
        if (emailContent == null) {
            System.out.println("No valid email content found!");
            return null;
        }
 
        // ✅ Extract data based on buttonName
        switch (buttonName) {
            case "URL":
                String urlPattern = "href=['\"](https:\\/\\/hcp-portal-purushottam.dev\\.myhealthchecked\\.com\\/my-account\\/[^'\"]+)['\"]";
                Matcher urlMatcher = Pattern.compile(urlPattern).matcher(emailContent);
                if (urlMatcher.find()) {
                    buttonURL = urlMatcher.group(1);
                    System.out.println("Extracted URL: " + buttonURL);
                } else {
                    System.out.println("No matching URL found.");
                }
                break;
 
            case "Confirmation Email":
                if (emailContent.contains("Thank you for completing your appointment")) {
                    System.out.println("Confirmation text found.");
                } else {
                    System.out.println("Confirmation text not found.");
                }
                break;
 
            case "Completed Activation Kit":
                if (emailContent.contains("Thank you for activating your MyHealthChecked sample collection kit.")) {
                    System.out.println("Activation Kit confirmation found.");
                } else {
                    System.out.println("Activation Kit text not found.");
                }
                break;
 
            case "ExtractID":
                String idPattern = "\\s*([A-Za-z]{2}\\d{5})";
                Matcher idMatcher = Pattern.compile(idPattern).matcher(emailContent);
                if (idMatcher.find()) {
                    String extractedID = idMatcher.group(1);
                    System.out.println("Extracted ID: " + extractedID);
                    return extractedID;
                } else {
                    System.out.println("No matching ID found.");
                }
                break;
 
            case "URL_Redirect_Profile":
              //  String redirectPattern = "href=\"(https:\\/\\/click-staging\\.myhealthchecked\\.com\\/CL0\\/[^\\s\"]+)\"";
            	String redirectPattern = "href=\\\"(https:\\/\\/click-staging\\.myhealthchecked\\.com\\/CL0\\/https:%2F%2Fdashboard-automation.myhealthchecked.com%2Freset-password%2F.*?)\\\"";
            	Matcher redirectMatcher = Pattern.compile(redirectPattern).matcher(emailContent);
                if (redirectMatcher.find()) {
                    buttonURL = redirectMatcher.group(1);
                    System.out.println("Redirect URL: " + buttonURL);
                } else {
                    System.out.println("Redirect URL not found.");
                }
            case "URL_Create_Account":    
            	//String redirectForAccount = "href=\"(https://click-staging\\.myhealthchecked\\.com/CL0/https:%2F%2Fdashboard-automation\\.myhealthchecked\\.com%2Fcreate-account%2F[\\w-]+%2F\\d+%2F[a-f0-9-]+%2F[\\w-_=]+=?\\d*)\"";
            	//String redirectForAccount ="href=\"(https:\\/\\/click-staging\\.myhealthchecked\\.com\\/CL0\\/https:%2F%2Fdashboard-automation\\.myhealthchecked\\.com%2Fcreate-account%2F.*?)";
            	String redirectForAccount = "href=\\\"(https:\\/\\/click-staging\\.myhealthchecked\\.com\\/CL0\\/https:%2F%2Fdashboard-automation\\.myhealthchecked\\.com%2Fcreate-account%2F.*?)\\\"";
 
            	Matcher redirectMatcherAccount = Pattern.compile(redirectForAccount,Pattern.DOTALL).matcher(emailContent);
                if (redirectMatcherAccount.find()) {
                    buttonURL = redirectMatcherAccount.group(1);
                    System.out.println("Redirect URL: " + buttonURL);
                } else {
                    System.out.println("Redirect URL not found.");
                }
                break;
 
            default:
                System.out.println("Invalid buttonName passed.");
        }
 
        // ✅ Close resources
        inbox.close(false);
        store.close();
 
        return buttonURL;
    }
 
    // ✅ Extract HTML content from email
    private static String getEmailContent(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return (String) message.getContent();
        } else if (message.isMimeType("text/html")) {
            return (String) message.getContent();
        } else if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart part = multipart.getBodyPart(i);
                if (part.isMimeType("text/html")) {
                    return (String) part.getContent();
                }
            }
        }
        return null;
    }
}