package com.ttopacademy.repositories.real;

import android.os.Handler;
import com.ttopacademy.core.Result;
import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse;
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource;
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/** PracticeQuestionRepository implementation class. */
public class PracticeQuestionRepositoryImpl implements PracticeQuestionRepository {

    private final PracticeQuestionLocalDataSource practiceQuestionLocalDataSource;
    private final PracticeQuestionRemoteDataSource practiceQuestionRemoteDataSource;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public PracticeQuestionRepositoryImpl(
            PracticeQuestionLocalDataSource practiceQuestionLocalDataSource,
            PracticeQuestionRemoteDataSource practiceQuestionRemoteDataSource,
            Executor executor, Handler resultHandler) {
        this.practiceQuestionLocalDataSource = practiceQuestionLocalDataSource;
        this.practiceQuestionRemoteDataSource = practiceQuestionRemoteDataSource;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getPracticeQuestions(String subjectName, int videoID, ResultCallback<List<PracticeQuestion>> callback) {
        executor.execute(() -> {
            List<PracticeQuestion> result = getPracticeQuestionsSync(subjectName, videoID);
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestionsSync(String subjectName, int videoID) {
        if (practiceQuestionLocalDataSource.hasOutdatedPracticeQuestions(subjectName, videoID)){
            refreshPracticeQuestions(subjectName, videoID);
        }
        return practiceQuestionLocalDataSource.getPracticeQuestions(subjectName, videoID);
    }

    private void refreshPracticeQuestions(String subjectName, int videoID){
        Result<List<PracticeQuestionResponse>>  result
                = practiceQuestionRemoteDataSource.getPracticeQuestions(subjectName, videoID);
        if (result instanceof Result.Success){
            List<PracticeQuestionResponse> practiceQuestionResponses
                    = ((Result.Success<List<PracticeQuestionResponse>>) result).data;
            updatePracticeQuestionLocalDataSource(practiceQuestionResponses);
        }
    }

    private void updatePracticeQuestionLocalDataSource(List<PracticeQuestionResponse> practiceQuestionResponses){
        List<PracticeQuestion> practiceQuestions = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (PracticeQuestionResponse practiceQuestionResponse : practiceQuestionResponses){
            practiceQuestions.add(new PracticeQuestion(
                    practiceQuestionResponse.getPracticeQuestionID(), practiceQuestionResponse.getVideoID(),
                    practiceQuestionResponse.getQuestionNumber(), practiceQuestionResponse.getQuestion(),
                    practiceQuestionResponse.getOptionA(), practiceQuestionResponse.getOptionB(),
                    practiceQuestionResponse.getOptionC(), practiceQuestionResponse.getOptionD(),
                    practiceQuestionResponse.getCorrectOption(), dateSavedToLocalDatabase
            ));
        }
        practiceQuestionLocalDataSource.savePracticeQuestions(practiceQuestions);
    }

    private void postResultToMainThread(final List<PracticeQuestion> result,
                                        final ResultCallback<List<PracticeQuestion>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
