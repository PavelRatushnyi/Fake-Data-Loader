package com.example.pavel.fakedataloader.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.pavel.fakedataloader.mvp.models.Post;

public interface PostView extends MvpView {
	void showPost(Post post);
}
