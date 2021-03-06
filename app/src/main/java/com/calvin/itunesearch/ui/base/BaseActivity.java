package com.calvin.itunesearch.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.calvin.itunesearch.utils.CommonUtils;
import dagger.android.AndroidInjection;

/**
 * @description     Base Activity
 *
 * @author          Adrian
 * @date            08/30/21
 */
public abstract class BaseActivity<V extends BaseViewModel> extends AppCompatActivity {
    // this can probably depend on showLoading/hideLoading SingleEvent of BaseViewModel.
    // since its going to be common for all the activities
    private ProgressDialog mProgressDialog;

   // private mViewModel ;
    private V mViewModel;

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        subscribeToProgressDialogEvents();
    }


    /**
     * we are subscribing to show/hide loading in base activity so that we don't have to
     * subscribe to these events in every activity that uses Progress dialog
     */
    private void subscribeToProgressDialogEvents() {
        mViewModel.getHideLoading().observe(this, Void -> hideLoading());
        mViewModel.getShowLoading().observe(this, Void -> showLoading());
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

}