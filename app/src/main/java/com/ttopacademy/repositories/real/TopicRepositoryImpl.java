package com.ttopacademy.repositories.real;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import com.ttopacademy.remotedatasources.entities.TopicResponse;
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource;
import com.ttopacademy.repositories.interfaces.TopicRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** TopicRepository implementation class. */
public class TopicRepositoryImpl implements TopicRepository {

    private final TopicLocalDataSource topicLocalDataSource;
    private final TopicRemoteDataSource topicRemoteDataSource;

    /** Constructs a new instance. */
    public TopicRepositoryImpl(TopicLocalDataSource topicLocalDataSource,
                               TopicRemoteDataSource topicRemoteDataSource) {
        this.topicLocalDataSource = topicLocalDataSource;
        this.topicRemoteDataSource = topicRemoteDataSource;
    }

    @Override
    public List<Topic> getTopics(List<Integer> topicIDs) {
        if (topicLocalDataSource.isOutdated()){
            refreshTopics();
        }
        return topicLocalDataSource.getTopics(topicIDs);
    }

    private void refreshTopics(){
        Result<List<TopicResponse>> result = topicRemoteDataSource.getAllTopics();
        if (result instanceof Result.Success){
            List<TopicResponse> topicResponses = ((Result.Success<List<TopicResponse>>) result).data;
            updateTopicLocalDataSource(topicResponses);
        }
    }

    private void updateTopicLocalDataSource(List<TopicResponse> topicResponses){
        topicLocalDataSource.deleteAllTopics();
        List<Topic> topics = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (TopicResponse topicResponse : topicResponses){
            topics.add(new Topic(topicResponse.getTopicID(), topicResponse.getNumber(),
                    topicResponse.getName(), dateSavedToLocalDatabase));
        }
        topicLocalDataSource.saveTopics(topics);
    }
}
