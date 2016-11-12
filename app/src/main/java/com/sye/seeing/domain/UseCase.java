package com.sye.seeing.domain;

/**
 * Use cases are the entry points to the domain layer.
 * Seeing use cases include markdown
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValues> {

    private Q mRequestValues;
    private UseCaseCallback<P> mUseCaseCallback;

    public UseCaseCallback<P> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<P> mUseCaseCallback) {
        this.mUseCaseCallback = mUseCaseCallback;
    }

    public void setRequestValues(Q requestValues) {
        this.mRequestValues = requestValues;
    }

    void run() {
        execute(mRequestValues);
    }

    protected abstract void execute(Q values);

    public interface RequestValues {

    }

    public interface ResponseValues {

    }

    public interface UseCaseCallback<R> {
        void onSuccess(R responseValues);

        void onError();
    }
}
