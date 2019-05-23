package data.parser.orientation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.models.NavModel;
import data.parser.JsonParser;
import data.parser.JsonResult;
import world.WorldMap;
import util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public enum OrientationParser implements JsonParser<NavModel> {
    INSTANCE;

    @Override
    public void parseJson() {

        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Constants.ORIENTATION_JSON_PATH));

            Type collectionType = new TypeToken<JsonResult<NavModel>>(){}.getType();
            JsonResult<NavModel> result = gson.fromJson(br, collectionType);
            if (result != null) {
                populateWorld(result);
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

    /**
     * Adds the NavModels to a HashMap in the WorldMap Instance.
     * @param result Object that hold the list of NavModels from the json file
     */
    @Override
    public void populateWorld(JsonResult<NavModel> result) {

        for (NavModel model : result.getModels()) {

            WorldMap.INSTANCE.addNavModelToMap(
                    model.getLocation(),
                    model);
        }
    }
}
