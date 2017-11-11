package com.example.pavel.fakedataloader.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.pavel.fakedataloader.R;
import com.example.pavel.fakedataloader.mvp.models.Post;
import com.example.pavel.fakedataloader.mvp.presenters.PostPresenter;
import com.example.pavel.fakedataloader.mvp.views.PostView;

public class DetailsActivity extends MvpAppCompatActivity implements PostView {
	public static final String ARGS_POST = "argsPost";

	@InjectPresenter
	PostPresenter mPostPresenter;

	private Post mPost;

	private TextView mIdTextView;
	private TextView mUserIdTextView;
	private TextView mTitleTextView;
	private TextView mBodyTextView;

	@ProvidePresenter
	PostPresenter providePostPresenter() {
		mPost = getIntent().getParcelableExtra(ARGS_POST);

		return new PostPresenter(mPost);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		mIdTextView = findViewById(R.id.post_id);
		mUserIdTextView = findViewById(R.id.post_user_id);
		mTitleTextView = findViewById(R.id.post_title);
		mBodyTextView = findViewById(R.id.post_body);
	}

	public static void showInstance(Context context, Post post) {
		Intent intent = new Intent(context, DetailsActivity.class);
		intent.putExtra(ARGS_POST, post);
		context.startActivity(intent);
	}

	@Override
	public void showPost(Post post) {
		mPost = post;

		mIdTextView.setText(post.getId());
		mUserIdTextView.setText(post.getUserId());
		mTitleTextView.setText(post.getTitle());
		mBodyTextView.setText(post.getBody());
	}
}
