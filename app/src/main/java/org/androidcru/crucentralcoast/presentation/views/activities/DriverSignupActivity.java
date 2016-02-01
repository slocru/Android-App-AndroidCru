package org.androidcru.crucentralcoast.presentation.views.activities;

import android.os.Bundle;

import org.androidcru.crucentralcoast.R;
import org.androidcru.crucentralcoast.presentation.views.activities.forms.FormBaseActivity;
import org.androidcru.crucentralcoast.presentation.views.fragments.driversignup.DriverFragment;

public class DriverSignupActivity extends FormBaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new DriverFragment()).commit();
    }
}
