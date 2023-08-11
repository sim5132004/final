package party.people.web.controller.main;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import party.people.domain.Test;
import party.people.repository.test.TestInterface;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    /* DB 접속 확인용 인터페이스*/
    private final TestInterface testInterface;

    /* index를 home으로 */
    @GetMapping("/")
    public String redirectHome(){
        return "redirect:/home";
    }

    /* home */
    @GetMapping("home")
    public String home(Model model){
        /* Oracle 데이터베이스 연결 확인 */
        List<Test> test = testInterface.findAll();
        log.info("home] "+test);
        return "home";
    }

}
