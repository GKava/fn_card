package bar.appbarbottom.cardfn;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomLisrtAdapter extends RecyclerView.Adapter<CustomLisrtAdapter.ViewHolder>  {

    private ArrayList<ModelItems> items = new ArrayList<>();
    private static final String TAG = "MY LOG ADAPTER ";


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CustomLisrtAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder");
        final int pos = position;
        ModelItems item = items.get(position);
        holder.product.setText(item.getAuthor());
        holder.price.setText(String.valueOf(item.getPrice()));


        holder.mItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "position = " + pos, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

//        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

//    @Override
//    public void onClick(View view) {
//
//    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView product;
        private TextView price;
        private CardView mItemCard;


        public ViewHolder(View itemView) {
            super(itemView);
            product = (TextView) itemView.findViewById(R.id.title);
            price =(TextView) itemView.findViewById(R.id.price);
            mItemCard = (CardView) itemView.findViewById(R.id.mItemCard);

        }
        // установка теста, картинки внутрь
        public void bind(ModelItems modelItems) {
            Log.d(TAG, "bind");
            product.setText(modelItems.getAuthor());
            price.setText(modelItems.getPrice());
        }
    }

    public  void addMessage(ModelItems item) {
        Log.d(TAG, "addMessage");
        items.add(item);
        notifyItemChanged(items.size() - 1);
    }

    public  void deleteMessage() {
        Log.d(TAG, "deleteMessage");
        int pos = getItemCount();
        if (pos > 0) {
            for (int i = 0; i < pos; i++) {
                this.items.remove(0);
            }
            this.notifyItemRangeRemoved(0, pos);
        }
    }
}
