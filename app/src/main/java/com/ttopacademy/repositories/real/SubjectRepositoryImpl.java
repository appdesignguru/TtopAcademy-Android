package com.ttopacademy.repositories.real;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import com.ttopacademy.remotedatasources.entities.SubjectResponse;
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource;
import com.ttopacademy.repositories.interfaces.SubjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** SubjectRepository implementation class. */
public class SubjectRepositoryImpl implements SubjectRepository {

    private final SubjectLocalDataSource subjectLocalDataSource;
    private final SubjectRemoteDataSource subjectRemoteDataSource;

    /** Constructs a new instance. */
    @Inject
    public SubjectRepositoryImpl(SubjectLocalDataSource subjectLocalDataSource,
                                 SubjectRemoteDataSource subjectRemoteDataSource) {
        this.subjectLocalDataSource = subjectLocalDataSource;
        this.subjectRemoteDataSource = subjectRemoteDataSource;
    }

    @Override
    public List<Subject> getSubjects(List<Integer> subjectIDs) {
        if (subjectLocalDataSource.isOutdated()){
            refreshSubjects();
        }
        return subjectLocalDataSource.getSubjects(subjectIDs);
    }

    private void refreshSubjects(){
        Result<List<SubjectResponse>> result = subjectRemoteDataSource.getAllSubjects();
        if (result instanceof Result.Success){
            List<SubjectResponse> subjectResponses = ((Result.Success<List<SubjectResponse>>) result).data;
            updateSubjectLocalDataSource(subjectResponses);
        }
    }

    private void updateSubjectLocalDataSource(List<SubjectResponse> subjectResponses){
        subjectLocalDataSource.deleteAllSubjects();
        List<Subject> subjects = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (SubjectResponse subjectResponse : subjectResponses){
            subjects.add(new Subject(subjectResponse.getSubjectID(), subjectResponse.getNumber(),
                    subjectResponse.getName(), dateSavedToLocalDatabase));
        }
        subjectLocalDataSource.saveSubjects(subjects);
    }
}

