package com.ttopacademy.managers.real;

import android.os.Handler;
import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.managers.interfaces.TopicManager;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import com.ttopacademy.repositories.interfaces.TopicRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/** TopicManager implementation class. */
public class TopicManagerImpl implements TopicManager {

    private final CategorySubjectRepository categorySubjectRepository;
    private final CategorySubjectTopicRepository categorySubjectTopicRepository;
    private final TopicRepository topicRepository;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public TopicManagerImpl(CategorySubjectRepository categorySubjectRepository,
                            CategorySubjectTopicRepository categorySubjectTopicRepository,
                            TopicRepository topicRepository,
                            Executor executor, Handler resultHandler) {
        this.categorySubjectRepository = categorySubjectRepository;
        this.categorySubjectTopicRepository = categorySubjectTopicRepository;
        this.topicRepository = topicRepository;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getTopics(int categoryID, int subjectID, ResultCallback<List<Topic>> callback) {
        executor.execute(() -> {
            List<Topic> result = getTopicsSync(categoryID, subjectID);
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<Topic> getTopicsSync(int categoryID, int subjectID) {
        int categorySubjectID = categorySubjectRepository.getCategorySubjectID(categoryID, subjectID);
        List<CategorySubjectTopic> categorySubjectTopics
                = categorySubjectTopicRepository.getCategorySubjectTopics(categorySubjectID);
        List<Integer> topicIDs = new ArrayList<>();
        for (CategorySubjectTopic categorySubjectTopic : categorySubjectTopics){
            topicIDs.add(categorySubjectTopic.getTopicID());
        }
        return topicRepository.getTopics(topicIDs);
    }

    private void postResultToMainThread(final List<Topic> result,
                                        final ResultCallback<List<Topic>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
