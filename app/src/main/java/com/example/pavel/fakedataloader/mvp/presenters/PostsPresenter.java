package com.example.pavel.fakedataloader.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.pavel.fakedataloader.app.PostsApp;
import com.example.pavel.fakedataloader.mvp.PostsService;
import com.example.pavel.fakedataloader.mvp.views.PostsView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class PostsPresenter extends MvpPresenter<PostsView> {

	@Inject
	PostsService mPostsService;

	public PostsPresenter() {
		PostsApp.getAppComponent().inject(this);
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		loadPosts();
	}

	private void loadPosts() {

		getViewState().showLoadingProgress();

		mPostsService.getPosts()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(posts -> {
					getViewState().hideLoadingProgress();
					getViewState().setPosts(posts);
				}, error -> {
					getViewState().hideLoadingProgress();
				});
	}
}
