package com.ttopacademy.managers.real;

import android.os.Handler;
import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.managers.interfaces.SubjectManager;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/** SubjectManager implementation class. */
public class SubjectManagerImpl implements SubjectManager {

    private final CategorySubjectRepository categorySubjectRepository;
    private final SubjectRepository subjectRepository;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public SubjectManagerImpl(CategorySubjectRepository categorySubjectRepository,
                              SubjectRepository subjectRepository,
                              Executor executor, Handler resultHandler) {
        this.categorySubjectRepository = categorySubjectRepository;
        this.subjectRepository = subjectRepository;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getSubjects(int categoryID, ResultCallback<List<Subject>> callback) {
        executor.execute(() -> {
            List<Subject> result = getSubjectsSync(categoryID);
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<Subject> getSubjectsSync(int categoryID) {
        List<CategorySubject> categorySubjects = categorySubjectRepository.getCategorySubjects(categoryID);
        List<Integer> subjectIDs = new ArrayList<>();
        for (CategorySubject categorySubject : categorySubjects){
            subjectIDs.add(categorySubject.getSubjectID());
        }
        return subjectRepository.getSubjects(subjectIDs);
    }

    private void postResultToMainThread(final List<Subject> result,
                                        final ResultCallback<List<Subject>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
