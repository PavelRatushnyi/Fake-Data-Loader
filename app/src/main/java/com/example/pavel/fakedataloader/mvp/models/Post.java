package com.example.pavel.fakedataloader.mvp.models;

import com.google.gson.annotations.SerializedName;

public class Post {
	@SerializedName("id")
	private String mId;
	@SerializedName("userId")
	private String mUserId;
	@SerializedName("title")
	private String mTitle;
	@SerializedName("body")
	private String mBody;

	public Post(String id, String userId, String title, String body) {
		mId = id;
		mUserId = userId;
		mTitle = title;
		mBody = body;
	}

	public String getId() {
		return mId;
	}

	public void setId(String id) {
		mId = id;
	}

	public String getUserId() {
		return mUserId;
	}

	public void setUserId(String userId) {
		mUserId = userId;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getBody() {
		return mBody;
	}

	public void setBody(String body) {
		mBody = body;
	}
}
