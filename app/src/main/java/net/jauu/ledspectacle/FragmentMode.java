package net.jauu.ledspectacle;


import android.support.annotation.Nullable;
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
public class FragmentMode extends Fragment {



    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    private static List<Model> demoData;

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

        demoData = new ArrayList<Model>();
        char c = 'A';
        for (byte i = 0; i < 20; i++) {
            Model model = new Model();
            model.name = c++;
            model.age = (byte) (20 + i);
            demoData.add(model);
        }
        adapter = new RecyclerViewAdapter(demoData);
        recyclerView.setAdapter(adapter);
    }
}
