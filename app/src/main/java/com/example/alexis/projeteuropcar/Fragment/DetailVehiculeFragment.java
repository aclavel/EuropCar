package com.example.alexis.projeteuropcar.Fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Activity.DetailVehiculeActivity;
import com.example.alexis.projeteuropcar.R;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailVehiculeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailVehiculeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailVehiculeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button book;
    private HorizontalPicker pickerBegin;
    private HorizontalPicker pickerEnd;

    private DateTime beginDate;
    private DateTime endDate;
    private TextView errorDate;
    private EditText tarifJournalier;

    private OnFragmentInteractionListener mListener;

    public DetailVehiculeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailVehiculeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailVehiculeFragment newInstance(String param1, String param2) {
        DetailVehiculeFragment fragment = new DetailVehiculeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reservation, container, false);


        this.pickerBegin = (HorizontalPicker) v.findViewById(R.id.frag_date_debut);
        this.pickerEnd = (HorizontalPicker) v.findViewById(R.id.frag_date_fin);

        this.pickerBegin.setListener(new DatePickerListener() {
            @Override
            public void onDateSelected(DateTime dateSelected) {
                beginDate = dateSelected;

            }
        }).setDays(100).setOffset(0).init();
        pickerBegin.setDate(new DateTime());

        this.pickerEnd.setListener(new DatePickerListener() {
            @Override
            public void onDateSelected(DateTime dateSelected) {
                endDate = dateSelected;
            }
        }).setDays(100).setOffset(0).init();
        pickerEnd.setDate(new DateTime());

        this.errorDate = v.findViewById(R.id.errorDate);
        this.tarifJournalier = v.findViewById(R.id.frag_tarif_journalier);
        this.book = v.findViewById(R.id.frag_btn_reserver);
        this.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tarif = !tarifJournalier.getText().toString().isEmpty() ? Integer.valueOf(tarifJournalier.getText().toString()) : 0;
                if ( beginDate.isAfter(endDate)) {
                    setInputErrorDate(getString(R.string.error_date));
                } else if (tarif <= 0){
                    setInputErrorDate("");
                    tarifJournalier.setError(getString(R.string.ChampInvalide));
                } else  {
                    mListener.onClickBook(beginDate, endDate, 5);
                }
            }
        });

        return v;
    }

    public void setInputErrorDate(String msg) {
        errorDate.setText(msg);
        if (msg.isEmpty()) {
            errorDate.setVisibility(View.GONE);
        } else {
            errorDate.setVisibility(View.VISIBLE);
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onClickBook(DateTime startDate, DateTime endDate, float tariJournalier);
        void onFragmentInteraction(Uri uri);
    }
}
