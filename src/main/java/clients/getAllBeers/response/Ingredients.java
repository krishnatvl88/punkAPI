package clients.getAllBeers.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ingredients {

    private List<Hops> hops;
    private String yeast;
    private List<Malt> malt;

}
