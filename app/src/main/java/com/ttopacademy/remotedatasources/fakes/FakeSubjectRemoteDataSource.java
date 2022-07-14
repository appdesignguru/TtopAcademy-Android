package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.SubjectResponse;
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Subject remote data source implementation class. Used for unit testing only. */
public class FakeSubjectRemoteDataSource implements SubjectRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeSubjectRemoteDataSource() {

    }

    @Override
    public Result<List<SubjectResponse>> getAllSubjects() {
        List<SubjectResponse> mockSubjectResponses = new ArrayList<>();
        mockSubjectResponses.add(new SubjectResponse(1, 1, "Physics"));
        mockSubjectResponses.add(new SubjectResponse(2, 2, "Chemistry"));

        return new Result.Success<>(mockSubjectResponses);
    }
}
