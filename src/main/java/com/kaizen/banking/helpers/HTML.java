package com.kaizen.banking.helpers;

public class HTML {
    public static String htmlEmailTemplate(String token, String code){
        String url = "http://127.0.0.1:8080/verify?token=" + token + "&code=" + code;
        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>Account Verification</title>\n" +
                "  <style>\n" +
                "    /* Reset some default styles */\n" +
                "    body, html {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "    }\n" +
                "    /* Set a background color */\n" +
                "    body {\n" +
                "      background-color: #f7f7f7;\n" +
                "    }\n" +
                "    /* Container to center the email content */\n" +
                "    .container {\n" +
                "      max-width: 600px;\n" +
                "      margin: auto;\n" +
                "      padding: 20px;\n" +
                "      background-color: #ffffff;\n" +
                "    }\n" +
                "    /* Heading styles */\n" +
                "    h1 {\n" +
                "      color: #333333;\n" +
                "      font-size: 24px;\n" +
                "      margin-bottom: 20px;\n" +
                "    }\n" +
                "    /* Paragraph styles */\n" +
                "    p {\n" +
                "      color: #777777;\n" +
                "      font-size: 16px;\n" +
                "      margin-bottom: 20px;\n" +
                "    }\n" +
                "    /* Button styles */\n" +
                "    .btn {\n" +
                "      display: inline-block;\n" +
                "      padding: 10px 20px;\n" +
                "      background-color: #007bff;\n" +
                "      color: #ffffff;\n" +
                "      text-decoration: none;\n" +
                "      font-size: 18px;\n" +
                "      border-radius: 5px;\n" +
                "    }\n" +
                "    /* Button hover styles */\n" +
                "    .btn:hover {\n" +
                "      background-color: #0056b3;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class='container'>\n" +
                "    <h1>Account Verification</h1>\n" +
                "    <p>Thank you for creating an account with us. Please click the button below to verify your email address:</p>\n" +
                "    <a href='"+ url +"' class='btn'>Verify Email</a>\n" +
                "    <p>If you did not create an account with us, you can ignore this email.</p>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>\n";
        return emailTemplate;
    }
}
