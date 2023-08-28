package party.people.web.controller.place;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.*;
import party.people.repository.InviteCard.InviteCardInterface;
import party.people.repository.place.PlaceInterface;
import party.people.repository.search.SearchInputInterface;

import static party.people.web.controller.category.CategoryController.loginCheck;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class placeSaveController {
    private final PlaceInterface placeInterface;
    private final SearchInputInterface searchInputInterface;
    private final InviteCardInterface inviteCardInterface;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PostMapping("saveCard")
    public String inviteCard(@ModelAttribute("inviteCard")InviteCard inviteCard,@RequestParam("datetype") String datetype, HttpServletRequest request, Model model){

        loginCheck(request, model);

        System.out.println("저장중");
        System.out.println(inviteCard.getPlaceId1());

        InviteCard letInviteCard = new InviteCard();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateOn;
        try{
            dateOn =datetype.split(",")[0];
        }
        catch (Exception e){
            log.info("placeSaveController 데이트 오류발생");
        }
        if(inviteCard.getTitle()!=null)
            letInviteCard.setTitle(inviteCard.getTitle().split(",")[0]);

        log.info("placeSaveController] letInviteCard.getTITLE() = " + letInviteCard.getTitle());
        log.info("위에는 렛"+inviteCard.getTitle());
        log.info(inviteCard.getTitle().split(",")[0]);
        log.info(inviteCard.getTitle().split(",")[1]);

        if(inviteCard.getMeetingContent() !=null)
         letInviteCard.setMeetingContent(inviteCard.getMeetingContent().split(",")[0]);
        if((inviteCard.getMeetingParticipants()!=null) && inviteCard.getMeetingParticipants().equals(""))
           letInviteCard.setMeetingParticipants(inviteCard.getMeetingParticipants().split(",")[0]);
        if((inviteCard.getTargetTime()!=null)&& inviteCard.getTargetTime().equals(""))
          letInviteCard.setTargetTime(inviteCard.getTargetTime().split(",")[0]);

        //클라이언트 아이디 저장
        HttpSession loginId = request.getSession(false);
        Client login = (Client) loginId.getAttribute("로그인");
        letInviteCard.setClientId(login.getClientId());
        if (inviteCard.getPlaceId1()!=null)
        letInviteCard.setPlaceId1(inviteCard.getPlaceId1());
        if(inviteCard.getPlaceId2()!=null)
        letInviteCard.setPlaceId2(inviteCard.getPlaceId2());
        if(inviteCard.getPlaceId3()!=null)
        letInviteCard.setPlaceId3(inviteCard.getPlaceId3());

        try {
            letInviteCard.setTargatDate(formatter.parse(datetype));
        }
        catch (Exception e){
            log.info("잘못된 날짜입력");
        }





//        log.info("placeSaveController] datetype = " + dateOn);

        log.info("placeSaveController] inviteCard = " + inviteCard.getTitle());
        log.info("placeSaveController] inviteCard = " + inviteCard.getPlaceId1());

        log.info("placeSaveController] inviteCard = " + inviteCard.getClientId());

//        inviteCard.setCLIENT_ID("tester");
        if (letInviteCard.getClientId()!=null)
        inviteCardInterface.saveCard(letInviteCard);

//        return "";
    return "redirect:/";

    }




//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @PostMapping("saveCard")
////    public String inviteCard(@ModelAttribute("inviteCard")InviteCard inviteCard,@RequestParam("datetype") String datetype){
//
//    public String inviteCard(@RequestParam("MEETING_PARTICIPANTS")String MEETING_PARTICIPANTS,@@RequestParam(""),@RequestParam(""),@RequestParam(""),
//                             @RequestParam("datetype") String datetype ){
//        System.out.println("저장중");
//        System.out.println(inviteCard.getPLACE_ID_1());
//
//        log.info("placeSaveController] datetype = " + datetype);
//
//        log.info("placeSaveController] inviteCard = " + inviteCard.getTITLE());
//        log.info("placeSaveController] inviteCard = " + inviteCard.getPLACE_ID_1());
//
//        log.info("placeSaveController] inviteCard = " + inviteCard.getCLIENT_ID());
//
//        inviteCard.setCLIENT_ID("tester");
//        inviteCardInterface.saveCard(inviteCard);
//
//
//        return "redirect:/invite/invite_A";
//    }
    @GetMapping("saveCard")
    public String inviteGet(){
        return "invite/invite_A";
    }




}
