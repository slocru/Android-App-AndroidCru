package org.androidcru.crucentralcoast.presentation.viewmodels;

import android.content.Context;
import android.view.View;

import org.androidcru.crucentralcoast.presentation.validator.BaseValidator;
import org.androidcru.crucentralcoast.presentation.views.base.BaseAppCompatActivity;
import org.androidcru.crucentralcoast.presentation.views.base.BaseSupportFragment;
import org.androidcru.crucentralcoast.presentation.views.base.SubscriptionsHolder;

import butterknife.ButterKnife;

public class BaseVM
{
    protected View rootView;
    protected SubscriptionsHolder holder;
    public Context context;
    public BaseValidator validator;

    public BaseVM(BaseAppCompatActivity activity)
    {
        setupWithActivity(activity);
        validator = new BaseValidator(this);
    }

    public BaseVM(BaseSupportFragment fragment)
    {
        setupWithFragment(fragment);
        validator = new BaseValidator(this);
    }

    private void setupWithFragment(BaseSupportFragment fragment)
    {
        this.rootView = fragment.getView();
        this.context = fragment.getContext();
        this.holder = fragment;
        fragment.unbinder = ButterKnife.bind(this, rootView);
    }

    private void setupWithActivity(BaseAppCompatActivity activity)
    {
        this.rootView = activity.findViewById(android.R.id.content);
        this.holder = activity;
        this.context = activity;
        activity.unbinder = ButterKnife.bind(this, activity);
    }

    public void rebind(BaseSupportFragment fragment)
    {
        fragment.unbinder.unbind();
        setupWithFragment(fragment);
    }

    public void rebind(BaseAppCompatActivity activity)
    {
        activity.unbinder.unbind();
        setupWithActivity(activity);
    }

}
