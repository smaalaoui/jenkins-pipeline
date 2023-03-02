package m2i.formation.utils;

import m2i.formation.Hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtilsTest {

    @Test
    public
    void
    GIVEN_list_with_2_elements_WHEN_calculateSize_THEN_should_return_2() {
        // GIVEN
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel());
        hotels.add(new Hotel());

        // WHEN
        Integer result = CollectionUtils.calculateSize(hotels);

        // THEN
        Assertions.assertEquals(2, result);
    }

}
