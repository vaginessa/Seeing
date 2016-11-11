package com.sye.seeing.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Secray
 * @date 2016.11.11
 */
public class FileUtil {
    public static final String STORAGE_DIRCTIONARY = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String APE_NOTE_DIR = STORAGE_DIRCTIONARY + File.separator + "Seeing";

    @Singleton @Inject
    public FileUtil() {

    }

    private void makeSureAppDirCreated() {
        if (checkSdcardStatus()) {
            mkDir(APE_NOTE_DIR);
        } else {
            WLog.e("sd card not ready");
        }
    }

    public void mkDir(String dir) {
        if (TextUtils.isEmpty(dir))
            return;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            boolean res = dirFile.mkdir();
            if (!res) {
                WLog.e("make dir " + dir + " error!");
            }
        }
    }

    public boolean checkSdcardStatus() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public long getFileSize(String path) {
        if (TextUtils.isEmpty(path)) {
            return -1;
        }
        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }

    public boolean isFileExist(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        File file = new File(filePath);
        return (file.exists() && file.isFile());
    }

    /**
     * @param filePath
     * @return true if delete success
     */
    public boolean deleteFile(String filePath) {
        File deleteFile = new File(filePath);
        if (deleteFile.exists()) {
            deleteFile.delete();
            return true;
        } else {
            return false;
        }
    }

    public void deleteFiles(List<String> filePaths){
        for (String filePath : filePaths){
            deleteFile(filePath);
        }
    }
    /**
     * @param filename
     * @return true if create success
     */
    public boolean createFile(String filename) {
        makeSureAppDirCreated();
        return createFile(APE_NOTE_DIR, filename);
    }

    public boolean createFile(String dir, String filename) {
        File dirFile = new File(dir);
        if (!dirFile.isDirectory())
            return false;
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File newFile = new File(dir + File.separator + filename);
        try {
            if (!newFile.exists())
                newFile.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeFile(String fileName, String content, boolean append) {
        makeSureAppDirCreated();
        return writeFile(APE_NOTE_DIR, fileName, content, append);
    }

    public boolean writeFile(String dir, String fileName, String content, boolean append) {
        if (TextUtils.isEmpty(content)) {
            return false;
        }
        FileWriter fileWriter = null;
        try {
            String filePath = dir + File.separator + fileName;
            fileWriter = new FileWriter(filePath, append);
            fileWriter.write(content + "\n");
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public String getFilePath(String fileName) {
        return APE_NOTE_DIR + File.separator + fileName;
    }
}
