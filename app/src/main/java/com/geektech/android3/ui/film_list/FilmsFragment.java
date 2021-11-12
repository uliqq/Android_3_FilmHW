package com.geektech.android3.ui.film_list;

import android.os.Binder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.geektech.android3.App;
import com.geektech.android3.R;
import com.geektech.android3.data.models.Films;
import com.geektech.android3.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment implements FilmsAdapter.OnItemClickListener {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new FilmsAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createDivider();
        binding.recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        App.api.getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilms(response.body());
                } else {
                    Log.e("TAG", "onFailure: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void createDivider() {

        binding.recycler.addItemDecoration(new DividerItemDecoration(binding.recycler.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void OnItemClick(int pos) {
        Log.e("TAG", "onItemChosen");
        String id = adapter.getItem(pos).getId();
        Bundle bundle = new Bundle();
        bundle.putString("key", id);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.filmDetailFragment, bundle);
    }
}