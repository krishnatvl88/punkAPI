package clients.getAllBeers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetBeersWrapper {

    private String first_brewed;
    private String attenuation_level;
    @JsonProperty("method")
    private Method1 method1;
    private String target_og;
    private String image_url;
    private Boil_volume boil_volume;
    private String ebc;
    private String description;
    private String target_fg;
    private String srm;
    private Volume volume;
    private String contributed_by;
    private float abv;
    private List<String> food_pairing;
    private String name;
    private String ph;
    private String tagline;
    private Ingredients ingredients;
    private String id;
    private String ibu;
    private String brewers_tips;

}
