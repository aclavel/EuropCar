package com.example.alexis.projeteuropcar.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexis.projeteuropcar.Activity.InscriptionActivity;
import com.example.alexis.projeteuropcar.R;
import com.example.alexis.projeteuropcar.Utils.MethodsUtils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InscriptionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InscriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InscriptionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText mail;
    private EditText password;
    private EditText confirmPassword;
    private EditText token;
    private Button btnRegister;

    private OnFragmentInteractionListener mListener;

    public InscriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InscriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InscriptionFragment newInstance(String param1, String param2) {
        InscriptionFragment fragment = new InscriptionFragment();
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
        View v = inflater.inflate(R.layout.fragment_inscription, container, false);

        this.mail = v.findViewById(R.id.mail);
        this.password = v.findViewById(R.id.password);
        this.confirmPassword = v.findViewById(R.id.confirmPassword);
        this.token = v.findViewById(R.id.token_register);
        this.btnRegister = v.findViewById(R.id.btnRegister);

        InscriptionActivity inscriptionActivity = (InscriptionActivity) getActivity();
        inscriptionActivity.getLoginFromConnexion(mail,password);

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
        void onRegisterInteraction(String mail, String password, String confirmPassword,String token);
    }
}
