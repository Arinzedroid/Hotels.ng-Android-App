package ng.hotels.android.app.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.hotels.android.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


    @OnClick(R.id.text_forgot_password)
    public void clickForgotPassword(){
        Toast.makeText(getActivity(), "Yet to be implemented", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.text_sign_up)
    public void openSignUpFragment(){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_user_authentication,new SignupFragment())
                .commit();
    }

}
