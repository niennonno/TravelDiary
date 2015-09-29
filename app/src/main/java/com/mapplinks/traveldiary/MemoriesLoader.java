package com.mapplinks.traveldiary;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Aditya Vikram on 9/29/2015.
 */
public class MemoriesLoader extends DbCursorLoader{

    private MemoriesDataSource mDataSource;

    public MemoriesLoader(Context context, MemoriesDataSource memoriesDataSource){
        super(context);
        mDataSource=memoriesDataSource;
    }

    @Override
    protected Cursor loadCursor() {
        return mDataSource.allMemoriesCursor();
    }
}
