package com.example.super_chao.myfirstapplication;


        import android.content.Context;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {




    public Fragment1() {
        // Required empty public constructor
    }
private List<Chat> chatList = new ArrayList<>();
    //private String[] data = {"apple","banana"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.reclcler_view);
        initChats();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ChatAdapter adapter = new ChatAdapter(chatList);
        recyclerView.setAdapter(adapter);
        return view;

    }
    private  void initChats() {
        for (int i = 1; i < 20; i++) {
            int t = 10;
            t = t+i;
            Chat chat1 = new Chat("新的朋友", R.drawable.touxiang1, "10:"+t, "hahahahahha");
            chatList.add(chat1);
            Chat chat2 = new Chat("瑞文", R.drawable.touxiang2, "10:"+t, "断剑重铸之日，骑士归来之时");
            chatList.add(chat2);
            Chat chat3 = new Chat("阿狸", R.drawable.touxiang3, "10:"+t, "你好哇");
            chatList.add(chat3);
        }
    }


}