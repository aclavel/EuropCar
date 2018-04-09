package com.example.alexis.projeteuropcar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexis.projeteuropcar.R;

public class UpdateAgenceFragment extends Fragment {

    private EditText raisonSociale;
    private EditText siret;
    private EditText voie;
    private EditText codePostal;
    private EditText ville;
    private Button btnAdd;

    private OnUpdateAgenceFragmentListener mListener;

    public UpdateAgenceFragment() {

    }

    public static UpdateAgenceFragment newInstance(String param1, String param2) {
        UpdateAgenceFragment fragment = new UpdateAgenceFragment();
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
        View v = inflater.inflate(R.layout.fragment_update_agence, container, false);

        this.raisonSociale = v.findViewById(R.id.agence_raison_sociale);
        this.siret = v.findViewById(R.id.agence_siret);
        this.voie = v.findViewById(R.id.agence_voie);
        this.codePostal = v.findViewById(R.id.agence_cp);
        this.ville = v.findViewById(R.id.agence_ville);
        this.btnAdd = v.findViewById(R.id.agence_btn_submit);

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (raisonSociale.getText().toString() == ""){raisonSociale.setError("Veuillez remplir ce champ");}
                if (siret.getText().toString() == ""){siret.setError("Veuillez remplir ce champ");}
                if (voie.getText().toString() == ""){voie.setError("Veuillez remplir ce champ");}
                if (codePostal.getText().toString() == ""){codePostal.setError("Veuillez remplir ce champ");}
                if (ville.getText().toString() == ""){ville.setError("Veuillez remplir ce champ");}

                if(raisonSociale.getText().toString() != "" && siret.getText().toString() != "" && voie.getText().toString() != "" && codePostal.getText().toString() != "" && ville.getText().toString() != "") {
                    mListener.onUpdateAgenceFragmentListener();
                }
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUpdateAgenceFragmentListener) {
            mListener = (OnUpdateAgenceFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnUpdateAgenceFragmentListener {
        void onUpdateAgenceFragmentListener();
    }
}
