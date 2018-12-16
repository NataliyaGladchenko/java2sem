import by.gsu.pms.Clients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Runner {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().create();
        try(Reader reader = new FileReader("src//main//java//clients.json")) {
            Clients[] clientsList = (gson.fromJson(reader, Clients[].class));
            for (Clients client : clientsList) {
                System.out.println(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
