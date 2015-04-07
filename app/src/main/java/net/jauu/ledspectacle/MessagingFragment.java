/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.jauu.ledspectacle;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * The main fragment that shows the buttons and the text view containing the log.
 */
public class MessagingFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = MessagingFragment.class.getSimpleName();

    private Button btn_ambient;
    private Button btn_ambient_dyn;
    private Button btn_stollzation;
    private Button btn_disco;

    private Messenger mService;
    private boolean mBound;

    public MessagingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signals, container, false);

        btn_ambient = (Button) rootView.findViewById(R.id.mode_ambient);
        btn_ambient.setOnClickListener(this);

        btn_ambient_dyn = (Button) rootView.findViewById(R.id.mode_ambient_dynamic);
        btn_ambient_dyn.setOnClickListener(this);

        btn_stollzation = (Button) rootView.findViewById(R.id.mode_stollzation);
        btn_stollzation.setOnClickListener(this);

        btn_disco = (Button) rootView.findViewById(R.id.mode_disco);
        btn_disco.setOnClickListener(this);

        setButtonsState(true);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view == btn_ambient) {
            new RequestTask().execute("http://10.10.10.135/arduino/mode/ambient");
        } else if (view == btn_ambient_dyn) {
            new RequestTask().execute("http://10.10.10.135/arduino/mode/ambient-dynamic");
        } else if (view == btn_stollzation) {
            new RequestTask().execute("http://10.10.10.135/arduino/mode/disco");
        } else if (view == btn_disco) {
            new RequestTask().execute("http://10.10.10.135/arduino/mode/disco");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


    private void setButtonsState(boolean enable) {
        btn_ambient.setEnabled(enable);
        btn_ambient_dyn.setEnabled(enable);
        btn_stollzation.setEnabled(enable);
        btn_disco.setEnabled(enable);
    }
}
