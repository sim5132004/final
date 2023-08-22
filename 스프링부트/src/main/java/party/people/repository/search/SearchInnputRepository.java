package party.people.repository.search;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import party.people.domain.SearchInput;

@Repository
@Slf4j
@RequiredArgsConstructor
public class SearchInnputRepository implements SearchInputInterface{

    private final SearchInputMapper searchInputMapper;

    @Override
    public void save(SearchInput searchInput) {
        searchInputMapper.save(searchInput);
    }
}
