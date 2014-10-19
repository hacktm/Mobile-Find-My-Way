package beacon;

import beacon.entity.Event;
import beacon.entity.Room;
import beacon.repository.EventRepository;
import beacon.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> events() {
        return eventRepository.findAll(new PageRequest(0,20)).getContent();
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json")
    public List<Event> createEvent(@RequestBody Event event) {
        List<Event> list = new ArrayList<Event>();
        list.add(eventRepository.save(event));
        return list;
    }
}
