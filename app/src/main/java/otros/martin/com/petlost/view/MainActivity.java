package otros.martin.com.petlost.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.view.PetLostDetailFragmentView.PetLostDetailFragment;
import otros.martin.com.petlost.view.PetLostFragmentView.PetLostFragment;
import otros.martin.com.petlost.dummyCreatorEntities.DummyPetLost;
import otros.martin.com.petlost.view.VeterinaryFragmentView.VeterinaryFragment;
import otros.martin.com.petlost.dummyCreatorEntities.DummyVeterinary;

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
                    changeFragment(new ProfileFragment());
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
        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterNewPetLost.class);
                startActivity(intent);
            }
        });
    }

    private void changeFragment(Fragment fragmenNew){
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
    @Override
    public void onListFragmentInteraction(DummyPetLost.DummyItem item) {
        PetLostDetailFragment fragmentPetLostDetail = new PetLostDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PetLost", item);
        fragmentPetLostDetail.setArguments(bundle);
        changeFragment(fragmentPetLostDetail);
    }

    @Override
    public void onListFragmentInteraction(DummyVeterinary.DummyItem item) {

    }
}
