package BackendChallenge.HotelManagement.business.responses;

import BackendChallenge.HotelManagement.entities.concretes.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRoomsResponse {
	
	private int id;
	private int number;
	private int capacity;
	private double price;
	
	private String name;
	private double rating;

}
