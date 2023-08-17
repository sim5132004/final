package party.people.domain;

import lombok.Data;

@Data
public class Keywords {
    private Long indexId;
    private String category;
    private String keywords;

    public Keywords(){
    }

    public Keywords(String category, String keywords) {
        this.category = category;
        this.keywords = keywords;
    }
}
