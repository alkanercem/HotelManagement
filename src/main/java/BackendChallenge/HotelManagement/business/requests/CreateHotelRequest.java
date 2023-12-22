package BackendChallenge.HotelManagement.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHotelRequest {
	
	private String name;
	private String location;
	private double rating;
	private String description;

}
