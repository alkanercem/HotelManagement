package BackendChallenge.HotelManagement.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import BackendChallenge.HotelManagement.business.requests.CreateHotelRequest;
import BackendChallenge.HotelManagement.business.requests.UpdateHotelRequest;
import BackendChallenge.HotelManagement.business.responses.GetAllHotelsResponse;
import BackendChallenge.HotelManagement.business.responses.GetByIdHotelResponse;

public interface HotelService {
	
	void create(CreateHotelRequest createHotelRequest)throws IOException;
	void update(int hotelId, UpdateHotelRequest updateHotelRequest)throws NotFoundException;
	void delete(int id) throws NotFoundException;
	List<GetAllHotelsResponse> getAll();
	GetByIdHotelResponse getById(int id)throws NotFoundException;

}
