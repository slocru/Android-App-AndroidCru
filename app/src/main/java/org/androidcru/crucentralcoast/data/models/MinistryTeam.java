package org.androidcru.crucentralcoast.data.models;

import com.google.gson.annotations.SerializedName;

public class MinistryTeam
{
    @SerializedName("_id") public String mId;
    @SerializedName("image") public CruImage cruImage;
    @SerializedName("teamImage") public CruImage teamImage;
    @SerializedName("description") public String description;
    @SerializedName("name") public String name;
    @SerializedName("parentMinistry") public String mParentMinistryId;

    public MinistryTeam() {}

    public MinistryTeam(String id, CruImage image, CruImage teamImage, String name, String description, String parentMinistryId)
    {
        this.mId = id;
        this.cruImage = image;
        this.teamImage = teamImage;
        this.description = description;
        this.name = name;
        this.mParentMinistryId = parentMinistryId;
    }
}
