package activitytest.com.example.viewpagetest.Adapter;

/**
 * Created by 问荆 on 2018/5/10.
 */

public class Message {
        private String name;
        private int imageId;
        private String mes;
        public Message(String name ,int imageId,String mes){
            this.name = name;
            this.imageId = imageId;
            this.mes = mes;
        }
        public  String getName(){
            return name;
        }
        public int getImageId(){
            return imageId;
        }
    public String getMes(){
        return mes;
    }
}
