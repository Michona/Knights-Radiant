package data.parser;

/**
 * Defines what the parser needs to do.
 *
 * @param <T> The serialized model class that the json file contains
 */
public interface JsonParser<T> {

    /**
     * Implement method to parse the json file.
     * Uses Gson and Buffered reader.
     */
    void parseJson();

    void populateWorld(JsonResult<T> result);
}
