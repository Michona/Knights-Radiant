package data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Contains information about directions.
 */
public class DirectionModel {

    @SerializedName("north")
    private String toNorth;

    @SerializedName("south")
    private String toSouth;

    @SerializedName("east")
    private String toEast;

    @SerializedName("west")
    private String toWest;

    public String getToNorth() {
        return toNorth;
    }

    public void setToNorth(String toNorth) {
        this.toNorth = toNorth;
    }

    public String getToSouth() {
        return toSouth;
    }

    public void setToSouth(String toSouth) {
        this.toSouth = toSouth;
    }

    public String getToEast() {
        return toEast;
    }

    public void setToEast(String toEast) {
        this.toEast = toEast;
    }

    public String getToWest() {
        return toWest;
    }

    public void setToWest(String toWest) {
        this.toWest = toWest;
    }
}
