import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class EmailSender {
    public static void main(String[] args) {
        // Sender's credentials
        String senderEmail = "arpitvermabiswa@gmail.com";
        String senderPassword = "nibzegxssbffgpxc";
        // Recipient's email
        String recipientEmail = "rakeshchau144@gmail.com";
        String host = "smtp.gmail.com";
        int port = 587;
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Testing JavaMail API");
            message.setText("Hello bhosdik, This is a test email from JavaMail API!");

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}