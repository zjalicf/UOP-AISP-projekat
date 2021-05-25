//package utility;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import strukture.Par;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class MapsCalc {
//        public static Par<String, String> proba() throws IOException, JSONException {
//            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins=" +
//                    "place_id:EidWb2p2b8SRYW5za2loIGJyaWdhZGEsIE5vdmkgU2FkLCBTZXJiaWEiLiosChQKEgnZuNCGaxBbRxFhZCd4" +
//                    "ufM_" + "RBIUChIJVTTpPWEQW0cRKP4kN2h9bws&destinations=place_id:ChIJM_fE1mYQW0cRA3ReiVkHSTY&ke" +
//                    "y=AIzaSyAP1ILAhEyPnYCXt4EDQfnlTr-Dm5riBnw");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            String line, outputString = "";
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            while ((line = reader.readLine()) != null) { outputString += line; }
//            JSONObject obj = new JSONObject(outputString);
//            JSONObject rows = obj.getJSONArray("rows").getJSONObject(0);
//            JSONArray elements = rows.getJSONArray("elements");
//            String distance = elements.getJSONObject(0).getJSONObject("distance").getString("text");
//            String time = elements.getJSONObject(0).getJSONObject("duration").getString("text");
//
//            return new Par<>(distance, time);
//        }
//}
