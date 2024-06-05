package com.example.lab10

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/todos/{id}")
    suspend fun getTodo(@Path("id") id: Int) : Response<Todo>

    @POST("/todos/")
    suspend fun addUser(@Body todo: Todo) : Response<AddTodoResponse>
}