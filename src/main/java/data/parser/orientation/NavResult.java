package data.parser.orientation;

import com.google.gson.annotations.SerializedName;
import data.models.NavModel;

import java.util.ArrayList;
import java.util.List;

public class NavResult {

    @SerializedName("models")
    private List<NavModel> models = new ArrayList<NavModel>();


    public List<NavModel> getModels() {
        return models;
    }
}
