package topfactors.controller.pub;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrangChuController {

	private static final Logger logger = Logger.getLogger(TrangChuController.class);
	
	@GetMapping("/")
    public ResponseEntity<?> index(){
		logger.info("Hello");
        return ResponseEntity.ok("Hello");
    }
}
