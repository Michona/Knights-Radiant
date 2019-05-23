package data.parser.items;

import com.google.gson.annotations.SerializedName;
import data.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemResult {

    @SerializedName("items")
    private List<ItemModel> models = new ArrayList<>();

    public List<ItemModel> getModels() {
        return models;
    }
}
