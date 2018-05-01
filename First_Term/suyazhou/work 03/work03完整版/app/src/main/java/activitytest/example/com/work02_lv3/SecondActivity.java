package activitytest.example.com.work02_lv3;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;
    private List<Fruit> fruitList = new ArrayList<>();

    private int lastVisibleItem = 0;
    private final int PAGE_COUNT = 10;
    private FruitAdapter1 adapter1;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_manager);

        initFruits();
        findView();
        initRefreshLayout();
        initRecyclerView();


    }

    private void initFruits() {
        for (int i = 0; i < 4; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

    private void findView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter1 = new FruitAdapter1(fruitList);
        recyclerView.setAdapter(adapter1);
    }

    private void initRefreshLayout() {
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshfruit();
                swipeRefresh.setProgressBackgroundColorSchemeResource(android.R.color.white);
                swipeRefresh.setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_blue_bright, R.color.colorPrimaryDark,
                        android.R.color.holo_orange_dark, android.R.color.holo_red_dark, android.R.color.holo_purple);

                swipeRefresh.setRefreshing(false);
            }
        });

    }

    private void refreshfruit() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initRecyclerView() {
        FruitAdapter1 adapter1 = new FruitAdapter1(fruitList);
        mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter1);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (adapter1.isFadeTips() == false && lastVisibleItem + 1 == adapter1.getItemCount()) {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                updateRecyclerView(adapter1.getRealLastPosition(), adapter1.getRealLastPosition() + PAGE_COUNT);
                            }
                        }, 500);
                    }

                    if (adapter1.isFadeTips() == true && lastVisibleItem + 2 == adapter1.getItemCount()) {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                updateRecyclerView(adapter1.getRealLastPosition(), adapter1.getRealLastPosition() + PAGE_COUNT);
                            }
                        }, 500);
                    }
                }

            }
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });


    }


    private List<String> getDatas( int firstIndex , final int lastIndex) {
        List<String> resList = new ArrayList<>();
        for (int i = firstIndex; i < lastIndex; i++) {
            if (i < fruitList.size()) {
                resList.add(fruitList.get(i));
            }
        }
        return resList;
    }

        private void updateRecyclerView(int fromIndex, int toIndex) {
            List<String> newDatas = getDatas(fromIndex, toIndex);
            if (newDatas.size() > 0) {
                adapter1.updateList(newDatas, true);
            } else {
                adapter1.updateList(null, false);
            }
        }

        public void onRefresh() {
            swipeRefresh.setRefreshing(true);
            adapter1.resetDatas();
            updateRecyclerView(0, PAGE_COUNT);
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeRefresh.setRefreshing(false);
                }
            }, 1000);
        }
    }
