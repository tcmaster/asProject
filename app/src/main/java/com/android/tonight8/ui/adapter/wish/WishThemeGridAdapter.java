package com.android.tonight8.ui.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.android.tonight8.R;
import com.android.tonight8.ui.activity.wish.MakeWishActivity;
import com.android.tonight8.ui.adapter.BaseListAdapter;
import com.android.tonight8.ui.adapter.ViewHolder;
import com.android.tonight8.utils.DialogUtils;

/**
 * @author lz心愿主题图片
 * 
 */
public class WishThemeGridAdapter extends BaseListAdapter<String> {
	private MakeWishActivity mActivity;

	public WishThemeGridAdapter(Context context, List<String> values) {
		super(context, values);
		mActivity = (MakeWishActivity) mContext;
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		convertView = mInflater.inflate(R.layout.adapter_wishtheme_grid, null);
		ImageView wishthemepic = ViewHolder.get(convertView,
				R.id.iv_wish_themepic);
		ImageView iv_cs_gallay_delete = ViewHolder.get(convertView,
				R.id.iv_cs_gallay_delete);
		if (mValues.get(position) != null && mValues.get(position) == "") {
			iv_cs_gallay_delete.setVisibility(View.GONE);
		} else {
			iv_cs_gallay_delete.setVisibility(View.VISIBLE);
		}

		bmUtils.display(wishthemepic, mValues.get(position));
		wishthemepic.setTag(position);
		wishthemepic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (mValues.get(position) == null
						|| "".equals(mValues.get(position))) {
					mActivity.updateWishThemeData(position,
							MakeWishActivity.UPDATA_DATA, null);
					DialogUtils.showSelectPicDialog(mActivity,
							MakeWishActivity.PICKPICTURE,
							MakeWishActivity.TAKEPHOTO);
				}
			}
		});
		iv_cs_gallay_delete.setTag(position);
		iv_cs_gallay_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mActivity.updateWishThemeData(position,
						MakeWishActivity.DELETE_DATA, null);
			}
		});
		return convertView;
	}
}
