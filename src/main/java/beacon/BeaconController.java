package beacon;

import beacon.entity.Beacon;
import beacon.entity.ImportExport;
import beacon.entity.User;
import beacon.entity.UserJson;
import beacon.repository.BeaconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/beacon")
public class BeaconController {

    @Autowired
    BeaconRepository beaconRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Beacon> beacons() {
        Page<Beacon> page = beaconRepository.findAll(new PageRequest(0,20));
        return page.getContent();
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json")
    public List<Beacon> createBeacon(@RequestBody Beacon beacon) {
        List<Beacon> list = new ArrayList<Beacon>();
        list.add(beaconRepository.save(beacon));
        return list;
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/{id}/",
            consumes = "application/json")
    public List<Beacon> updateBeacon(@PathVariable("id") Long id, @RequestBody Beacon beacon) {
        List<Beacon> list = new ArrayList<Beacon>();
        Beacon dbBeacon = beaconRepository.findOne(id);
        dbBeacon.copyBeacon(beacon);
        list.add(beaconRepository.save(dbBeacon));
        return list;
    }

}
