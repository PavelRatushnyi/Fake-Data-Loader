package com.example.pavel.fakedataloader.mvp;

import com.example.pavel.fakedataloader.app.PostsApi;
import com.example.pavel.fakedataloader.mvp.models.Post;

import java.util.List;

import io.reactivex.Observable;

public class PostsService {
	private PostsApi mPostsApi;

	public PostsService(PostsApi postsApi) {
		mPostsApi = postsApi;
	}

	public Observable<List<Post>> getPhrases() {
		return mPostsApi.getPhrases();
	}
}
