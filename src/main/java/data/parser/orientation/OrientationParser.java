package data.parser.orientation;

import com.google.gson.Gson;
import data.models.NavModel;
import data.parser.JsonParser;
import world.WorldMap;
import util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public enum OrientationParser implements JsonParser {
    INSTANCE;

    @Override
    public void parseJson() {

        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Constants.ORIENTATION_JSON_PATH));
            NavResult result = gson.fromJson(br, NavResult.class);
            if (result != null) {
                populateWorldMap(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void populateWorldMap(NavResult result) {

        for (NavModel model : result.getModels()) {

            WorldMap.INSTANCE.addNavModelToMap(
                    model.getLocation(),
                    model);

            System.out.println(model.getLocation());
        }
    }
}
