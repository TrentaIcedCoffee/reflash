package reflash.ping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PingController {
	@RequestMapping("/ping")
	public String ping() {
		return "pong";
	}
}
