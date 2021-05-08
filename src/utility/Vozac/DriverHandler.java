package utility.Vozac;

import entiteti.Korisnik;
import entiteti.Vozac;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import strukture.Par;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DriverHandler {
    public static ArrayList<Par<Integer, Integer>> osveziVozace(ArrayList<Korisnik> vozaci, String unesenaAdresa) throws JSONException,
            IOException {
        String apiKey = "AIzaSyAP1ILAhEyPnYCXt4EDQfnlTr-Dm5riBnw";
        ArrayList<String> adrese = new ArrayList<>();

        ucitajAdrese(adrese);
        dodeliRandomAdrese(vozaci, adrese);

        String korisnikAdresa = adressToPlaceId(unesenaAdresa);
        ArrayList<Par<Integer, Integer>> osvezeniVozaci = new ArrayList<>();

        for(Korisnik korisnik : vozaci) {
            if (korisnik instanceof Vozac) {
                Vozac vozac = (Vozac) korisnik;
                izracunajVreme(apiKey, korisnikAdresa, osvezeniVozaci, vozac);
            }
        }
        return osvezeniVozaci;
    }

    private static void dodeliRandomAdrese(ArrayList<Korisnik> vozaci, ArrayList<String> adrese) {
        for(Korisnik korisnik : vozaci) {
            if (korisnik instanceof Vozac) {
                Vozac vozac = (Vozac) korisnik;
                vozac.setLokacija(adrese.get((int) (Math.random() * 12)));
            }
        }
    }

    private static String adressToPlaceId(String unesenaAdresa) throws IOException, JSONException {
        String unesenaAdresaFixed = unesenaAdresa.replace(' ', '+') + ",+Novi+Sad,+Serbia";
        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + unesenaAdresaFixed +
                "&key=AIzaSyAP1ILAhEyPnYCXt4EDQfnlTr-Dm5riBnw");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String line, outputString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) { outputString += line; }
        conn.disconnect();
        JSONObject obj = new JSONObject(outputString);
        JSONArray results = obj.getJSONArray("results");

        return results.getJSONObject(0).getString("place_id");
    }

    private static void ucitajAdrese(ArrayList<String> adrese) {
        try {
            File file = new File("src/txtPodaci/adrese.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String adresa;
            while ((adresa = reader.readLine()) != null) {
                adrese.add(adresa);
            }
            reader.close();

        }catch(IOException e) {
            System.out.println("Greska! Nije moguce procitati sadrzaj fajla");
        }
    }

    //vraca (vreme, brKarte)
    private static void izracunajVreme(String apiKey, String korisnikAdresa, ArrayList<Par<Integer, Integer>> osvezeniVozaci, Vozac vozac) throws IOException,
            JSONException {
        String tempLokacija = vozac.getLokacija();
        URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins=place_id:" + korisnikAdresa +
                        "&destinations=place_id:" + tempLokacija + "&key=" + apiKey);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String line, outputString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) { outputString += line; }
        conn.disconnect();
        JSONObject obj = new JSONObject(outputString);
        JSONObject rows = obj.getJSONArray("rows").getJSONObject(0);
        JSONArray elements = rows.getJSONArray("elements");
        String time = elements.getJSONObject(0).getJSONObject("duration").getString("text");
        int timeFixed = Integer.parseInt(time.replaceAll("([a-z])", "").trim());
        Par<Integer, Integer> nesto = new Par<>(timeFixed, vozac.getBrKarte());
        osvezeniVozaci.add(nesto); //automatski
    }
}