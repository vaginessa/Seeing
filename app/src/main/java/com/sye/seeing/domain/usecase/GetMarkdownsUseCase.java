package com.sye.seeing.domain.usecase;

import com.sye.seeing.dao.Markdown;
import com.sye.seeing.data.MarkdownDataSource;
import com.sye.seeing.data.MarkdownRepository;
import com.sye.seeing.domain.UseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Secray
 * @date 2016.11.12
 */
public class GetMarkdownsUseCase extends UseCase<GetMarkdownsUseCase.RequestValues, GetMarkdownsUseCase.ResponseValues> {
    MarkdownRepository mMarkdownRepository;

    @Inject
    public GetMarkdownsUseCase(MarkdownRepository MarkdownRepository) {
        this.mMarkdownRepository = MarkdownRepository;
    }

    @Override
    protected void execute(RequestValues values) {
        mMarkdownRepository.getMarkdowns(new MarkdownDataSource.ObtainMarkdownCallback() {
            @Override
            public void onMarkdownObtained(List<Markdown> notes) {
                ResponseValues responseValues = new ResponseValues(notes);
                getUseCaseCallback().onSuccess(responseValues);
            }

            @Override
            public void onObtainError() {
                getUseCaseCallback().onError();
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private List<Markdown> mMarkdowns;

        public ResponseValues(List<Markdown> markdownNotes) {
            this.mMarkdowns = markdownNotes;
        }

        public List<Markdown> getMarkdownNotes() {
            return mMarkdowns;
        }
    }
}
