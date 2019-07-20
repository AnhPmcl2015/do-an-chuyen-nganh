package topfactors.controller.pub;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrangChuController {

    public String index(){
    	System.out.println("Hello");
        return "hello";
    }
}
