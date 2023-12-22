package BackendChallenge.HotelManagement.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdRoomResponse {
	
	private int id;
	private int number;
	private int capacity;
	private double price;
	
	private String name;
	private double rating;

}
