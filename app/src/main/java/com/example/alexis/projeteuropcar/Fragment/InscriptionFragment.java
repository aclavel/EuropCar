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
import android.widget.Toast;

import com.example.alexis.projeteuropcar.Activity.InscriptionActivity;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Utils.MethodsUtils;

public class InscriptionFragment extends Fragment {

    private EditText mail;
    private EditText password;
    private EditText confirmPassword;
    private EditText token;
    private Button btnRegister;

    private OnFragmentInteractionListener mListener;

    public InscriptionFragment() {

    }

    public static InscriptionFragment newInstance(String param1, String param2) {
        InscriptionFragment fragment = new InscriptionFragment();
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
        View v = inflater.inflate(R.layout.fragment_inscription, container, false);

        this.mail = v.findViewById(R.id.mail);
        this.password = v.findViewById(R.id.password);
        this.confirmPassword = v.findViewById(R.id.confirmPassword);
        this.token = v.findViewById(R.id.token_register);
        this.btnRegister = v.findViewById(R.id.btnRegister);

        InscriptionActivity activity = (InscriptionActivity) getActivity();
        mail.setText(activity.getMailConnexion());
        password.setText(activity.getPasswordConnexion());

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = mail.getText().toString();
                String passwordText = password.getText().toString();
                String confirmPasswordText = confirmPassword.getText().toString();
                String tokenText = token.getText().toString();


                MethodsUtils methodsUtils = new MethodsUtils();
                if (!methodsUtils.checkMail(emailText)) {
                    mail.setError("Email incorrect");
                } else if (passwordText.isEmpty()) {
                    password.setError("Veuillez remplir ce champ");
                } else if (!passwordText.equals(confirmPasswordText)) {
                    confirmPassword.setError("Mot de passe non identique");
                } else if (tokenText.isEmpty()) {
                    token.setError("Code invalide");
                } else {
                    mListener.onRegisterInteraction(emailText,passwordText,confirmPasswordText,tokenText);
                }
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
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
        void onRegisterInteraction(String mail, String password, String confirmPassword,String token);
    }
}
