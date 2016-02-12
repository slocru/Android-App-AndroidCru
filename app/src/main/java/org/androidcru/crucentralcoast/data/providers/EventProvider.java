package org.androidcru.crucentralcoast.data.providers;

import org.androidcru.crucentralcoast.data.models.CruEvent;
import org.androidcru.crucentralcoast.data.services.CruApiService;

import java.util.ArrayList;

import rx.Observable;
import rx.schedulers.Schedulers;

public class EventProvider
{
    private static CruApiService mCruService = ApiProvider.getInstance().getService();
    private static EventProvider mInstance;

    private EventProvider() {}

    public static EventProvider getInstance()
    {
        if(mInstance == null)
            mInstance = new EventProvider();
        return mInstance;
    }

    public Observable<ArrayList<CruEvent>> requestEvents()
    {

        return mCruService.getEvents()
                .subscribeOn(Schedulers.io());
    }
}
