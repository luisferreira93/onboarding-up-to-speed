package org.client.textanalysis.cli;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    private static final String sentence = "-s";
    private static final String host = "-h";
    private static final String port = "-p";

    public static void main(String[] args) {

        String sentenceValue = "";
        String hostValue = "localhost";
        String portValue = "8080";

        //General validations
        if (args.length < 1 || args.length > 6 || args.length % 2 != 0) {
            System.out.println("The maximum number of arguments is 6, you need to specify the arguments as follows:\n" +
                    "-s followed by the text to analyse, example: -s \"Hello this is tdx\"\n" +
                    "-h followed by the host\n" +
                    "-p followed by the port.");
            System.exit(0);
        }

        //Verify if the syntax is correct.
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case host:
                    if (i + 1 < args.length) {
                        hostValue = args[i + 1];
                    } else {
                        System.out.println("Incorrect use of flag -h, no host provided");
                    }
                    break;
                case sentence:
                    if (i + 1 < args.length) {
                        sentenceValue = args[i + 1];
                    } else {
                        System.out.println("Incorrect use of flag -s, no sentence provided");
                    }
                    break;
                case port:
                    if (i + 1 < args.length) {
                        portValue = args[i + 1];
                    } else {
                        System.out.println("The flag -p was used, however no port provided");
                    }
            }
        }

        try {
            URL url = new URL("http://" + hostValue + ":" + portValue + "/analyze");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");

            Sentence sentence = new Sentence();
            sentence.setSentence(sentenceValue);
            Gson gson = new Gson();

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = gson.toJson(sentence).getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
