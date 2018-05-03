package activitytest.com.example.refreshtest;

/**
 * Created by 问荆 on 2018/4/30.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name ,int imageId){
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
