package com.sye.seeing.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.sye.seeing.dagger2.ContextType;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;

/**
 * @author kui.xie
 * @date 2016-06-14
 */
public final class FileCopyManager {
    private static final String TAG = FileCopyManager.class.getSimpleName();
    private Context mContext;
    @Inject
    public FileCopyManager(@ContextType Context c){
        this.mContext = c;
        copyAsset2AppDir();
    }

    public String getSyntaxFilePath(){
        return mContext.getFilesDir() + "/syntax.md";
    }

    private void copyAsset2AppDir(){
        String[] asFiles = new String[]{};
        AssetManager am = mContext.getResources().getAssets();

        try{
            asFiles = am.list("data");
        }catch(IOException e){
            Log.e(TAG, "get file from assets error.\n" + e);
        }

        for(String file : asFiles){

            BufferedInputStream inputStream = null;
            BufferedOutputStream outStream = null;

            try{
                inputStream = new BufferedInputStream(am.open("data/" + file));
                FileOutputStream saveFile = mContext.openFileOutput(file, Context.MODE_PRIVATE);
                outStream = new BufferedOutputStream(saveFile);

                copyFile(inputStream, outStream);

            } catch (FileNotFoundException e) {
                Log.e(TAG, "FileNotFoundException:" + e);
            } catch (IOException e) {
                Log.e(TAG, "IOException:" + e);
            } finally {
                streamClose(inputStream, outStream);
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024 * 1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private void streamClose(InputStream in, OutputStream out){
        try {
            if(in != null) in.close();
            if(out != null) out.close();
        } catch (IOException e) {
            Log.e(TAG, "IOException:" + e);
        }
    }

}
