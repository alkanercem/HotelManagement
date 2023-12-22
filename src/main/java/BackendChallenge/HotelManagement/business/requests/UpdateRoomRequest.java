package BackendChallenge.HotelManagement.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomRequest {
	
	private int number;
	private int capacity;
	private double price;

}
