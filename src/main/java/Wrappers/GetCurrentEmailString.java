package Wrappers;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class GetCurrentEmailString {
	public static String getButtonURL(String buttonName) throws Exception {
        final String username = "testconcepta3@gmail.com";
        final String password = "clvy mjmt ykqf edzq"; // Use App Password for Gmail

        String buttonURL = null;

        // ✅ IMAP Properties
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", "imap.gmail.com");
        props.put("mail.imaps.port", "993");
        props.put("mail.imaps.ssl.enable", "true");
        props.put("mail.imaps.auth", "true");
        props.put("mail.imaps.timeout", "10000");
        props.put("mail.imaps.connectiontimeout", "5000");
        props.put("mail.imaps.ssl.trust", "imap.gmail.com");

        // ✅ Create session
        Session session = Session.getInstance(props, null);
        session.setDebug(true); // Enable debugging logs

        // ✅ Connect to IMAP Store
        Store store = session.getStore("imaps");
        store.connect(username, password);
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // ✅ Get latest email
        Message[] messages = inbox.getMessages();
        int boxSize = messages.length;
        if (boxSize == 0) {
            System.out.println("No emails found!");
            return null;
        }

        Message latestMessage = messages[boxSize - 1]; // Get the last received email
        String emailContent = getEmailContent(latestMessage); // ✅ Extract HTML content

        if (emailContent == null) {
            System.out.println("No valid email content found!");
            return null;
        }

        // ✅ Extract URL using regex
        String patternString = "href=['\"](https:\\/\\/hcp-portal-staging\\.myhealthchecked\\.com\\/my-account\\/[^'\"]+)['\"]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(emailContent);

        if (matcher.find()) {
            buttonURL = matcher.group(1);
            System.out.println("Extracted URL: " + buttonURL);
        } else {
            System.out.println("No matching URL found in email.");
        }

        // ✅ Close connections
        inbox.close(false);
        store.close();

        return buttonURL;
    }

    // ✅ Method to Extract HTML content from Email
    protected static String getEmailContent(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return (String) message.getContent();
        } else if (message.isMimeType("text/html")) {
            return (String) message.getContent();
        } else if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/html")) {
                    return (String) bodyPart.getContent(); // ✅ Return HTML content
                }
            }
        }
        return null; // No valid content found
    }
}

