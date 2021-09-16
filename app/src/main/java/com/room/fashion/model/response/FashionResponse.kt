package com.room.fashion.model.response

import com.google.gson.annotations.SerializedName

data class FashionResponse(
    @SerializedName("banners")
    val banners: List<FashionBanner>,
    @SerializedName("goods")
    val goods: List<FashionGood>
){
    data class FashionBanner(
        @SerializedName("id") val id: Int,
        @SerializedName("image") val image: Int
    )
    data class FashionGood(
        @SerializedName("id") val id: Int, //상품 ID
        @SerializedName("name") val name: String, //상품 이름
        @SerializedName("image") val image: String, //상품 이미지 url
        @SerializedName("actual_price") val actual_price: Int, //상품 기본 가격
        @SerializedName("price") val price: Int, // 상품 실제 가격(기본가격 X 할인율 / 100 = 실제가격),
        @SerializedName("is_new") val is_new: Boolean, // 신상품인지 여부
        @SerializedName("sell_count") val sell_count: Int, // 구매중 갯수
    )
}