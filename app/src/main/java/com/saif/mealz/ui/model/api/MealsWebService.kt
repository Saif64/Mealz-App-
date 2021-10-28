package com.saif.mealz.ui.model.api

import com.saif.mealz.ui.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MealsWebService {
    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<MealsCategoriesResponse> {
        return api.getMeals()
    }

    interface MealsApi {
        @GET("categories.php")
        fun getMeals(): Call<MealsCategoriesResponse>
    }
}