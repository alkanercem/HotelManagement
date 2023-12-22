package BackendChallenge.HotelManagement.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import BackendChallenge.HotelManagement.business.abstracts.RoomService;
import BackendChallenge.HotelManagement.business.requests.CreateRoomRequest;
import BackendChallenge.HotelManagement.business.requests.UpdateRoomRequest;
import BackendChallenge.HotelManagement.business.responses.GetAllRoomsResponse;
import BackendChallenge.HotelManagement.business.responses.GetByIdRoomResponse;
import BackendChallenge.HotelManagement.core.utilities.mappers.ModelMapperService;
import BackendChallenge.HotelManagement.dataAccess.abstracts.HotelRepository;
import BackendChallenge.HotelManagement.dataAccess.abstracts.RoomRepository;
import BackendChallenge.HotelManagement.entities.concretes.Hotel;
import BackendChallenge.HotelManagement.entities.concretes.Room;

@Service
public class RoomManager implements RoomService {
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public void create(CreateRoomRequest createRoomRequest) throws NotFoundException{
		
		Hotel hotel = hotelRepository.getById(createRoomRequest.getHotelId());
		
		if (hotel != null) {
			Room room = this.modelMapperService.forRequest().map(createRoomRequest, Room.class);
	        room.setHotel(hotel);
	        roomRepository.save(room);
	        hotel.getRooms().add(room);
	    } 
		else {
	            throw new NotFoundException();
	        }		
		}
		   

	@Override
	public void update(int id, UpdateRoomRequest updateRoomRequest)throws NotFoundException {

        Room existingRoom = roomRepository.findById(id);

        if (existingRoom != null) {
            modelMapperService.forUpdate().map(updateRoomRequest, existingRoom);
            roomRepository.save(existingRoom);
        } 
        else {
            throw new NotFoundException();
        }		
	}
	
	@Override
	public void delete(int id) throws NotFoundException {
		
		Room deleteRoom = roomRepository.findById(id);
		
		if (deleteRoom != null)
			this.roomRepository.deleteById(id);
		
		else {
            throw new NotFoundException();
        }		
	}
	
	@Override
	public GetByIdRoomResponse getById(int id) throws NotFoundException {
		
		Room room = roomRepository.findById(id);
		
		if (room != null)
			return modelMapperService.forResponse().map(room, GetByIdRoomResponse.class);
		else {
            throw new NotFoundException();
        }		
	}
	
	@Override
	public List<GetAllRoomsResponse> getAll() {
		
		List<Room>rooms = roomRepository.findAll();
		
		List<GetAllRoomsResponse> roomsResponse = rooms.stream()
				.map(room->this.modelMapperService.forResponse()
						.map(room, GetAllRoomsResponse.class)).collect(Collectors.toList());

		return roomsResponse;	
	}
}

