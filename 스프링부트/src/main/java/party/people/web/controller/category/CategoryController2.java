package party.people.web.controller.category;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.InviteCard;
import party.people.domain.Place;
import party.people.repository.InviteCard.InviteCardInterface;
import party.people.repository.place.PlaceInterface;

import static party.people.web.controller.category.CategoryController.loginCheck;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CategoryController2 {

    private final PlaceInterface placeInterface;
    private final InviteCardInterface inviteCardInterface;


    @GetMapping("invite")
    public String goInvite(HttpServletRequest request, Model model){

        /* 로그인 세션 유지용 메서드 */
        /* 메서드 이름 컨트롤 클릭으로 내용 확인 가능 */
        loginCheck(request,model);

        /* side lnb 출력용 */
        model.addAttribute("category","invite");

        Place place1 = placeInterface.idSearch(1L);
        List<Place> placeList = new ArrayList<>();
//        placeList.add(place1);

        List<Place> placeList2 = new ArrayList<>();
        Place place12 = placeInterface.idSearch(11L);
        Place place22 = placeInterface.idSearch(22L);
        Place place32 = placeInterface.idSearch(33L);
        placeList2.add(place12);
        placeList2.add(place22);
        placeList2.add(place32);
        List<Place> pl = new ArrayList<>();


        HttpSession test = request.getSession(false);
        if (test!=null) {


            List<List<Place>> place2 = (List<List<Place>>) test.getAttribute("검색결과");

            log.info("CategoryController2");
            System.out.println(place2);

            System.out.println(place2.getClass());

            System.out.println(place2.get(0).getClass());

            pl= place2.get(0);
            System.out.println(pl);

            for(Place x:pl){
                System.out.println("hihi");
                System.out.println(x);
            }


//            Place place0= placeInterface.idSearch(pl.get(0).getId());
//            Place place3 = placeInterface.idSearch(pl.get(1).getId());
//
//            Place place4 = placeInterface.idSearch(pl.get(2).getId());
//            placeList.add(place3);
//            placeList.add(place4);



        }
        else{
            System.out.println("null");
        }


        if (test!=null) {
            model.addAttribute("category2", pl);
        }else{

            model.addAttribute("category2", placeList2);
        }
        System.out.println(pl);

        /* side lnb 출력용 */
//        if(request != null){
//            model.addAttribute("category2",request);
//
//        }else{
//
//
//        }

        return "invite/invite_A";
    }



    @GetMapping("/saveCard")
    public String resultPage(@RequestParam("data") String data, @ModelAttribute("card") InviteCard inviteCard) {

        inviteCardInterface.saveCard(inviteCard);


//        model.addAttribute("data", data);



        return "";
    }



}
