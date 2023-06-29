package reqres;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResourcesData {

    private int id;
    private String name;
    private int year;
    private String color;
    @SerializedName("pantone_value")
    private String pantoneValue;
}
