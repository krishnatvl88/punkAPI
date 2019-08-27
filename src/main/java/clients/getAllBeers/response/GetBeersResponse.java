package clients.getAllBeers.response;

import clients.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import utils.DateHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

@Getter
@Setter
public class GetBeersResponse extends BaseResponse{

    @JsonProperty("GetBeersWrapper")
    private List<GetBeersWrapper> wrappers;

    public GetBeersResponse assertBasicInfoNotNull() {

       assertEquals(getHttpStatusCode(), 200);
//       List<GetBeersWrapper> wrapperResult = wrappers.stream().filter(wrapper1 -> wrapper1.getId() != null)
//                                                        .filter(wrapper1 -> wrapper1.getName() != null)
//                                                        .filter(wrapper1 -> wrapper1.getDescription() != null)
//                                                        .filter(wrapper1 -> wrapper1.getAbv() != null)
//                                                        .collect(Collectors.toList());
        Assert.assertNotNull(wrappers.stream().map(GetBeersWrapper::getId));
        Assert.assertNotNull(wrappers.stream().map(GetBeersWrapper::getName));
        Assert.assertNotNull(wrappers.stream().map(GetBeersWrapper::getDescription));
        Assert.assertNotNull(wrappers.stream().map(GetBeersWrapper::getAbv));

        return this;
    }

    public GetBeersResponse assertBrewedBeforeDate(String beforeDate) throws ParseException {

        DateFormat format = new SimpleDateFormat("MM/yyyy");
        Date sdf = format.parse(beforeDate);
        List<String> datesStringList = wrappers.stream().map(GetBeersWrapper::getFirst_brewed).collect(Collectors.toList());
        List<Date> dateList = DateHelper.getDateList(datesStringList);
        dateList.stream()
                .filter(dates -> dates.before(sdf))
                .collect(Collectors.toList())
                .forEach(jDate->System.out.println(new SimpleDateFormat("MM/yyyy").format(jDate)));

        return this;
    }

    public GetBeersResponse assertAbvGreaterThanGivenValue(int abv){

       // List<Float> abvList = wrappers.stream().map(GetBeersWrapper::getAbv).collect(Collectors.toList());
        List<GetBeersWrapper> abvVal = wrappers.stream().filter(wrapper1 -> wrapper1.getAbv() > abv).collect(Collectors.toList());

        return this;
    }

    public GetBeersResponse verifyPagination(int perPage) {
        int size = wrappers.size();
        Assert.assertEquals(size, perPage);
        return this;
    }

}
