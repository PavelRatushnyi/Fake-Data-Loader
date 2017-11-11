package com.example.pavel.fakedataloader.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.pavel.fakedataloader.mvp.models.Post;
import com.example.pavel.fakedataloader.mvp.views.PostView;

@InjectViewState
public class PostPresenter extends MvpPresenter<PostView> {

	private Post mPost;

	public PostPresenter(Post post) {
		super();
		mPost = post;
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getViewState().showPost(mPost);
	}
}
