package clients.getAllBeers.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Method1 {

    private List<Mash_temp> mash_temp;
    private Fermentation fermentation;
    private String twist;
}
