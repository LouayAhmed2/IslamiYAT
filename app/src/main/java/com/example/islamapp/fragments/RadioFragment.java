package com.example.islamapp.fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamapp.R;
import com.example.islamapp.adapters.RadioChannelsAdapter;
import com.example.islamapp.apis.ApiManager;
import com.example.islamapp.model.radiosResponse.RadiosItem;
import com.example.islamapp.model.radiosResponse.RadiosResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {


    RecyclerView recyclerView;
    ProgressBar progressBar;
    RadioChannelsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    MediaPlayer mediaPlayer;

    public RadioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);
        initRecyclerView();
        getRadioChannels();
    }

    private void initRecyclerView() {
        adapter = new RadioChannelsAdapter(null);
        adapter.setOnPlayClickListener(new RadioChannelsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem item) {
                playRadio(item.getRadioUrl());
            }
        });
        adapter.setOnStopClickListener(new RadioChannelsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem item) {
                stopRadio();
            }
        });
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
    }

    private void stopRadio() {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();

    }

    private void playRadio(String radioUrl) {
        stopRadio();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(radioUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void getRadioChannels() {
        ApiManager.getApis()
                .getRadioChannels()
                .enqueue(new Callback<RadiosResponse>() {
                    @Override
                    public void onResponse(Call<RadiosResponse> call,
                                           Response<RadiosResponse> response) {
                        progressBar.setVisibility(View.GONE);
                        List<RadiosItem> channels =
                                response.body().getRadios();
                        adapter.changeData(channels);

                    }

                    @Override
                    public void onFailure(Call<RadiosResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "something went wrong"
                                , Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
