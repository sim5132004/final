package party.people.repository.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import party.people.domain.Place;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PlaceRepository implements PlaceInterface{

    private final PlaceMapper placeMapper;

    @Override
    public List<Place> findAll() {
        return placeMapper.findAll();
    }

    @Override
    public List<Place> findByCategory(String category) {
        return placeMapper.findByCategory(category);
    }

    @Override
    public List<Place> findByKeyword(String keyword) {
        return placeMapper.findByKeyword(keyword);
    }
}
