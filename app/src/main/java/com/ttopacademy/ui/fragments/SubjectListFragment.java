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
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.ui.viewmodels.MainViewModel;
import com.ttopacademy.ui.viewmodels.MainViewModelImpl;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for showing subjects. */
@AndroidEntryPoint
public class SubjectListFragment extends Fragment {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;
    private ProgressBar progressBar;
    private List<Subject> subjects;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_subject_list, container, false);
        recyclerView = view.findViewById(R.id.subject_list_recyclerView);
        progressBar = view.findViewById(R.id.subject_list_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModelImpl.class);
        mainViewModel.getSubjectUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingSubjects()){
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressBar.setVisibility(View.GONE);
                    }
                    subjects = result.getSubjects();
                    updateUI();
                }
        );
    }

    private void updateUI() {
        subjectAdapter = new SubjectAdapter(subjects);
        recyclerView.setAdapter(subjectAdapter);
    }

    /** Navigates to the topics UI screen. */
    public void navigateToTopicListFragment(Subject subject){
        mainViewModel.setSelectedSubject(subject);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, TopicListFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)  // name can be null
                .commit();
    }

    private class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectHolder> {

        private List<Subject> subjects;
        public SubjectAdapter(List<Subject> subjects) {
            this.subjects = subjects;
        }

        private class SubjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            private Subject subject;

            public SubjectHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.subject_list_item_text_view);
                itemView.setOnClickListener(this);
            }

            public void bind(Subject subject){
                this.subject = subject;
                textView.setText(subject.getName());
            }

            @Override
            public void onClick(View view) {
                navigateToTopicListFragment(subject);
            }
        }

        @NonNull
        @Override
        public SubjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.subject_list_item, parent, false);
            return new SubjectHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SubjectHolder holder, int position) {
            holder.bind(subjects.get(position));
        }

        @Override
        public int getItemCount() {
            return subjects.size();
        }
    }
}

