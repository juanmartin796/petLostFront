package otros.martin.com.petlost.view.PetLostFragmentView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.view.PetLostFragmentView.PetLostFragment.OnListFragmentPetLostInteractionListener;
import otros.martin.com.petlost.view.PetLostFragmentView.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyPetLostRecyclerViewAdapter extends RecyclerView.Adapter<MyPetLostRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentPetLostInteractionListener mListener;

    public MyPetLostRecyclerViewAdapter(List<DummyItem> items, OnListFragmentPetLostInteractionListener listener) {
        mValues = items;
        mListener = listener;
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
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private DummyItem mItem;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_title);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
