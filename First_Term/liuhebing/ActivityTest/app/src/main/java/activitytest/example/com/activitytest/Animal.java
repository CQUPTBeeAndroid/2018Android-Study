package activitytest.example.com.activitytest;

public class Animal{
    private String name;
    private int imageId;
    public Animal(String name,int imageID){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}

/*public class Animal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

