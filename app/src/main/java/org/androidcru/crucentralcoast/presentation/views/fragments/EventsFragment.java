package org.androidcru.crucentralcoast.presentation.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidcru.crucentralcoast.R;
import org.androidcru.crucentralcoast.presentation.presenters.EventsPresenter;
import org.androidcru.crucentralcoast.presentation.views.adapters.EventAdapter;
import org.androidcru.crucentralcoast.presentation.views.views.EventsView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventsFragment extends MvpFragment<EventsPresenter> implements EventsView
{
    @Bind(R.id.event_list)
    RecyclerView mEventList;

    LinearLayoutManager mLayoutManager;
    EventAdapter mEventAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.events, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mEventList.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mEventAdapter = new EventAdapter(presenter.getEventData());
        mEventList.setAdapter(mEventAdapter);
    }

    @Override
    protected EventsPresenter createPresenter()
    {
        return new EventsPresenter();
    }


}