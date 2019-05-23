package data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Represents Item.
 * locationInWorld is where the item can be picked up.
 * useLocation is where the item can be used.
 */
public class ItemModel {

    @SerializedName("location")
    private String locationInWorld;

    @SerializedName("use_location")
    private String useLocation;

    @SerializedName("name")
    private String name;

    @SerializedName("usage")
    private String usageMessage;

    public void setLocationInWorld(String locationInWorld) {
        this.locationInWorld = locationInWorld;
    }

    public void setUseLocation(String useLocation) {
        this.useLocation = useLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsageMessage(String usageMessage) {
        this.usageMessage = usageMessage;
    }

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
