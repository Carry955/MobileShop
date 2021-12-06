package com.carry.mobileshop03.http.service;


import com.carry.mobileshop03.http.entity.GoodsEntity;
import com.carry.mobileshop03.http.entity.HttpResult;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface GoodsService {
    @FormUrlEncoded
    @POST("goods/find")
    Observable<HttpResult<List<GoodsEntity>>> listByKeywords(
            @Field("input") String keywords
    );
}
