package com.mapplinks.traveldiary;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Aditya Vikram on 9/23/2015.
 */
public class MemoryDialogFragment extends DialogFragment{

    private static final String TAG ="MemoryDialogFragment";
    private static final String MEMORY_KEY = "Memory Dialog Fragment";

    private Memory mMemory;
    private Listener mListener;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args=getArguments();
        if(args!=null){
            mMemory = (Memory)args.getSerializable(MEMORY_KEY);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        v= getActivity().getLayoutInflater().inflate(R.layout.memory_dialog_fragment,null);

        TextView cityView=(TextView)v.findViewById(R.id.city);
        cityView.setText(mMemory.city);

        TextView countryView=(TextView)v.findViewById(R.id.country);
        countryView.setText(mMemory.country);

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(v)
                .setTitle(getString(R.string.memory_dialog_title))
                .setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText notesView = (EditText)v.findViewById(R.id.notes);
                        mMemory.notes=notesView.getText().toString();
                        mListener.onSaveClicked(mMemory);
                    }
                }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.OnCancelClicked(mMemory);
            }
        });

        return builder.create();
    }

    public static MemoryDialogFragment newInstance(Memory memory){
        MemoryDialogFragment fragment=new MemoryDialogFragment();

        Bundle args = new Bundle();
        args.putSerializable(MEMORY_KEY,memory);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (Listener) getActivity();
        } catch (ClassCastException e) {
            throw new IllegalStateException("Error! Doesn't implement marker");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface Listener{
        public void onSaveClicked(Memory memory);
        public void OnCancelClicked(Memory memory);
    }

}
