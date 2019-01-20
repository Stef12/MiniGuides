package com.example.miniguides;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class AllGuidesFragment extends Fragment {

    // Local variables
    private View view;
    private List<Guide> guideList;

    public AllGuidesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.all_guides_fragment, container, false);

        guideList = new ArrayList<>();
        // Add guide to the list in order to show in recycler-view
        guideList.add(new Guide("Route beschrijving", R.drawable.icon_compass, R.drawable.icon_pointer_right));
        guideList.add((new Guide("Wi-Fi connectie", R.drawable.icon_wifi, R.drawable.icon_pointer_right)));
        guideList.add(new Guide("Foto's delen", R.drawable.icon_camera, R.drawable.icon_pointer_right));
        guideList.add(new Guide("Telefoon repareren", R.drawable.icon_iphone, R.drawable.icon_pointer_right));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter RecyclerViewAdapter = new RecyclerViewAdapter(getContext(), guideList);
        // Display contents of recycler-view in gridlayout
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(RecyclerViewAdapter);

        return view;
    }
}
