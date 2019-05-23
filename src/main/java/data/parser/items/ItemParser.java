package data.parser.items;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.models.ItemModel;
import data.models.NavModel;
import data.parser.JsonParser;
import data.parser.JsonResult;
import world.WorldItems;
import util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public enum ItemParser implements JsonParser<ItemModel> {
    INSTANCE;

    @Override
    public void parseJson() {

        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Constants.ITEMS_JSON_PATH));

            Type collectionType = new TypeToken<JsonResult<ItemModel>>(){}.getType();
            JsonResult<ItemModel> result = gson.fromJson(br, collectionType);
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
     * Adds ItemModels to a list in the WorldItems Instance.
     * @param result Object that holds the list of ItemModels from the json file
     */
    @Override
    public void populateWorld(JsonResult<ItemModel> result) {

        for (ItemModel model : result.getModels()) {

            WorldItems.INSTANCE.addItemToWorld(model);
        }
    }
}
