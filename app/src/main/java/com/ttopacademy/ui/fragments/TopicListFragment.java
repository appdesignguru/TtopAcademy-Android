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
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.ui.viewmodels.FakeMainViewModel;
import com.ttopacademy.ui.viewmodels.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for showing topics. */
@AndroidEntryPoint
public class TopicListFragment extends Fragment {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TopicAdapter topicAdapter;
    private List<Topic> topics;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_topic_list, container, false);
        recyclerView = view.findViewById(R.id.topic_list_recyclerView);
        progressBar = view.findViewById(R.id.topic_list_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getTopicUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingTopics()){
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressBar.setVisibility(View.GONE);
                    }
                    topics = result.getTopics();
                    updateUI();
                }
        );
    }

    private void updateUI() {
        topicAdapter = new TopicAdapter(topics);
        recyclerView.setAdapter(topicAdapter);
    }

    /** Navigates to the videos UI screen. */
    public void navigateToVideoListFragment(Topic topic){
        mainViewModel.setSelectedTopic(topic);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, VideoListFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)  // name can be null
                .commit();
    }

    private class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder> {

        private List<Topic> topics;

        public TopicAdapter(List<Topic> topics) {
            this.topics = topics;
        }

        private class TopicHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            private Topic topic;

            public TopicHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.topic_list_item_text_view);
                itemView.setOnClickListener(this);
            }

            public void bind(Topic topic){
                this.topic = topic;
                textView.setText(topic.getName());
            }

            @Override
            public void onClick(View view) {
                navigateToVideoListFragment(topic);
            }
        }

        @NonNull
        @Override
        public TopicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.topic_list_item, parent, false);
            return new TopicHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TopicHolder holder, int position) {
            holder.bind(topics.get(position));
        }

        @Override
        public int getItemCount() {
            return topics.size();
        }
    }
}

