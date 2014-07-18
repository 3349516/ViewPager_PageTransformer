package com.way.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TestFragment extends Fragment {
	private static final String KEY_CONTENT = "TestFragment:Position";
	protected static final int[] CONTENT = new int[] {
			R.drawable.biz_ad_new_version1_img_bg0,
			R.drawable.biz_ad_new_version1_img_bg1,
			R.drawable.biz_ad_new_version1_img_bg2, };
	private int mPosition;

	public static TestFragment newInstance(int position) {
		TestFragment fragment = new TestFragment();
		fragment.mPosition = position;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(KEY_CONTENT)) {
			mPosition = savedInstanceState.getInt(KEY_CONTENT);
		}
		View root = inflater
				.inflate(R.layout.fragment_layout, container, false);
		root.setBackgroundResource(CONTENT[mPosition]);
		return root;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_CONTENT, mPosition);
	}
}
