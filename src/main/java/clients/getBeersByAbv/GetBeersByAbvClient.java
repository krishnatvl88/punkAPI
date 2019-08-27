package clients.getBeersByAbv;

import clients.getAllBeers.response.GetBeersResponse;
import clients.getAllBeers.response.GetBeersWrapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import properties.PunkServiceProperties;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBeersByAbvClient {

    public GetBeersResponse getBeersByAbv(int abv) {
        String url = String.format("%s?abv_gt={abv}", PunkServiceProperties.getAllBeersURL);

        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("abv", abv)
                .get(url);

        GetBeersWrapper[] getBeersWrappers = response.as(GetBeersWrapper[].class);
        List<GetBeersWrapper> getBeersWrapperList = Arrays.asList(getBeersWrappers);

        GetBeersResponse getBeersResponse = new GetBeersResponse();
        getBeersResponse.setWrappers(getBeersWrapperList);
        getBeersResponse.setHttpStatusCode(response.getStatusCode());

        return getBeersResponse;
    }
}
