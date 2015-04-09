package net.jauu.ledspectacle;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ModeViewHolder> {

    private List<ModeData> items;
    private static final String TAG = "RecyclerViewAdapter";

    RecyclerViewAdapter(List<ModeData> aitems) {
        if (aitems == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        items = aitems;
    }

    @Override
    public ModeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_demo, viewGroup, false);

        ModeViewHolder vh = new ModeViewHolder(itemView, new RecyclerViewAdapter.IMyViewHolderClicks() {
            public void onPotato(View caller) {
                Log.v(TAG, "View click");
            }
            public void onTomato(ImageView callerImage) {
                Log.v(TAG, callerImage.toString());
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ModeViewHolder viewHolder, int position) {
        ModeData item = items.get(position);
        viewHolder.imageView.setImageResource(item.image);
        viewHolder.textView.setText(item.name);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public final static class ModeViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        protected IMyViewHolderClicks mListener;
        protected ImageView imageView;
        protected TextView textView;

        public ModeViewHolder(View itemView, IMyViewHolderClicks listener) {
            super(itemView);

            mListener = listener;

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(this);

            textView = (TextView) itemView.findViewById(R.id.mode_text);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof ImageView) {
                mListener.onTomato((ImageView) v);
            } else {
                mListener.onPotato(v);
            }

        }

    }

    public static interface IMyViewHolderClicks {
        public void onPotato(View caller);
        public void onTomato(ImageView callerImage);
    }
}
