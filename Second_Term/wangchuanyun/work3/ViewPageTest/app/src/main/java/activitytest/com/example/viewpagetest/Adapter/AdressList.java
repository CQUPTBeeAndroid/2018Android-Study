package activitytest.com.example.viewpagetest.Adapter;

/**
 * Created by 问荆 on 2018/5/11.
 */

public class AdressList {
    private String name;
    private int imageId;
    public AdressList(String name ,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public  String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}