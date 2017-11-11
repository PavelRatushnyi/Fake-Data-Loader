package com.example.pavel.fakedataloader.app;

import com.example.pavel.fakedataloader.mvp.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostsApi {
	@GET("/posts")
	Observable<List<Post>> getPhrases();
}
