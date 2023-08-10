package party.people.web.controller;

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
public class TestController {

    private final TestInterface testInterface;

    @GetMapping("/")
    public String home(){
        return "redirect:/home";
    }

    @GetMapping("home")
    public String test(Model model){
        List<Test> testList = testInterface.findAll();
        log.info("test] "+testList);
        return "home";
    }



}
