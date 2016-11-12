package com.sye.seeing.domain.usecase;

import com.sye.seeing.dao.Markdown;
import com.sye.seeing.data.MarkdownRepository;
import com.sye.seeing.domain.UseCase;

import javax.inject.Inject;

/**
 * @author Secray
 * @date 2016.11.12
 */
public class SaveMarkdownUseCase extends UseCase<SaveMarkdownUseCase.RequestValues, SaveMarkdownUseCase.ResponseValues> {

    MarkdownRepository mMarkdownRepository;

    @Inject
    public SaveMarkdownUseCase(MarkdownRepository MarkdownRepository) {
        this.mMarkdownRepository = MarkdownRepository;
    }

    @Override
    protected void execute(RequestValues values) {
        Markdown markdown = values.getMarkdown();
        Markdown oldMarkdown;
        boolean isNew;
        if (markdown.getId() != null) {
            isNew = false;
            oldMarkdown = mMarkdownRepository.update(markdown);
        } else {
            isNew = true;
            oldMarkdown = mMarkdownRepository.save(markdown);
        }
        markdown.setSize(oldMarkdown.getSize());

        getUseCaseCallback().onSuccess(new ResponseValues(markdown, oldMarkdown, isNew));
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private Markdown mMarkdown;

        public RequestValues(Markdown markdown) {
            this.mMarkdown = markdown;
        }

        public Markdown getMarkdown() {
            return mMarkdown;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private Markdown mOldMarkdown;
        private Markdown mMarkdown;
        private boolean mIsNew;

        public ResponseValues(Markdown markdown, Markdown oldMarkdown, boolean isNew) {
            this.mMarkdown = markdown;
            this.mIsNew = isNew;
            this.mOldMarkdown = oldMarkdown;
        }

        public Markdown getMarkdown() {
            return mMarkdown;
        }

        public boolean getIsNew() {
            return mIsNew;
        }

        public Markdown getOldMarkdown() {
            return mOldMarkdown;
        }
    }
}
