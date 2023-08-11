package party.people.domain;

import lombok.Data;

@Data
public class Test {
    private String testString;
    private Long testNumber;

    public Test(){};

    public Test(String testString, Long testNumber) {
        this.testString = testString;
        this.testNumber = testNumber;
    }
}
