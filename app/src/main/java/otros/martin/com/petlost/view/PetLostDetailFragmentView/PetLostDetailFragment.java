package otros.martin.com.petlost.view.PetLostDetailFragmentView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.dummyCreatorEntities.DummyPetLost;

public class PetLostDetailFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;
    private ImageView ivPetLost;
    private TextView tvTitle, tvDescription;
    private Bundle bundle;

    public PetLostDetailFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_lost_detail, container, false);
        ivPetLost = view.findViewById(R.id.iv_pet_lost);
        tvTitle = view.findViewById(R.id.tv_title);
        tvDescription = view.findViewById(R.id.tv_description);
        bundle = getArguments();
        DummyPetLost.DummyItem petLost= (DummyPetLost.DummyItem) bundle.getSerializable("PetLost");
        if (petLost!=null){
            Picasso.get().load(petLost.urlImage)
                    .into(ivPetLost);
            tvTitle.setText(petLost.id);
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        /*if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /*public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }*/
}
