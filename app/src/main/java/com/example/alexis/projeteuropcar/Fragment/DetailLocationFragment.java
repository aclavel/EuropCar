package com.example.alexis.projeteuropcar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.alexis.projeteuropcar.BO.Location;
import com.example.alexis.projeteuropcar.BO.Retour;
import com.example.alexis.projeteuropcar.R;

public class DetailLocationFragment extends Fragment {

    private CheckBox isEndommage;
    private CheckBox pleinFait;
    private EditText kilometrage;
    private Button btnAddPhoto;
    private Button btnRendre;

    private OnDetailLocationFragmentInteractionListener mListener;

    public DetailLocationFragment() {

    }

    public static DetailLocationFragment newInstance(String param1, String param2) {
        DetailLocationFragment fragment = new DetailLocationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rendu, container, false);

        this.isEndommage = v.findViewById(R.id.frag_rendu_endommage);
        this.pleinFait = v.findViewById(R.id.frag_rendu_plein_fait);
        this.kilometrage = v.findViewById(R.id.frag_rendu_kilometrage);
        this.btnAddPhoto = v.findViewById(R.id.frag_btn_add_photo);
        this.btnRendre = v.findViewById(R.id.frag_btn_rendre);

        final Retour retour = new Retour(
                new Location(),
                this.isEndommage.isChecked(),
                this.pleinFait.isChecked(),
                this.kilometrage.getText().toString(),
                ""
        );

        btnRendre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kilometrageText = kilometrage.getText().toString();

                if (kilometrageText.isEmpty()){
                    kilometrage.setError(getString(R.string.ChampInvalide));
                } else {
                    mListener.onClickBtnRendre(retour);
                }
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDetailLocationFragmentInteractionListener) {
            mListener = (OnDetailLocationFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnDetailLocationFragmentInteractionListener {
        void onClickBtnRendre(Retour retour);
    }
}
