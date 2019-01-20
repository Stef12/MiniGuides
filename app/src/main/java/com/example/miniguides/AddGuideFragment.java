package com.example.miniguides;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddGuideFragment extends Fragment {

    // Local variables
    private View view;
    private EditText etAddGuide;
    private FloatingActionButton fabAddItem;
    private ListView lvFutureGuides;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> guideList;

    public AddGuideFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_guide_fragment, container, false);

        etAddGuide = view.findViewById(R.id.etAddGuide);
        fabAddItem = view.findViewById(R.id.fabAddGuide);
        lvFutureGuides = view.findViewById(R.id.lvFutureGuides);
        guideList = new ArrayList<>();

        // Add getView in order to change text color of listview
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, guideList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tvEdited = view.findViewById(android.R.id.text1);
                tvEdited.setTextColor(Color.rgb(233, 238, 237));
                return view;
            }
        };
        lvFutureGuides.setAdapter(adapter);

        fabAddItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Check if text is present
                if (!TextUtils.isEmpty(etAddGuide.getText().toString())) {
                    guideList.add(etAddGuide.getText().toString());
                    adapter.notifyDataSetChanged();
                    //Empty edit-text for the next item
                    etAddGuide.setText("");
                } else {
                    // Show message if edit-text is empty
                    Snackbar.make(view, "Vul iets in het veld hier achter", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
