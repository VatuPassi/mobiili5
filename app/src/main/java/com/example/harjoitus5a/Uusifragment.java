package com.example.harjoitus5a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Uusifragment extends Fragment {


    TextView textView1;
    String editTxt1;

    public void AsetaTeksti(String txt) {
        this.textView1.setText(txt);
    }

    public interface IUusiFragment {

        void onButtonPressed(String txt, int id);
    }

    private IUusiFragment mListener;

    public Uusifragment() {
        // Required empty public constructor
    }

    public static Uusifragment newInstance() {
        Uusifragment fragment = new Uusifragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_uusifragment, container, false);
        Button b = v.findViewById(R.id.nappi1);
        editTxt1 = v.findViewById(R.id.editTxt1).toString();
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mListener.onButtonPressed(editTxt1, getId());
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IUusiFragment) {
            mListener = (IUusiFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IUusiFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
