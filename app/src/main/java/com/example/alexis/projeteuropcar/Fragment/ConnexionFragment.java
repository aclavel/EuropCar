package com.example.alexis.projeteuropcar.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Utils.MethodsUtils;

public class ConnexionFragment extends Fragment {

    private EditText mail;
    private EditText password;
    private Button btnConnexion;
    private Button btnRegister;

    private OnFragmentInteractionListener mListener;

    public ConnexionFragment() {

    }


    public static ConnexionFragment newInstance(String param1, String param2) {
        ConnexionFragment fragment = new ConnexionFragment();
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
        View v = inflater.inflate(R.layout.fragment_connexion, container, false);

        this.mail = v.findViewById(R.id.mail);
        this.password = v.findViewById(R.id.password);
        this.btnConnexion = v.findViewById(R.id.btnConnexion);
        this.btnRegister = v.findViewById(R.id.btnRegister);

        this.mail.setText("test@test.test");
        this.password.setText("Pa$$w0rd");

        this.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = mail.getText().toString();
                String passwordText = password.getText().toString();

                MethodsUtils methodsUtils = new MethodsUtils();
                if (!methodsUtils.checkMail(emailText)) {
                    mail.setError("Email incorrect");
                } else if (passwordText.isEmpty()) {
                    password.setError("Mot de passe incorrect");
                } else {
                    mListener.onConnextionInteraction(emailText,passwordText);
                }
            }
        });

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onRegisterInteraction(
                        mail.getText().toString(),
                        password.getText().toString()
                );
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onConnextionInteraction(String mail, String password);
        void onRegisterInteraction(String mail, String password);
    }
}
