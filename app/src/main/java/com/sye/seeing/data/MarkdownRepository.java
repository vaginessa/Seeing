package com.sye.seeing.data;

import android.support.annotation.NonNull;

import com.sye.seeing.dao.Markdown;
import com.sye.seeing.utils.DatabaseUtil;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Secray
 * @date 2016.11.10
 */

public class MarkdownRepository implements MarkdownDataSource {

    private DatabaseUtil mDatabaseUtil;

    @Singleton
    @Inject
    public MarkdownRepository(DatabaseUtil databaseUtil) {
        this.mDatabaseUtil = databaseUtil;
    }

    @Override
    public void loadOne(@NonNull Long key, LoadMarkdownCallback callback) {

    }

    @Override
    public void getMarkdowns(ObtainMarkdownCallback callback) {

    }

    @Override
    public Markdown save(@NonNull Markdown markdown) {
        return null;
    }

    @Override
    public void remove(@NonNull Long key) {

    }

    @Override
    public void remove(@NonNull Markdown markdown) {

    }

    @Override
    public void remove(@NonNull List<Markdown> markdowns) {

    }

    @Override
    public Markdown update(@NonNull Markdown markdown) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
