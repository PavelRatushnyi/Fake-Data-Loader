package com.example.pavel.fakedataloader.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.pavel.fakedataloader.R;
import com.example.pavel.fakedataloader.mvp.models.Post;
import com.example.pavel.fakedataloader.mvp.presenters.PostPresenter;
import com.example.pavel.fakedataloader.mvp.views.PostView;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends MvpRecyclerListAdapter<PostsAdapter.PostHolder> {

	private PostsAdapterListener mPostsAdapterListener;
	private List<Post> mPosts;

	public PostsAdapter(MvpDelegate<?> parentDelegate) {
		super(parentDelegate, String .valueOf(0));
		mPosts = new ArrayList<>();
	}

	public void setPostsAdapterListener(PostsAdapterListener postsAdapterListener) {
		mPostsAdapterListener = postsAdapterListener;
	}

	public void setPhrases(List<Post> posts) {
		mPosts = new ArrayList<>(posts);
		notifyDataSetChanged();
	}

	@Override
	public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
		view.setOnClickListener(v -> {
			if (mPostsAdapterListener != null) {
				mPostsAdapterListener.onItemClick(v);
			}
		});
		return new PostHolder(view);
	}

	@Override
	public void onBindViewHolder(PostHolder holder, int position) {
		Post post = mPosts.get(position);
		holder.bind(post);
	}

	@Override
	public int getItemCount() {
		return mPosts.size();
	}

	public Post getItem(int position) {
		return mPosts.get(position);
	}

	public class PostHolder extends RecyclerView.ViewHolder implements PostView {
		@InjectPresenter
		PostPresenter mPostPresenter;

		private Post mPost;

		private MvpDelegate mMvpDelegate;

		@ProvidePresenter
		PostPresenter providePhrasePresenter() {
			return new PostPresenter(mPost);
		}

		private TextView mTitle;
		private TextView mBody;

		private PostHolder(View itemView) {
			super(itemView);
			mTitle = (TextView) itemView.findViewById(R.id.title);
			mBody = (TextView) itemView.findViewById(R.id.body);
		}

		private void bind(Post post) {
			if (getMvpDelegate() != null) {
				getMvpDelegate().onSaveInstanceState();
				getMvpDelegate().onDetach();
				getMvpDelegate().onDestroyView();
				mMvpDelegate = null;
			}

			mPost = post;

			getMvpDelegate().onCreate();
			getMvpDelegate().onAttach();
		}

		@Override
		public void showPhrase(Post post) {
			mTitle.setText(post.getTitle());
			mBody.setText(post.getBody());
		}

		MvpDelegate getMvpDelegate() {
			if (mPost == null) {
				return null;
			}

			if (mMvpDelegate == null) {
				mMvpDelegate = new MvpDelegate<>(this);
				mMvpDelegate.setParentDelegate(PostsAdapter.this.getMvpDelegate(), mPost.getId());
			}
			return mMvpDelegate;
		}
	}

	public interface PostsAdapterListener {
		void onItemClick(View view);
	}
}