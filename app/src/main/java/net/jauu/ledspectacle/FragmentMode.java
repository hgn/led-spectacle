package net.jauu.ledspectacle;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * The main fragment that shows the buttons and the text view containing the log.
 */
public class FragmentMode extends Fragment {



    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    //private static List<Model> demoData;

    public FragmentMode() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_modes, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        ArrayList<ModeData> items = new ArrayList<ModeData>();
        items.add(new ModeData("Ambient", R.drawable.img_mode_ambient, "/arduino/mode/ambient"));
        items.add(new ModeData("Ambient Dynamic", R.drawable.img_mode_ambient_dyn, "/arduino/mode/ambient-dynamic"));
        items.add(new ModeData("Disco", R.drawable.img_mode_disco, "/arduino/mode/disco"));
        items.add(new ModeData("Stollzation", R.drawable.img_mode_stoll, "/arduino/mode/disco"));

        adapter = new RecyclerViewAdapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        /*
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public void onTouchEvent(RecyclerView recycler, MotionEvent event) {
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recycler, MotionEvent event) {
                return false;
            }
        });
        */
    }
}
