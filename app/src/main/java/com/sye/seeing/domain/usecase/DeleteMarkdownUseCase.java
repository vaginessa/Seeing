package com.sye.seeing.domain.usecase;


import com.sye.seeing.dao.Markdown;
import com.sye.seeing.data.MarkdownRepository;
import com.sye.seeing.domain.UseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Secray
 * @date 2016.11.12
 */
public class DeleteMarkdownUseCase extends UseCase<DeleteMarkdownUseCase.RequestValues, DeleteMarkdownUseCase.ResponseValues> {
    MarkdownRepository mMarkdownRepository;

    @Inject
    public DeleteMarkdownUseCase(MarkdownRepository markdownNoteRepository) {
        this.mMarkdownRepository = markdownNoteRepository;
    }

    @Override
    protected void execute(RequestValues values) {
        mMarkdownRepository.remove(values.getMarkdowns());
        getUseCaseCallback().onSuccess(new ResponseValues());
    }

    public static final class RequestValues implements UseCase.RequestValues {
        //private Long mKey;
        private List<Markdown> mMarkdowns = new ArrayList<>();

//        public RequestValues(Long key) {
//            mKey = key;
//        }

        public RequestValues(List<Markdown> markdowns) {
            mMarkdowns.clear();
            mMarkdowns.addAll(markdowns);
        }

//        public Long getKey() {
//            return mKey;
//        }

        public List<Markdown> getMarkdowns() {
            return mMarkdowns;
        }

        public int getSize(List<Markdown> markdowns) {
            return markdowns.size();
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}
