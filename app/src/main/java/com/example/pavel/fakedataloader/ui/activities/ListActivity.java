package com.example.pavel.fakedataloader.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.pavel.fakedataloader.R;
import com.example.pavel.fakedataloader.mvp.models.Post;
import com.example.pavel.fakedataloader.mvp.presenters.ListPresenter;
import com.example.pavel.fakedataloader.mvp.presenters.PostsPresenter;
import com.example.pavel.fakedataloader.mvp.views.ListView;
import com.example.pavel.fakedataloader.mvp.views.PostsView;
import com.example.pavel.fakedataloader.ui.adapters.PostsAdapter;

import java.util.List;

public class ListActivity extends MvpAppCompatActivity implements PostsView, ListView {
	@InjectPresenter
	PostsPresenter mPostsPresenter;
	@InjectPresenter
	ListPresenter mListPresenter;

	private RecyclerView mPhrasesRecyclerView;
	private ProgressBar mLoadingProgressBar;

	private PostsAdapter mPostsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_posts_list);

		mLoadingProgressBar = (ProgressBar) findViewById(R.id.loading_progress_bar);
		mPhrasesRecyclerView = (RecyclerView) findViewById(R.id.posts_list_recycler_view);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		mPhrasesRecyclerView.setLayoutManager(linearLayoutManager);
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mPhrasesRecyclerView.getContext(), linearLayoutManager.getOrientation());
		mPhrasesRecyclerView.addItemDecoration(dividerItemDecoration);

		mPostsAdapter = new PostsAdapter(getMvpDelegate());
		mPostsAdapter.setPostsAdapterListener(view -> {
			int position = mPhrasesRecyclerView.getChildAdapterPosition(view);
			if (position == RecyclerView.NO_POSITION) {
				return;
			}

			mListPresenter.onPostSelection(mPostsAdapter.getItem(position));
		});
		mPhrasesRecyclerView.setAdapter(mPostsAdapter);
	}

	@Override
	public void showLoadingProgress() {
		mPhrasesRecyclerView.setVisibility(View.GONE);
		mLoadingProgressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoadingProgress() {
		mLoadingProgressBar.setVisibility(View.GONE);
		mPhrasesRecyclerView.setVisibility(View.VISIBLE);
	}

	@Override
	public void setPhrases(List<Post> posts) {
		mPostsAdapter.setPhrases(posts);
	}

	@Override
	public void showDetails(Post post) {
		DetailsActivity.showInstance(this, post);
	}
}
