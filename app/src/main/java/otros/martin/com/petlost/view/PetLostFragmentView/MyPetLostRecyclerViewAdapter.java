package otros.martin.com.petlost.view.PetLostFragmentView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.view.MainActivity;
import otros.martin.com.petlost.view.PetLostFragmentView.PetLostFragment.OnListFragmentPetLostInteractionListener;
import otros.martin.com.petlost.view.PetLostFragmentView.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyPetLostRecyclerViewAdapter extends RecyclerView.Adapter<MyPetLostRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentPetLostInteractionListener mListener;
    private final Context mContext;

    public MyPetLostRecyclerViewAdapter(Context context, List<DummyItem> items, OnListFragmentPetLostInteractionListener listener) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_petlost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
        /*Glide.with(mContext)
                .load(mValues.get(position).urlImage)
                .override(Target.SIZE_ORIGINAL)
                .into(holder.mIvPetLost);*/
        Picasso.get().load(mValues.get(position).urlImage)
                .into(holder.mIvPetLost);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private DummyItem mItem;
        private ImageView mIvPetLost;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_title);


            mIvPetLost = view.findViewById(R.id.iv_pet_lost);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
