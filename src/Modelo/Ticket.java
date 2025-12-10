/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ticket {
    private String contentTicket = 
            "                COPYMAX                \n" +
            "        Calidad al mejor precio        \n" +
            "=======================================\n" +
            "        Calzada Madero N°999-L1        \n" +
            "     Centro Oaxaca, Oax C.P 6800       \n" +
            " RFC: BAPB7112044N2 Regimen Inc.Fiscal \n" +
            "Ticket # {{ticket}}                    \n" +
            "LE ATENDIO: {{cajero}}                 \n" +
            "Cliente: {{cliente}}                   \n" +
            "{{dateTime}}                           \n" +
            "=======================================\n" +
            "CANT|DESCRIPCION         |P.UNI|IMPORTE\n" +
            "=======================================\n" +
            "{{items}}                              \n" +
            "=======================================\n" +
            "SUBTOTAL: {{subTotal}}\n" +
            "Descuento: {{descuento}}\n" +
            "IVA: {{tax}}\n" +
            "TOTAL: {{total}}\n\n" +
            "RECIBIDO: {{recibo}}\n" +
            "CAMBIO: {{change}}\n" +
            "=======================================\n" +
            "GRACIAS POR SU COMPRA...\n" +
            "ESPERAMOS SU VISITA NUEVAMENTE \n" +
            "\n" +
            "\n";

    public Ticket(String ticket, String usuario, String cliente, String dateTime, String items, String subTotal, String descuento, String impuesto, String total, String recibido, String change) {
        this.contentTicket = this.contentTicket.replace("{{ticket}}", ticket);
        this.contentTicket = this.contentTicket.replace("{{cajero}}", usuario);
        this.contentTicket = this.contentTicket.replace("{{cliente}}", cliente);
        this.contentTicket = this.contentTicket.replace("{{dateTime}}", dateTime);
        this.contentTicket = this.contentTicket.replace("{{items}}", items);
        this.contentTicket = this.contentTicket.replace("{{subTotal}}", subTotal);
        this.contentTicket = this.contentTicket.replace("{{descuento}}", descuento);
        this.contentTicket = this.contentTicket.replace("{{tax}}", impuesto);
        this.contentTicket = this.contentTicket.replace("{{total}}", total);
        this.contentTicket = this.contentTicket.replace("{{recibo}}", recibido);
        this.contentTicket = this.contentTicket.replace("{{change}}", change);
    }

    public void print(String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            // Usa una fuente monoespaciada para mantener la alineación
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 10);
            document.add(new Paragraph(contentTicket, font));
            document.close();
            JOptionPane.showMessageDialog(null, "Ticket creado correctamente en: " + filePath);
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el ticket: " + e.getMessage());
        }
    }

    public void print() {
        String directory = "C:\\Users\\maxst\\OneDrive\\Zoomestre\\Topicos Avanzados\\Copymax\\Tickets";
        String fileName = "ticket_" + java.time.LocalDateTime.now().toString().replace(":", "-") + ".pdf";
        String filePath = directory + "\\" + fileName;
        print(filePath);
        
    }


    public void enviarEmailConPDF(String destinatario, String filePath) {
        String host = "smtp.gmail.com"; // Servidor SMTP para Hotmail
        final String username = "maxstell5548@gmail.com"; // Cambia esto a tu correo de Hotmail
        final String password = "ojur kxqg lsgk beta"; // Cambia esto a tu contraseña

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Copymax Ticket de compra");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Adjunto el ticket de su compra \n Gracias por su preferencia :D");

        // Adjuntar el archivo PDF
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filePath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        
        // Generar el nombre del archivo adjunto
        String fileName = "Ticket de Venta_" + java.time.LocalDateTime.now().toString().replace(":", "-") + ".pdf";
        messageBodyPart.setFileName(fileName);

        multipart.addBodyPart(messageBodyPart);

        // Enviar el mensaje completo
        message.setContent(multipart);

        Transport.send(message);
        JOptionPane.showMessageDialog(null, "El ticket ha sido enviado exitosamente");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
 }
}
