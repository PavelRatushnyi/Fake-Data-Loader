package com.example.pavel.fakedataloader.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Post implements Parcelable {
	@SerializedName("id")
	private String mId;
	@SerializedName("userId")
	private String mUserId;
	@SerializedName("title")
	private String mTitle;
	@SerializedName("body")
	private String mBody;

	public Post(Parcel in) {
		mId = in.readString();
		mUserId = in.readString();
		mTitle = in.readString();
		mBody = in.readString();
	}

	public static final Creator<Post> CREATOR = new Creator<Post>() {
		@Override
		public Post createFromParcel(Parcel in) {
			return new Post(in);
		}

		@Override
		public Post[] newArray(int size) {
			return new Post[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(mId);
		parcel.writeString(mUserId);
		parcel.writeString(mTitle);
		parcel.writeString(mBody);
	}
}
