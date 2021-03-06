package otros.martin.com.petlost.view.VeterinaryFragmentView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.dummyCreatorEntities.DummyVeterinary.DummyItem;
import otros.martin.com.petlost.utils.PicassoService;

import java.util.List;

public class MyveterinaryRecyclerViewAdapter extends RecyclerView.Adapter<MyveterinaryRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final VeterinaryFragment.OnListFragmentVeterinaryInteractionListener mListener;
    private final Context mContext;

    public MyveterinaryRecyclerViewAdapter(Context context, List<DummyItem> items, VeterinaryFragment.OnListFragmentVeterinaryInteractionListener listener) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_veterinary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

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
        PicassoService.getInstance().run(mContext, mValues.get(position).urlVerinaryLogo, holder.mIvVeterinaryLogo);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mIdView;
        private final TextView mContentView;
        private DummyItem mItem;
        private ImageView mIvVeterinaryLogo;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.tv_name_veterinary);
            mContentView = view.findViewById(R.id.tv_address_veterinary);
            mIvVeterinaryLogo = view.findViewById(R.id.iv_veterinary_logo);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }


}
