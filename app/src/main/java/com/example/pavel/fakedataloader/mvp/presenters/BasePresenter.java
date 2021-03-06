package com.example.pavel.fakedataloader.mvp.presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<View extends MvpView> extends MvpPresenter<View> {
	private CompositeDisposable compositeDisposable = new CompositeDisposable();

	protected void disposeOnDestroy(@NonNull Disposable disposable) {
		compositeDisposable.add(disposable);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		compositeDisposable.clear();
	}
}
