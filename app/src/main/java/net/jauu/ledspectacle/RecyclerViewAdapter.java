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
        viewHolder.url_path = item.url_path;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public final static class ModeViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        protected IMyViewHolderClicks mListener;
        protected ImageView imageView;
        protected ImageView playButton;
        protected TextView textView;
        protected String url_path;

        private static final String TAG = "ModeViewHolder";

        public ModeViewHolder(View itemView, IMyViewHolderClicks listener) {
            super(itemView);

            mListener = listener;

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(this);

            playButton = (ImageView) itemView.findViewById(R.id.send_icon);
            playButton.setOnClickListener(this);

            textView = (TextView) itemView.findViewById(R.id.mode_text);
            textView.setOnClickListener(this);

            this.setIsRecyclable(false);
        }

        @Override
        public void onClick(View v) {
            String full_url = "http://10.10.10.135" + this.url_path;
            Log.v(TAG, "full url-path: " + full_url);
            new RequestTask().execute(full_url);

/*

            if (v instanceof ImageView) {
                mListener.onTomato((ImageView) v);
            } else {
                mListener.onPotato(v);
            }
            */

        }

    }

    public static interface IMyViewHolderClicks {
        public void onPotato(View caller);
        public void onTomato(ImageView callerImage);
    }
}
