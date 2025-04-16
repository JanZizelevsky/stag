package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.SpecializationsList;
import java.util.stream.Collectors;

public class Main7 {    
    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }
    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        SpecializationsList specializations = new Gson().fromJson(json, SpecializationsList.class);
        return specializations.items.stream()
                .map(s -> s.deadline)
                .sorted()
                .collect(Collectors.joining(","));
    }


}
