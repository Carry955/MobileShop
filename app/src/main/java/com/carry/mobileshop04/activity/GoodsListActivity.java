package com.carry.mobileshop04.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.carry.mobileshop04.R;
import com.carry.mobileshop04.adapter.GoodsListAdapter;
import com.carry.mobileshop04.common.BaseActivity;
import com.carry.mobileshop04.http.entity.GoodsEntity;
import com.carry.mobileshop04.http.persenter.GoodsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class GoodsListActivity extends BaseActivity {

    private int cat_id;
    @BindView(R.id.goodslist_swipe_refresh)
    SwipeRefreshLayout goodsListSwipeRefresh;
    @BindView(R.id.goodslist_recyclerview)
    RecyclerView goodsListRecyclerview;
    @BindView(R.id.goodslist_nodata)
    TextView goodsListNoData;

    private List<GoodsEntity> listData;
    private GoodsListAdapter adapter;


    @Override
    public int getContentViewId() {
        return R.layout.activity_goodslist;
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }


    @Override
    protected void initView() {
        super.initView();
        goodsListNoData.setVisibility(View.GONE);
        cat_id = getIntent().getIntExtra("cat_id",0);
        goodsListSwipeRefresh.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        goodsListSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        goodsListRecyclerview.setLayoutManager(layoutManager);

        listData = new ArrayList<GoodsEntity>();
        adapter = new GoodsListAdapter(this, listData);
        adapter.setOnItemClickListener(new GoodsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GoodsEntity entity) {
                Intent intent = new Intent(GoodsListActivity.this, GoodsDetailActivity.class);
                intent.putExtra("goods_id",entity.getGoods_id());
                intent.putExtra("goods_name",entity.getName());
                startActivity(intent);
            }
        });
        goodsListRecyclerview.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        loadData();
    }

    private void loadData(){
        GoodsPresenter.list(new Subscriber<List<GoodsEntity>>() {
            @Override
            public void onCompleted() {
                goodsListSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                goodsListSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onNext(List<GoodsEntity> goodsEntities) {
                listData.clear();
                listData.addAll(goodsEntities);
                adapter.notifyDataSetChanged();

                if (listData == null || listData.size()==0){
                    toastShort("没有该列表的商品数据！");
                    goodsListNoData.setVisibility(View.VISIBLE);
                    goodsListRecyclerview.setVisibility(View.GONE);
                }else{
                    goodsListNoData.setVisibility(View.GONE);
                    goodsListRecyclerview.setVisibility(View.VISIBLE);
                }
            }
        }, cat_id);
    }
}
