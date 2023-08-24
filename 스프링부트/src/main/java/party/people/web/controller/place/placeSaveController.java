package party.people.web.controller.place;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import party.people.domain.Place;
import party.people.domain.SearchInput;
import party.people.domain.SearchResult;
import party.people.repository.place.PlaceInterface;
import party.people.repository.search.SearchInputInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class placeSaveController {
    private final PlaceInterface placeInterface;
    private final SearchInputInterface searchInputInterface;



}
