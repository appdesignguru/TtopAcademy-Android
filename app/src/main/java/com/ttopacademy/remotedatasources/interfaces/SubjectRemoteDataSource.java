package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.SubjectResponse;
import java.util.List;

/** Subject remote data source interface. */
public interface SubjectRemoteDataSource {

    /** Returns subject responses. */
    Result<List<SubjectResponse>> getAllSubjects();
}
