package otros.martin.com.petlost.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.view.PetLostFragmentView.PetLostFragment;
import otros.martin.com.petlost.view.PetLostFragmentView.dummy.DummyContent;
import otros.martin.com.petlost.view.VeterinaryFragmentView.VeterinaryFragment;

public class MainActivity extends AppCompatActivity implements PetLostFragment.OnListFragmentPetLostInteractionListener, VeterinaryFragment.OnListFragmentVeterinaryInteractionListener {

    private FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(new PetLostFragment());
                    return true;
                case R.id.navigation_dashboard:
                    changeFragment(new PetLostFragment());
                    return true;
                case R.id.navigation_notifications:
                    changeFragment(new VeterinaryFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();
        changeFragment(new PetLostFragment());
    }

    private void initComponents() {
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager  = getSupportFragmentManager();
    }

    private void changeFragment(Fragment fragmenNew){
        Fragment fra = fragmentManager.findFragmentById(R.id.fragment_in_main);
        if (fra==null || fra.getClass() != fragmenNew.getClass()){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            ft.replace(R.id.fragment_in_main, fragmenNew, fragmenNew.getTag());
            ft.commit();
        }

    }
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(otros.martin.com.petlost.view.VeterinaryFragmentView.dummy.DummyContent.DummyItem item) {

    }
}
