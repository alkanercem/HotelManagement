package BackendChallenge.HotelManagement.business.responses;

import java.util.List;

import BackendChallenge.HotelManagement.entities.concretes.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdHotelResponse {
	
	private int id;
	private String name;
	private String location;
	private double rating;
	private String description;
    private List<Room> rooms;

}
