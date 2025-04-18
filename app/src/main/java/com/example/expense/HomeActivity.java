package com.example.expense;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;

import com.example.expense.databinding.ActivityHomeBinding;
import com.example.expense.fragment.AddExpenseFragment;
import com.example.expense.fragment.ExpenseListFragment;
import com.example.expense.fragment.HomeFragment;
import com.example.expense.fragment.SettingFragment;

public class HomeActivity extends BaseActivity{

   public ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                LoadFragment(new HomeFragment());
            } else if (itemId == R.id.nav_add) {
                LoadFragment(new AddExpenseFragment());
            } else if (itemId == R.id.nav_detail) {
                LoadFragment(new ExpenseListFragment());
            } else if (itemId == R.id.nav_setting) {
                LoadFragment(new SettingFragment());
            }else {
                return false;
            }
            return true;
        });

        if(savedInstanceState == null){
            binding.bottomNavigation.setSelectedItemId(R.id.nav_home);
        }else{
            binding.bottomNavigation.setSelectedItemId(savedInstanceState.getInt("selectedItemId"));
        }

    }
    public void LoadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
    public void showProgressBar() {
        binding.loadingBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        binding.loadingBar.setVisibility(View.GONE);
    }

}
