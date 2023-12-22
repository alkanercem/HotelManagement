package BackendChallenge.HotelManagement.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="hotel")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
    private List<Room> rooms;

}
