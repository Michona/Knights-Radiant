package data.parser.items;

import com.google.gson.Gson;
import data.models.ItemModel;
import data.parser.JsonParser;
import world.WorldItems;
import util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public enum ItemParser implements JsonParser {
    INSTANCE;


    @Override
    public void parseJson() {

        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Constants.ITEMS_JSON_PATH));
            ItemResult result = gson.fromJson(br, ItemResult.class);
            if (result != null) {
                fillWorldItems(result);
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

    private void fillWorldItems(ItemResult result) {

        for (ItemModel model : result.getModels()) {

            WorldItems.INSTANCE.addItemToWorld(model);

            System.out.println(model.getName());
        }
    }
}
