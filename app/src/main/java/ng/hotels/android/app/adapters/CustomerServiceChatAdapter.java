package ng.hotels.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

/**
 * Created by idee on 10/5/17.
 */

public class CustomerServiceChatAdapter extends RecyclerView.Adapter<CustomerServiceChatAdapter.ViewHolder> {

    private Context context;

    @Inject
    public CustomerServiceChatAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_customer_service_chat, parent, false);
        ViewHolder viewHolder = new   ViewHolder(view);
        viewHolder.getAdapterPosition();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.textView.getLayoutParams();
        holder.textView.setText("Hello world");
        switch (position) {

            case 0:
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                holder.textView.setTextColor(context.getResources().getColor(R.color.white));
                holder.textView.setBackgroundResource(R.drawable.rounded_corner_customer_chat_textview_blue);
                break;
            case 1:

                break;
            case 2:
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                holder.textView.setTextColor(context.getResources().getColor(R.color.white));
                holder.textView.setBackgroundResource(R.drawable.rounded_corner_customer_chat_textview_blue);
                break;
            case 3:

                break;
            case 4:
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                holder.textView.setTextColor(context.getResources().getColor(R.color.white));
                holder.textView.setBackgroundResource(R.drawable.rounded_corner_customer_chat_textview_blue);
                break;
            case 5:

                break;

        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_custom_row_customer_service_chat)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
