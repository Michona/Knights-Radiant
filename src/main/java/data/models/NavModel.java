package data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Contains information about the grid point.
 * Drives the main story.
 */
public class NavModel {

    @SerializedName("location")
    private String location;

    @SerializedName("story")
    private String story;

    @SerializedName("direction")
    private DirectionModel directionInfo;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DirectionModel getDirectionInfo() {
        return directionInfo;
    }

    public void setDirectionInfo(DirectionModel directionInfo) {
        this.directionInfo = directionInfo;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
