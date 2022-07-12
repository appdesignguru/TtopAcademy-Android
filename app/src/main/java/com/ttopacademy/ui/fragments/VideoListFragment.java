package com.ttopacademy.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ttopacademy.R;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.ui.viewmodels.FakeMainViewModel;
import com.ttopacademy.ui.viewmodels.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for showing list of videos. */
@AndroidEntryPoint
public class VideoListFragment extends Fragment {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private ProgressBar progressBar;
    private List<Video> videos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_video_list, container, false);
        recyclerView = view.findViewById(R.id.video_list_recyclerView);
        progressBar = view.findViewById(R.id.video_list_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getVideoUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingVideos()){
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressBar.setVisibility(View.GONE);
                    }
                    videos = result.getVideos();
                    updateUI();
                }
        );
    }

    private void updateUI(){
        videoAdapter = new VideoAdapter(videos);
        recyclerView.setAdapter(videoAdapter);
    }

    /** Navigates to the videos UI screen. */
    public void navigateToVideoFragment(Video video){
        mainViewModel.setSelectedVideo(video);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, VideoFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)  // name can be null
                .commit();
    }


    private class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

        private List<Video> videos;

        public VideoAdapter(List<Video> videos) {
            this.videos = videos;
        }

        private class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            private  Video video;

            public VideoHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.video_list_item_text_view);
                itemView.setOnClickListener(this);
            }

            public void bind (Video video){
                this.video = video;
                textView.setText(video.getTitle());
            }

            @Override
            public void onClick(View view) {
                navigateToVideoFragment(video);
            }
        }

        @NonNull
        @Override
        public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_list_item, parent, false);
            return new VideoHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
            holder.bind(videos.get(position));
        }

        @Override
        public int getItemCount() {
            return videos.size();
        }
    }
}

