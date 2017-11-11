package com.example.pavel.fakedataloader.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.pavel.fakedataloader.mvp.models.Post;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ListView extends MvpView {

	@StateStrategyType(OneExecutionStateStrategy.class)
	void showDetails(Post post);
}
