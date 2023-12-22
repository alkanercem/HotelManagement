package BackendChallenge.HotelManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import BackendChallenge.HotelManagement.entities.concretes.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	Hotel findById(int id);

}
