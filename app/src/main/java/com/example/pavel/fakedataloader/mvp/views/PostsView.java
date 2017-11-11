package com.example.pavel.fakedataloader.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.pavel.fakedataloader.mvp.models.Post;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface PostsView extends MvpView {
	void showLoadingProgress();

	void hideLoadingProgress();

	void showErrorText();

	void hideErrorText();

	void setPosts(List<Post> posts);
}
