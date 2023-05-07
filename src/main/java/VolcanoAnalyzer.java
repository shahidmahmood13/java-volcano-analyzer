import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;


import javax.xml.bind.ValidationEvent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class VolcanoAnalyzer {
    private static final double Double = 0;
    private static List<Volcano> volcanos;

    public void loadVolcanoes(Optional<String> pathOpt) throws IOException, URISyntaxException {
        try{
            String path = pathOpt.orElse("volcano.json");
            URL url = this.getClass().getClassLoader().getResource(path);
            String jsonString = new String(Files.readAllBytes(Paths.get(url.toURI())));
            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            volcanos = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Volcano.class));
        } catch(Exception e){
            throw(e);
        }
    }

    public Integer numbVolcanoes(){
        return   volcanos.size();
    }

    //add methods here to meet the requirements in README.md

     public List<Volcano>   eruptedInEighties() {
        
        return volcanos.stream()
    .filter(v -> v.getYear()  >= 1980 && v.getYear() < 1990 )
    .collect(Collectors.toList());
  
} 

public String[] highVEI() {

    return volcanos.stream().filter(v-> v.getVEI() >=6).map(Volcano :: getName).toArray(String[]:: new);

}

// public Volcano mostDeadly(){
 

//     // return volcanos.stream().max(Comparator.comparing(Volcano :: getDEATHS)).orElse(null);
// //   return  volcanos.stream().reduce((obj1, obj2) -> \.getDEATHS() > obj2.getDEATHS() ? obj1 : obj2)
// //   .orElse(null);
//   return  Collections.max(volcanos, Comparator.comparing( Volcano::getDEATHS));

// }


public  float  causedTsunami(){

float value= volcanos.stream().filter(v-> v.getTsu().equals("tsu")).count();
// System.out.println(value);
 return  value / volcanos.size()*100;
 

}

public String  mostCommonType(){
  
 volcanos.stream().collect(Collectors.groupingBy(Volcano :: getType, Collectors.counting())); 

return null; 
}

public Long  eruptionsByCountry(String Country){
 
    return volcanos.stream().filter( v-> v.getCountry().equalsIgnoreCase(Country)).count();
}



public Double averageElevation(){

    return volcanos.stream().mapToDouble(Volcano :: getElevation).average().orElse(Double);
}


public String[] volcanoTypes() {
    return volcanos.stream().map( Volcano :: getType).distinct().toArray(String[]:: new); 
}

public Double percentNorth() {
 double value =  volcanos.stream().filter(v-> v.getLatitude() > 0).count();

 return  value / volcanos.size()*100; 
}

public String[] manyFilters() {

  return volcanos.stream().filter(v-> v.getYear() > 1800)
  .filter( v-> v.getTsu().equals(""))
  .filter( v-> v.getLatitude() < 0)
  .filter(v-> v.getVEI() == 5).map( Volcano :: getName).toArray(String[]:: new);


}

public String[] loadVolcanoes(int i) {
    return volcanos.stream().filter(v-> v.getElevation() > i).map( Volcano :: getName).toArray(String[]:: new);
}

public String[] topAgentsOfDeath() {
    return null;
} 


                          


// public static void main(String[] args) {
//     // List<Volcano> volcanos;
//     Volcano vol= volcanos.stream().max(Comparator.comparing( Volcano :: getDEATHS)).orElse(null);
     
//     System.out.println(vol);
// }


}

