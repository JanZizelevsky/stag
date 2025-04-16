package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.SpecializationsList;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main7 {    
    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }
    
    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        SpecializationsList specializations = new Gson().fromJson(json, SpecializationsList.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return specializations.items.stream()
            .map(s -> s.deadline.value)
            .distinct()
            .map(date -> LocalDate.parse(date, formatter))
            .sorted()
            .map(date -> date.format(formatter))
            .collect(Collectors.joining(","));
    }
}
