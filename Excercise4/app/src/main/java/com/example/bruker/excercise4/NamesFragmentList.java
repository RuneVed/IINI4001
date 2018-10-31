package com.example.bruker.excercise4;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NamesFragmentList extends ListFragment {

    final String[] names ={"Monkey","Lion","Squirrel","Tiger"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        ListView listView =getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,final View view,
                                    int position, long id) {
                if (callback != null){
                    callback.onItemSelected(names[position]);
                }
            }
        });
    }

    public interface Callback{
        public void onItemSelected(String id);
    }

    private Callback callback;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof Callback){
            callback = (Callback) activity;
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        callback = null;
    }

}
