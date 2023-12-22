package BackendChallenge.HotelManagement.business.abstracts;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import BackendChallenge.HotelManagement.business.requests.CreateRoomRequest;
import BackendChallenge.HotelManagement.business.requests.UpdateRoomRequest;
import BackendChallenge.HotelManagement.business.responses.GetAllRoomsResponse;
import BackendChallenge.HotelManagement.business.responses.GetByIdRoomResponse;

public interface RoomService {
	
	void create(CreateRoomRequest createRoomRequest) throws NotFoundException;
	void update(int roomId, UpdateRoomRequest updateRoomRequest)throws NotFoundException;
	void delete(int id) throws NotFoundException;
	List<GetAllRoomsResponse> getAll();
	GetByIdRoomResponse getById(int id) throws NotFoundException;

}
