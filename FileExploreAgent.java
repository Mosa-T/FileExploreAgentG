import java.io.*;
import java.net.*;
import java.util.Base64;
import java.util.Scanner;

public class FileExploreAgent {



    public static void main(String[] args){



        try {






        URL myURL = new URL("http://localhost:8080/job/FileExplorer/buildWithParameters");
        String user = "Heyhey"; // username
            String pass = "115072a888c151f50f6e01cee3f1d0ea1b"; // password or API token
            String authStr = user + ":" + pass;
            String encoding = Base64.getEncoder().encodeToString(authStr.getBytes("utf-8"));
            System.out.println("1");
            HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            System.out.println("2");
            String urlParams = "Hostname=Explorer_Agent1&dir=D:/study/logic";
            byte[] postData = urlParams.getBytes("utf-8");
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            System.out.println("3");
            //InputStream content = connection.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(content));
            //String line;
            //while ((line = in.readLine()) != null) {
            //    System.out.println(line);
            //}
        }
        catch (IOException e) {
            System.out.println(e);
            // openConnection() failed
            // ...
        }
    }
}
