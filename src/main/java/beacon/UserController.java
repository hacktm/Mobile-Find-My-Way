package beacon;

import beacon.entity.ImportExport;
import beacon.entity.User;
import beacon.entity.UserJson;
import beacon.repository.BeaconRepository;
import beacon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public List<User> users() {
        Page<User> page = userRepository.findAll(new PageRequest(0,20));
        return page.getContent();
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = "multipart/form-data")
    public List<User> createUser(@RequestParam(value = "picture", required = false) MultipartFile file,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("userFunction") String userFunction,
                           @RequestParam("description") String description
                           ) {
        List<User> list = new ArrayList<User>();

        User user = new User(firstName, lastName, userFunction, description);
        try {
            user.setPicture(file.getBytes());
        } catch (IOException ex) {
            throw new RestClientException("bad file upload");
        }
        list.add(userRepository.save(user));
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/",
            consumes = { "application/json" })
    public List<User> updateUser(@PathVariable("id") Long id, @RequestBody UserJson jsonUser) {
        List<User> list = new ArrayList<User>();
        User user = userRepository.findOne(id);
        if (user==null) {
            return createJsonUser(jsonUser);
        }
        user.copyOver(jsonUser);
        list.add(userRepository.save(user));
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/picture/")
    public HttpEntity<byte[]> getUserPicture(@PathVariable("id") Long id) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        httpHeaders.setContentDispositionFormData("attachment", "picture");

        return new ResponseEntity<byte[]>(userRepository.findOne(id).getPicture(), httpHeaders, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST,
            consumes = { "application/json" }, value = "/post")
    public List<User> createJsonUser(@RequestBody UserJson user) {
        List<User> list = new ArrayList<User>();
        list.add(userRepository.save(new User(user)));
        return list;
    }

}
