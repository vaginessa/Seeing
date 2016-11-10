package com.sye.seeing.utils;

import com.sye.seeing.dao.DaoSession;
import com.sye.seeing.dao.Markdown;
import com.sye.seeing.dao.MarkdownDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.greenrobot.dao.query.Query;

/**
 * @author Secray
 * @date 2016.11.10
 */

public class DatabaseUtil {
    private MarkdownDao mMarkdownDao;
    private DaoSession mDaoSession;

    @Inject
    @Singleton
    public DatabaseUtil(DaoSession daoSession) {
        this.mDaoSession = daoSession;
        mMarkdownDao = this.mDaoSession.getMarkdownDao();
    }

    public List<Markdown> getAllMarkdown() {
        Query query = mMarkdownDao.queryBuilder().orderDesc(MarkdownDao.Properties.LastTime).build();
        return query.list();
    }

    public Markdown getMarkdown(Long key) {
        return mMarkdownDao.load(key);
    }

    public void removeMarkdown(Markdown note) {
        mMarkdownDao.delete(note);
    }

    public void removeMarkdownById(Long id) {
        mMarkdownDao.deleteByKey(id);
    }

    public void updateMarkdown(Markdown note) {
        mMarkdownDao.update(note);
    }

    public void addMarkdown(Markdown note) {
        mMarkdownDao.insert(note);
    }

    public void deleteAllMarkdown() {
        mMarkdownDao.deleteAll();
    }
}
