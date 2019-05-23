package data.parser;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic class made to simplify the json parsing.
 * Contains a list of the models in the json file.
 *
 * @param <T> The serialized model class that the json file contains
 */
public class JsonResult<T> {

    @SerializedName("models")
    private List<T> models = new ArrayList<>();

    public List<T> getModels() {
        return models;
    }
}

