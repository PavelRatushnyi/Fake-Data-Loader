package com.example.pavel.fakedataloader.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.pavel.fakedataloader.mvp.models.Post;

import java.util.List;

public interface PostsView extends MvpView {
	void showLoadingProgress();

	void hideLoadingProgress();

	void setPhrases(List<Post> posts);
}
