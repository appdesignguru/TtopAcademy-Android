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
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.ui.viewmodels.FakeMainViewModel;
import com.ttopacademy.ui.viewmodels.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for showing categories. */
@AndroidEntryPoint
public class CategoryListFragment extends Fragment {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private ProgressBar progressBar;
    private List<Category> categories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        recyclerView = view.findViewById(R.id.category_list_recyclerView);
        progressBar = view.findViewById(R.id.category_list_progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getCategoryUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingCategories()){
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressBar.setVisibility(View.GONE);
                    }
                    categories = result.getCategories();
                    updateUI();
                }
        );
    }

    private void updateUI() {
        categoryAdapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(categoryAdapter);
    }

    /** Navigates to the subjects UI screen. */
    public void navigateToSubjectListFragment(Category category){
        mainViewModel.setSelectedCategory(category);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, SubjectListFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)  // name can be null
                .commit();
    }

    private class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

        private List<Category> categories;

        public CategoryAdapter(List<Category> categories){
            this.categories = categories;
        }

        private class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            private Category category;

            public CategoryHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                textView = itemView.findViewById(R.id.category_list_item_text_view);
            }

            public void bind(Category category){
                this.category = category;
                textView.setText(category.getName());
            }

            @Override
            public void onClick(View view) {
                navigateToSubjectListFragment(category);
            }
        }

        @NonNull
        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.category_list_item, viewGroup, false);

            return new CategoryHolder(view);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, final int position) {
            holder.bind(categories.get(position));
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }
    }
}

