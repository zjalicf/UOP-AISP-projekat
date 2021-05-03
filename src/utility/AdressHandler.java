package utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdressHandler {

    public static String adressToPlaceId(String unesenaAdresa) throws IOException, JSONException {
        String unesenaAdresaFixed = unesenaAdresa.replace(' ', '+') + ",+Novi+Sad,+Serbia";
        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + unesenaAdresaFixed +
                "&key=AIzaSyAP1ILAhEyPnYCXt4EDQfnlTr-Dm5riBnw");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String line, outputString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) { outputString += line; }
        JSONObject obj = new JSONObject(outputString);
        JSONArray results = obj.getJSONArray("results");
        return results.getJSONObject(0).getString("place_id");
    }
}
