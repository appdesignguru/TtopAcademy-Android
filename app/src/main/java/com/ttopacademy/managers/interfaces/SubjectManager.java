package com.ttopacademy.managers.interfaces;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Subject;
import java.util.List;

/** Interface for managing subjects. */
public interface SubjectManager {

    /** Returns and posts the subjects for given parameter to the callback.
     *  This should be called on the main thread.
     *  For other threads, call getSubjectsSync() instead. */
    void getSubjects(int categoryID, ResultCallback<List<Subject>> callback);

    /** Returns the subjects for given parameter. */
    List<Subject> getSubjectsSync(int categoryID);
}
