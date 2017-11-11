package com.example.pavel.fakedataloader.ui.adapters;

import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpDelegate;

public abstract class MvpRecyclerListAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
	private MvpDelegate<? extends MvpRecyclerListAdapter> mMvpDelegate;
	private MvpDelegate<?> mParentDelegate;
	private String mChildId;

	public MvpRecyclerListAdapter(MvpDelegate<?> parentDelegate, String childId) {
		mParentDelegate = parentDelegate;
		mChildId = childId;

		getMvpDelegate().onCreate();
	}

	public MvpDelegate getMvpDelegate() {
		if (mMvpDelegate == null) {
			mMvpDelegate = new MvpDelegate<>(this);
			mMvpDelegate.setParentDelegate(mParentDelegate, mChildId);
		}

		return mMvpDelegate;
	}
}
