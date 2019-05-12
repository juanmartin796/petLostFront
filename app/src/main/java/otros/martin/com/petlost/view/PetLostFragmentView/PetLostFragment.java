package otros.martin.com.petlost.view.PetLostFragmentView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.dummyCreatorEntities.DummyPetLost;
import otros.martin.com.petlost.dummyCreatorEntities.DummyPetLost.DummyItem;

public class PetLostFragment extends Fragment {
    private OnListFragmentPetLostInteractionListener mListener;

    public PetLostFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_petlost_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            recyclerView.setAdapter(new MyPetLostRecyclerViewAdapter(getContext(), DummyPetLost.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentPetLostInteractionListener) {
            mListener = (OnListFragmentPetLostInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentVeterinaryInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentPetLostInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
