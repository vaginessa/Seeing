package com.sye.seeing.domain.usecase;


import com.sye.seeing.dao.Markdown;
import com.sye.seeing.data.MarkdownDataSource;
import com.sye.seeing.data.MarkdownRepository;
import com.sye.seeing.domain.UseCase;

import javax.inject.Inject;

/**
 * @author Secray
 * @date 2016.11.12
 */
public class LoadMarkdownUseCase extends UseCase<LoadMarkdownUseCase.RequestValues, LoadMarkdownUseCase.ResponseValues> {
    MarkdownRepository mMarkdownRepository;

    @Inject
    public LoadMarkdownUseCase(MarkdownRepository MarkdownRepository) {
        this.mMarkdownRepository = MarkdownRepository;
    }

    @Override
    protected void execute(RequestValues values) {
        mMarkdownRepository.loadOne(values.getKey(), new MarkdownDataSource.LoadMarkdownCallback() {

            @Override
            public void onMarkdownLoaded(Markdown markdown) {
                ResponseValues responseValues = new ResponseValues(markdown);
                getUseCaseCallback().onSuccess(responseValues);
            }

            @Override
            public void onLoadError() {
                getUseCaseCallback().onError();
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private Long mKey;

        public RequestValues(Long key){
            mKey = key;
        }

        public Long getKey(){
            return mKey;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private Markdown mMarkdown;

        public ResponseValues(Markdown markdown){
            this.mMarkdown = markdown;
        }

        public Markdown getMarkdown() {
            return mMarkdown;
        }
    }
}
