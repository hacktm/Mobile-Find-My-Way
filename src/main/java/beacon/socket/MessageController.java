package beacon.socket;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * Created by mmazilu on 10/18/2014.
 */

@Controller
public class MessageController {

    @MessageMapping("/raiseHand")
    @SendTo("/topic/roomwatch")
    public RaiseHand greeting(RaiseHand message) throws Exception {
//        Thread.sleep(3000); // simulated delay
        return message;
    }

}
