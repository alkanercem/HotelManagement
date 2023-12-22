package BackendChallenge.HotelManagement.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import BackendChallenge.HotelManagement.business.abstracts.HotelService;
import BackendChallenge.HotelManagement.business.requests.CreateHotelRequest;
import BackendChallenge.HotelManagement.business.requests.UpdateHotelRequest;
import BackendChallenge.HotelManagement.business.responses.GetAllHotelsResponse;
import BackendChallenge.HotelManagement.business.responses.GetByIdHotelResponse;
import BackendChallenge.HotelManagement.core.utilities.mappers.ModelMapperService;
import BackendChallenge.HotelManagement.dataAccess.abstracts.HotelRepository;
import BackendChallenge.HotelManagement.entities.concretes.Hotel;


@Service
public class HotelManager implements HotelService {
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public void create(CreateHotelRequest createHotelRequest) throws IOException{
		
		Hotel hotel = this.modelMapperService.forRequest().map(createHotelRequest, Hotel.class);
		this.hotelRepository.save(hotel);			
	}

	@Override
	public void update(int hotelId,UpdateHotelRequest updateHotelRequest)throws NotFoundException {

        Hotel existingHotel = hotelRepository.findById(hotelId);

        if (existingHotel != null) {
            modelMapperService.forUpdate().map(updateHotelRequest, existingHotel);
            hotelRepository.save(existingHotel);
        } 
        else {
            throw new NotFoundException();
        }		
	}
	
	@Override
	public void delete(int hotelId) throws NotFoundException {
		
		Hotel hotel = hotelRepository.findById(hotelId);
		
		if (hotel != null)
			this.hotelRepository.deleteById(hotelId);
		
		else {
            throw new NotFoundException();
        }		
	}
	
	@Override
	public GetByIdHotelResponse getById(int id) throws NotFoundException {
		
		Hotel hotel = hotelRepository.findById(id);
		
		if (hotel != null)
			return modelMapperService.forResponse().map(hotel, GetByIdHotelResponse.class);		
		else {
            throw new NotFoundException();
        }		
	}
	
	@Override
	public List<GetAllHotelsResponse> getAll() {
		
		List<Hotel>hotels = hotelRepository.findAll();
		
		List<GetAllHotelsResponse> hotelsResponse = hotels.stream()
				.map(hotel->this.modelMapperService.forResponse()
						.map(hotel, GetAllHotelsResponse.class)).collect(Collectors.toList());

		return hotelsResponse;	
	}
}
