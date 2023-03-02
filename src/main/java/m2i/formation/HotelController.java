package m2i.formation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hotels")
public class HotelController {


    private List<Hotel> hotels= new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getHotels() {
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        hotels.add(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

}
