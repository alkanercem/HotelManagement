package BackendChallenge.HotelManagement.webApi;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendChallenge.HotelManagement.business.abstracts.HotelService;
import BackendChallenge.HotelManagement.business.requests.CreateHotelRequest;
import BackendChallenge.HotelManagement.business.requests.UpdateHotelRequest;
import BackendChallenge.HotelManagement.business.responses.GetAllHotelsResponse;
import BackendChallenge.HotelManagement.business.responses.GetByIdHotelResponse;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired 
	private HotelService hotelService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createHotel(@RequestBody CreateHotelRequest createHotelRequest) throws IOException{
		this.hotelService.create(createHotelRequest);
	    return ResponseEntity.ok("Hotel created");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateHotel(@PathVariable int id, @RequestBody UpdateHotelRequest updateHotelRequest) throws NotFoundException {
		this.hotelService.update(id,updateHotelRequest);
	    return ResponseEntity.ok("Hotel updated");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable int id) throws NotFoundException {
	    hotelService.delete(id);
		return ResponseEntity.ok("Hotel deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetByIdHotelResponse> getHotel(@PathVariable int id) throws NotFoundException {
		GetByIdHotelResponse hotel = this.hotelService.getById(id);
	    return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<GetAllHotelsResponse>> getAllHotels() throws NotFoundException {
	    List<GetAllHotelsResponse> hotelResponses = hotelService.getAll();
	    return ResponseEntity.ok(hotelResponses);
	}
	
}
	
