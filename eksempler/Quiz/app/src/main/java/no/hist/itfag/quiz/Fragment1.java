package no.hist.itfag.quiz;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;

//import no.hist.itfag.quiz.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class Fragment1 extends ListFragment implements QuizDialogFragment.Callback {
    private String[] questions;
    private String[] answers;
    private int clicked = -1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Fragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res= getResources();
        questions = res.getStringArray(R.array.questions);
        answers = res.getStringArray(R.array.answers);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, questions));
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        // ListView can only be accessed here, not in onCreate()
        super.onViewCreated(view, savedInstanceState);
        //    return inflater.inflate(R.layout.fragment1, container, false);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        QuizDialogFragment dialog =
                QuizDialogFragment.newInstance(questions[position], answers[position], this);
        dialog.show(getFragmentManager(), null);
        clicked = position;
    }
    public void showResponse(boolean correct) {
        ListView l = getListView();
        TextView v = (TextView)l.getChildAt(clicked);
        if (correct) v.setBackgroundColor(Color.GREEN);
        else v.setBackgroundColor(Color.RED);
    }
}
