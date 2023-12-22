package BackendChallenge.HotelManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import BackendChallenge.HotelManagement.entities.concretes.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	Room findById(int id);

}
