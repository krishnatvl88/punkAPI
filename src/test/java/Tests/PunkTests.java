package Tests;

import clients.getAllBeers.GetBeersClient;
import clients.getBeersBrewedByDate.GetBeersBrewedByDateClient;
import clients.getBeersByAbv.GetBeersByAbvClient;
import clients.getBeersByPage.GetBeersByPageClient;
import org.testng.annotations.Test;
import utils.Type;

import java.text.ParseException;

public class PunkTests {

    @Test(groups = {Type.SMOKE})
    public void getAllBeersList(){
        new GetBeersClient().getBeerList()
                .assertBasicInfoNotNull();
    }

    @Test(groups = {Type.REGRESSION})
    public void getBeersBrewedBeforeADate() throws ParseException {
        new GetBeersBrewedByDateClient().getBrewedByDate("11-2007")
                .assertBrewedBeforeDate("11/2007")
                .assertBasicInfoNotNull();
    }

    @Test(groups = {Type.REGRESSION})
    public void getBeersAbvGreaterThanSix() {
        new GetBeersByAbvClient().getBeersByAbv(20)
                .assertAbvGreaterThanGivenValue(20)
                .assertBasicInfoNotNull();
    }

    @Test(groups = {Type.REGRESSION})
    public void getBeersByPage() {
        new GetBeersByPageClient().getBeersbyPagination(2,5)
                .verifyPagination(5)
                .assertBasicInfoNotNull();
    }
}
