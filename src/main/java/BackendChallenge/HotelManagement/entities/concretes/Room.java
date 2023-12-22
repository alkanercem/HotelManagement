package BackendChallenge.HotelManagement.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="room")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@Column(name="number")
    private int number;
	
	@Column(name="capacity")
    private int capacity;
	
	@Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    
}
