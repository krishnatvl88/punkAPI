package clients.getAllBeers;


import clients.getAllBeers.response.GetBeersResponse;
import clients.getAllBeers.response.GetBeersWrapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import properties.PunkServiceProperties;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBeersClient {

    public GetBeersResponse getBeerList(){

        String url = PunkServiceProperties.getAllBeersURL;

        Reporter.log(String.format("\nGet All Beers URL --- (GET) %s", url), true);

        Response response = given()
                .contentType(ContentType.JSON)
                .get(url);

        GetBeersWrapper[] getBeersWrappers = response.as(GetBeersWrapper[].class);
        List<GetBeersWrapper> getBeersWrapperList = Arrays.asList(getBeersWrappers);

        GetBeersResponse getBeersResponse = new GetBeersResponse();
        getBeersResponse.setWrappers(getBeersWrapperList);
        getBeersResponse.setHttpStatusCode(response.getStatusCode());

        return getBeersResponse;


    }
}
