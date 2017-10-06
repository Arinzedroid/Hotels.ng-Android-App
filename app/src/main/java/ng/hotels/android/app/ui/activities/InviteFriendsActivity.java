package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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
    @BindView(R.id.invite_image)
    ImageView inviteImage;
    @BindView(R.id.logo)
    ImageView logo;

    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        ButterKnife.bind(this);

        inviteButton.setOnClickListener(this);
        inviteCode.setOnClickListener(this);
        termOfUse.setOnClickListener(this);

        Picasso.with(this)
                .load("http://res.cloudinary.com/lanre01/image/upload/v1507308073/invite4_2_p4hfjz.png")
                .fit()
                .placeholder(R.drawable.hotel_img2)
                .into(inviteImage);

        Picasso.with(this)
                .load("http://res.cloudinary.com/lanre01/image/upload/v1507308075/gift2_bqqjvi.png\n")
                .fit()
                .into(logo);
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
