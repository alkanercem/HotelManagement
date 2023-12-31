# Hotel Management

Hotel Management is a CRUD (Create, Read, Update, Delete) application developed using Spring Boot. This application includes RESTful APIs to manage basic operations related to hotels and rooms. It also uses PostgreSQL database for data storage.

## Key Features

- Create, update, and delete hotels.
- Create, update, and delete rooms to hotel (ORM).
- View detailed information for each hotel and room.
- List all hotels and rooms.
  
## Dependencies Used 

- **Spring Boot Starter Data JPA**  

- **Spring Boot Starter Validation**  

- **Spring Boot Starter Web**  

- **Spring Boot DevTools**  

- **PostgreSQL Driver**  

- **Project Lombok**  

- **Spring Boot Starter Test**  

- **ModelMapper**  

- **Springdoc OpenAPI**  

 

## ER Diagram 
 [![](https://www.resimupload.org/images/2023/12/22/Untitled-1.png)](https://www.resimupload.org/images/2023/12/22/Untitled-1.png))
 

## Installation 

- **Clone the Repository** 

- **Set Database Configuration** 

- **Build the Project**  

- **Run the Application**


# Hotel Controller

The `HotelController` represents a RESTful API managing hotel operations.

## Endpoints

1. **Create Hotel**

   - **Endpoint:** POST /hotel/create
   - **Description:** Creates a new hotel.
   - **Request Body:** CreateHotelRequest
   - **Success Response:** 200 OK, Hotel created.

2. **Update Hotel**

   - **Endpoint:** PUT /hotel/update/{id}
   - **Description:** Updates an existing hotel.
   - **Request Body:** UpdateHotelRequest
   - **Success Response:** 200 OK, Hotel updated.

3. **Delete Hotel**

   - **Endpoint:** DELETE /hotel/delete/{id}
   - **Description:** Deletes a hotel with the specified ID.
   - **Success Response:** 200 OK, Hotel deleted.

4. **Get Hotel**

   - **Endpoint:** GET /hotel/{id}
   - **Description:** Retrieves information about a hotel with the specified ID.
   - **Success Response:** 200 OK, Hotel details.

5. **List All Hotels**

   - **Endpoint:** GET /hotel/listAll
   - **Description:** Lists all hotels.
   - **Success Response:** 200 OK, List of hotels.

# Room Controller

The `RoomController` represents a RESTful API managing room operations.

## Endpoints

1. **Create Room**

   - **Endpoint:** POST /room/create
   - **Description:** Creates a new room.
   - **Request Body:** CreateRoomRequest
   - **Success Response:** 200 OK, Room created.

2. **Update Room**

   - **Endpoint:** PUT /room/update/{id}
   - **Description:** Updates an existing room.
   - **Request Body:** UpdateRoomRequest
   - **Success Response:** 200 OK, Room updated.

3. **Delete Room**

   - **Endpoint:** DELETE /room/delete/{id}
   - **Description:** Deletes a room with the specified ID.
   - **Success Response:** 200 OK, Room deleted.

4. **Get Room**

   - **Endpoint:** GET /room/{id}
   - **Description:** Retrieves information about a room with the specified ID.
   - **Success Response:** 200 OK, Room details.

5. **List All Rooms**

   - **Endpoint:** GET /room/listAll
   - **Description:** Lists all rooms.
   - **Success Response:** 200 OK, List of rooms.

## Swagger

For detailed information about request and response payloads, you can use Swagger.

- **Swagger UI URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
