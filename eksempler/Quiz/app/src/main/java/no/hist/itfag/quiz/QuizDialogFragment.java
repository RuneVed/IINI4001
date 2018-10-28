package no.hist.itfag.quiz;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;

import java.io.Serializable;

public class QuizDialogFragment extends DialogFragment {
    Callback callback = null;
    static QuizDialogFragment newInstance(String title, String answer, Callback callback) {
        QuizDialogFragment fragment = new QuizDialogFragment();
        fragment.callback = callback;
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("answer",answer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setPositiveButton(R.string.yes, new MyListener());
        builder.setNegativeButton(R.string.no, new MyListener());
        return builder.create();
    }

    class MyListener implements DialogInterface.OnClickListener {
        String answer = getArguments().getString("answer");

        @Override
        public void onClick(DialogInterface dialog, int which) {
            int ans = Dialog.BUTTON_POSITIVE;
            if (answer.equals(getResources().getString(R.string.no))) ans = Dialog.BUTTON_NEGATIVE;
            if (callback != null) callback.showResponse(which == ans);
        }
    }

    public interface Callback {
         public void showResponse(boolean correct);
    }
}