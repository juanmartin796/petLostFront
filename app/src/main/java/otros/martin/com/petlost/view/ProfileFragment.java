package otros.martin.com.petlost.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.view.VeterinaryFragmentView.VeterinaryFragment;

public class ProfileFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;

    public ProfileFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_profile, container, false);

        return inflate;
    }

    private void changeFragment(Fragment fragmenNew){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_in_main);
        if (currentFragment==null || currentFragment.getClass() != fragmenNew.getClass()){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft.replace(R.id.fragment_in_main, fragmenNew, fragmenNew.toString());
            if (currentFragment!=null) {
                fragmentManager.popBackStack();
                ft.addToBackStack(fragmenNew.toString());
            }
            ft.commit();
        }
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
