package activitytest.com.example.viewpagetest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activitytest.com.example.viewpagetest.R;

/**
 * Created by 问荆 on 2018/5/10.
 */

public class Fragment4 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pic4, container, false);
    }
}
