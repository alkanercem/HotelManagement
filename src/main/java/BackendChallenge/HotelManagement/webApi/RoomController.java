package BackendChallenge.HotelManagement.webApi;

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

import BackendChallenge.HotelManagement.business.abstracts.RoomService;
import BackendChallenge.HotelManagement.business.requests.CreateRoomRequest;
import BackendChallenge.HotelManagement.business.requests.UpdateRoomRequest;
import BackendChallenge.HotelManagement.business.responses.GetAllRoomsResponse;
import BackendChallenge.HotelManagement.business.responses.GetByIdRoomResponse;


@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired 
	private RoomService roomService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createRoom(@RequestBody CreateRoomRequest createRoomRequest) throws NotFoundException{
		this.roomService.create(createRoomRequest);
	    return ResponseEntity.ok("Room created");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRoom(@PathVariable int id, @RequestBody UpdateRoomRequest updateRoomRequest) throws NotFoundException {
		this.roomService.update(id,updateRoomRequest);
	    return ResponseEntity.ok("Room updated");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable int id) throws NotFoundException {
	    roomService.delete(id);
		return ResponseEntity.ok("Room deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetByIdRoomResponse> getHotel(@PathVariable int id) throws NotFoundException {
		GetByIdRoomResponse room = this.roomService.getById(id);
	    return ResponseEntity.ok(room);
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<GetAllRoomsResponse>> getAllRooms() throws NotFoundException {
	    List<GetAllRoomsResponse> roomResponses = roomService.getAll();
	    return ResponseEntity.ok(roomResponses);
	}
	
	
}