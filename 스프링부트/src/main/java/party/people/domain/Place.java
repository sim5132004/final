package party.people.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Place {
    private Long id;
    private String category;
    private String smallCategory;
    private String title;
    private String address;
    private String tel;
    private Float latitude;
    private Float longitude;
    private String petInfo;
    private String parkingInfo;
    private String restDayInfo;
    private String runTimeInfo;
    private String feeInfo;
    private String toiletInfo;
    private String languageInfo;
    private String insuranceInfo;
    private String salesItemInfo;
    private String amenityInfo;
    private String menuInfo;
    private String wrapInfo;
    private String checkinInfo;
    private String checkoutInfo;
    private String otherAmenityInfo;
    private String keyword;
    private String imageAdd1;
    private String imageAdd2;

    public Place(){
    }

    public List<String> viewList(){
        List a = new ArrayList<>();
        a.add(petInfo);
        a.add(parkingInfo);
        a.add(runTimeInfo);
        a.add(restDayInfo);
        a.add(feeInfo);
        a.add(toiletInfo);
        a.add(languageInfo);
        a.add(insuranceInfo);
        a.add(salesItemInfo);
        a.add(amenityInfo);
        a.add(menuInfo);
        a.add(wrapInfo);
        a.add(checkinInfo);
        a.add(checkoutInfo);
        return a;


    }



    public Place(Long id, String category, String smallCategory, String title, String address, String tel, Float latitude, Float longitude, String petInfo, String parkingInfo, String restDayInfo, String runTimeInfo, String feeInfo, String toiletInfo, String languageInfo, String insuranceInfo, String salesItemInfo, String amenityInfo, String menuInfo, String wrapInfo, String checkinInfo, String checkoutInfo, String otherAmenityInfo, String keyword, String imageAdd1, String imageAdd2) {
        this.id = id;
        this.category = category;
        this.smallCategory = smallCategory;
        this.title = title;
        this.address = address;
        this.tel = tel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.petInfo = petInfo;
        this.parkingInfo = parkingInfo;
        this.restDayInfo = restDayInfo;
        this.runTimeInfo = runTimeInfo;
        this.feeInfo = feeInfo;
        this.toiletInfo = toiletInfo;
        this.languageInfo = languageInfo;
        this.insuranceInfo = insuranceInfo;
        this.salesItemInfo = salesItemInfo;
        this.amenityInfo = amenityInfo;
        this.menuInfo = menuInfo;
        this.wrapInfo = wrapInfo;
        this.checkinInfo = checkinInfo;
        this.checkoutInfo = checkoutInfo;
        this.otherAmenityInfo = otherAmenityInfo;
        this.keyword = keyword;
        this.imageAdd1 = imageAdd1;
        this.imageAdd2 = imageAdd2;
    }
}
