package com.ttopacademy.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ttopacademy.R;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.ui.viewmodels.FakeMainViewModel;
import com.ttopacademy.ui.viewmodels.MainViewModel;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for watching video. */
@AndroidEntryPoint
public class VideoFragment extends Fragment {

    private TextView youtubeID;
    private TextView videoTitle, videoSize;
    private Button takePracticeQuestion;
    private Video video;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        youtubeID = view.findViewById(R.id.video_youtube_ID);
        videoTitle = view.findViewById(R.id.video_title);
        videoSize = view.findViewById(R.id.video_size);
        takePracticeQuestion = view.findViewById(R.id.take_practice_question);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getVideoItemUiState().observe(
                getViewLifecycleOwner(), result -> {
                    video = result.getSelectedVideo();
                    updateUI();
                }
        );
    }

    private void updateUI() {
        String title = "Video Title: " + video.getTitle();
        String size = "Video Size: " + video.getSize() + "MB";
        youtubeID.setText(video.getYoutubeID());
        videoTitle.setText(title);
        videoSize.setText(size);
    }
}

