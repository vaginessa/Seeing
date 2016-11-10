package com.sye.seeing.data;

import android.support.annotation.NonNull;

import com.sye.seeing.dao.Markdown;

import java.util.List;

/**
 * @author Secray
 * @date 2016.11.10
 */

public interface MarkdownDataSource {
    interface LoadMarkdownCallback {
        void onMarkdownLoaded(Markdown note);

        void onLoadError();
    }

    interface ObtainMarkdownCallback {
        void onMarkdownObtained(List<Markdown> notes);

        void onObtainError();
    }

    /***
     * load one markdown by id(Long)
     *
     * @param key
     * @param callback
     */
    void loadOne(@NonNull Long key, LoadMarkdownCallback callback);

    /***
     * get all markdowns
     *
     * @param callback
     */
    void getMarkdowns(ObtainMarkdownCallback callback);

    /****
     * Save markdown
     *
     * @param markdown
     * @return
     */
    Markdown save(@NonNull Markdown markdown);

    /***
     * Remove markdown by id
     *
     * @param key
     */
    void remove(@NonNull Long key);

    /***
     * Remove markdown by itself
     *
     * @param markdown
     */
    void remove(@NonNull Markdown markdown);

    /***
     * Remove markdown which in List
     *
     * @param markdowns
     */
    void remove(@NonNull List<Markdown> markdowns);

    /***
     * Update markdown
     *
     * @param markdown
     * @return
     */
    Markdown update(@NonNull Markdown markdown);

    /***
     * Delete all markdown
     */
    void deleteAll();
}
