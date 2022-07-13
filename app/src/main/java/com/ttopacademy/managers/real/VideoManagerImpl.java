package com.ttopacademy.managers.real;

import android.os.Handler;
import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.managers.interfaces.VideoManager;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository;
import com.ttopacademy.repositories.interfaces.VideoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/**  VideoManager implementation class. */
public class VideoManagerImpl implements VideoManager {

    private final CategorySubjectRepository categorySubjectRepository;
    private final CategorySubjectTopicRepository categorySubjectTopicRepository;
    private final CategorySubjectTopicVideoRepository categorySubjectTopicVideoRepository;
    private final VideoRepository videoRepository;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public VideoManagerImpl(CategorySubjectRepository categorySubjectRepository,
                            CategorySubjectTopicRepository categorySubjectTopicRepository,
                            CategorySubjectTopicVideoRepository categorySubjectTopicVideoRepository,
                            VideoRepository videoRepository,
                            Executor executor, Handler resultHandler) {
        this.categorySubjectRepository = categorySubjectRepository;
        this.categorySubjectTopicRepository = categorySubjectTopicRepository;
        this.categorySubjectTopicVideoRepository = categorySubjectTopicVideoRepository;
        this.videoRepository = videoRepository;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getVideos(int categoryID, int subjectID, int topicID, ResultCallback<List<Video>> callback) {
        executor.execute(() -> {
            List<Video> result = getVideosSync(categoryID, subjectID, topicID);
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<Video> getVideosSync(int categoryID, int subjectID, int topicID) {
        int categorySubjectID = categorySubjectRepository.getCategorySubjectID(categoryID, subjectID);
        int categorySubjectTopicID
                = categorySubjectTopicRepository.getCategorySubjectTopicID(categorySubjectID, subjectID);
        List<CategorySubjectTopicVideo> categorySubjectTopicVideos
                = categorySubjectTopicVideoRepository.getCategorySubjectTopicVideos(categorySubjectTopicID);
        List<Integer> videoIDs = new ArrayList<>();
        for (CategorySubjectTopicVideo categorySubjectTopicVideo : categorySubjectTopicVideos){
            videoIDs.add(categorySubjectTopicVideo.getVideoID());
        }
        return videoRepository.getVideos(categorySubjectTopicID, videoIDs);
    }

    private void postResultToMainThread(final List<Video> result,
                                        final ResultCallback<List<Video>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
