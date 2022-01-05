package utils;

import com.google.gson.Gson;
import dtos.RenameMeDTO;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUtils {

    public static String fetchData(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }

    private static Gson gson = new Gson();

    public static RenameMeDTO fetchDataParallel() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        // Create parallel fetches here. by following the template below

        Future<RenameMeDTO> renameMeDTOFuture = es.submit(
                () -> gson.fromJson(HttpUtils.fetchData("https://api.chucknorris.io/jokes/random"),RenameMeDTO.class)

        );

        //
        RenameMeDTO renameMeDTO = renameMeDTOFuture.get();

        return renameMeDTO;
    }
}