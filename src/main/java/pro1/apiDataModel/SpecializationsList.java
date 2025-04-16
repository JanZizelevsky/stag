package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SpecializationsList {
    @SerializedName("prijimaciObory")
    public List<Specialization> items;
} 