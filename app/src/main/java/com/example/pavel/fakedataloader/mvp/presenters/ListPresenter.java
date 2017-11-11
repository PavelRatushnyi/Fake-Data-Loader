package com.example.pavel.fakedataloader.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.pavel.fakedataloader.mvp.models.Post;
import com.example.pavel.fakedataloader.mvp.views.ListView;

@InjectViewState
public class ListPresenter extends MvpPresenter<ListView> {

	public void onPostSelection(Post post) {
		getViewState().showDetails(post);
	}
}
