package beacon;

import beacon.entity.Beacon;
import beacon.entity.Room;
import beacon.repository.BeaconRepository;
import beacon.repository.EventRepository;
import beacon.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> rooms() {
        List<Room> rooms = new ArrayList<Room>();

        Page<Room> page = roomRepository.findAll(new PageRequest(0,20));
        for (Room r: page.getContent()) {
            r.setEvents(eventRepository.findEventsByRoomid(r.getId()));
            rooms.add(r);
        }

        return rooms;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/")
    public List<Room> getRoom(@PathVariable("id") Long id) {
        List<Room> rooms = new ArrayList<Room>();

        Room r = roomRepository.findOne(id);
        r.setEvents(eventRepository.findEventsByRoomid(r.getId()));
        rooms.add(r);

        return rooms;
    }


    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json")
    public List<Room> createRoom(@RequestBody Room room) {
        List<Room> list = new ArrayList<Room>();
        list.add(roomRepository.save(room));
        return list;
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/{id}/",
            consumes = "application/json")
    public List<Room> updateRoom(@PathVariable("id") Long id, @RequestBody Room room) {
        List<Room> list = new ArrayList<Room>();
        Room dmRoom = roomRepository.findOne(id);
        dmRoom.copyRoom(room);
        list.add(roomRepository.save(dmRoom));
        return list;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}/picture/")
    public HttpEntity<byte[]> getRoomPicture(@PathVariable("id") Long id) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        httpHeaders.setContentDispositionFormData("attachment", "picture");

        return new ResponseEntity<byte[]>(roomRepository.findOne(id).getPicture(), httpHeaders, HttpStatus.OK);
    }

}
