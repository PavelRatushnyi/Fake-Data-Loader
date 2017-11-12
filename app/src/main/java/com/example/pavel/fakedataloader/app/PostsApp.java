package com.example.pavel.fakedataloader.app;

import android.app.Application;

import com.example.pavel.fakedataloader.di.AppComponent;
import com.example.pavel.fakedataloader.di.DaggerAppComponent;
import com.example.pavel.fakedataloader.di.modules.ContextModule;

public class PostsApp extends Application {
	private static AppComponent sAppComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		sAppComponent = DaggerAppComponent.builder()
				.contextModule(new ContextModule(this))
				.build();
	}

	public static AppComponent getAppComponent() {
		return sAppComponent;
	}
}
