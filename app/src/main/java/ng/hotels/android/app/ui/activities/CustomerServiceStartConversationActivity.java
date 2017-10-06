package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.hotels.android.app.R;

public class CustomerServiceStartConversationActivity extends AppCompatActivity {

    @BindView(R.id.button_start_conversation_customer_service_chat)
    Button buttonStartConversation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service_start_conversation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_start_conversation_customer_service_chat)
    public void startConversation(){
        startActivity(new Intent(this,CustomerServiceChatActivity.class));
    }

}
