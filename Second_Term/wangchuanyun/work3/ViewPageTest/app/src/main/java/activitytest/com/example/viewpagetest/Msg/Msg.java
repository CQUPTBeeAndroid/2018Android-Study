package activitytest.com.example.viewpagetest.Msg;

/**
 * Created by 问荆 on 2018/5/9.
 */

public class Msg {
    public static final int TYPE_RECEVIED = 0;
    public static final int TYPE_SEND = 1;
    private String content;
    private int type;
    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
