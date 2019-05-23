package data.models;

import com.google.gson.annotations.SerializedName;

public class ItemModel {


    @SerializedName("location")
    private String locationInWorld;

    @SerializedName("use_location")
    private String useLocation;

    @SerializedName("name")
    private String name;

    @SerializedName("usage")
    private String usageMessage;

    public String getUseLocation() {
        return useLocation;
    }

    public String getUsageMessage() {
        return usageMessage;
    }

    public String getLocationInWorld() {
        return locationInWorld;
    }

    public String getName() {
        return name;
    }
}
