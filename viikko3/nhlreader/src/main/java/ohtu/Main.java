package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        Arrays.asList(players)
                .stream()
                .filter(e -> e.getNationality().equals("FIN"))
                .sorted((e1, e2) -> e2.getPoints() - e1.getPoints())
                .forEach(e -> System.out.printf(
                        "%-22s %-3s %5d%n",
                        e.getName(),
                        e.getTeam(),
                        e.getPoints())
                );
        
//        System.out.println("Oliot:");
//        for (Player player : players) {
//            System.out.println(player);
//        }   
    }
  
}