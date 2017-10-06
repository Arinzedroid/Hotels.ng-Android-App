package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

public class InviteFriendsActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.invite_button)
    Button inviteButton;
    @BindView(R.id.invite_code)
    TextView inviteCode;
    @BindView(R.id.term_of_use)
    TextView termOfUse;

    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        ButterKnife.bind(this);

        inviteButton.setOnClickListener(this);
        inviteCode.setOnClickListener(this);
        termOfUse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.invite_button:
                inviteFriends();
                break;
            case R.id.invite_code:
                setInviteCode();
                break;
            case R.id.term_of_use:
                displayTermOfUse();
                break;
        }
    }

    private void displayTermOfUse() {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(this, "Term of use selected, not implemented yet", Toast.LENGTH_LONG);
        mToast.show();
    }

    private void setInviteCode() {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(this, "Invite code selected", Toast.LENGTH_LONG);
        mToast.show();
    }

    private void inviteFriends() {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(this, "Invite of friend selected, not implemented yet", Toast.LENGTH_LONG);
        mToast.show();
    }
}
