package party.people.repository.place;

import org.apache.ibatis.annotations.Mapper;
import party.people.domain.Place;

import java.util.List;

@Mapper
public interface PlaceMapper {

    /* 모든 정보 가져오기 일단..*/
    List<Place>findAll();

    /* 해당 카테고리에 해당하는 리스트 불러오기 */
    List<Place>findByCategory(String category);

    /* 해당 키워드가 포함되어 있는 리스트 불러오기 */
    List<Place>findByKeyword(String keyword);

}
