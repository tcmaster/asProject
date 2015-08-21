package com.android.tonight8.dao;

import java.util.List;
import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.android.tonight8.dao.entity.Event;

import com.android.tonight8.dao.entity.FlyScreen;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table FLY_SCREEN.
 */
public class FlyScreenDao extends AbstractDao<FlyScreen, Long> {

    public static final String TABLENAME = "FLY_SCREEN";
    private DaoSession daoSession;
    private String selectDeep;


    public FlyScreenDao(DaoConfig config) {
        super(config);
    }

    public FlyScreenDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'FLY_SCREEN' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'EVENT_ID' INTEGER," + // 1: eventId
                "'TYPE' INTEGER," + // 2: type
                "'CONTENT' TEXT," + // 3: content
                "'TIME_STAMP' INTEGER);"); // 4: timeStamp
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'FLY_SCREEN'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, FlyScreen entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());

        Long eventId = entity.getEventId();
        if (eventId != null) {
            stmt.bindLong(2, eventId);
        }

        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(3, type);
        }

        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }

        Long timeStamp = entity.getTimeStamp();
        if (timeStamp != null) {
            stmt.bindLong(5, timeStamp);
        }
    }

    @Override
    protected void attachEntity(FlyScreen entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public FlyScreen readEntity(Cursor cursor, int offset) {
        FlyScreen entity = new FlyScreen( //
                cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // eventId
                cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // type
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
                cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // timeStamp
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, FlyScreen entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setEventId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTimeStamp(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(FlyScreen entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(FlyScreen entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getEventDao().getAllColumns());
            builder.append(" FROM FLY_SCREEN T");
            builder.append(" LEFT JOIN EVENT T0 ON T.'EVENT_ID'=T0.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected FlyScreen loadCurrentDeep(Cursor cursor, boolean lock) {
        FlyScreen entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Event event = loadCurrentOther(daoSession.getEventDao(), cursor, offset);
        entity.setEvent(event);

        return entity;
    }

    public FlyScreen loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();

        String[] keyArray = new String[]{key.toString()};
        Cursor cursor = db.rawQuery(sql, keyArray);

        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }

    /**
     * Reads all available rows from the given cursor and returns a list of new ImageTO objects.
     */
    public List<FlyScreen> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<FlyScreen> list = new ArrayList<FlyScreen>(count);

        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }

    protected List<FlyScreen> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /**
     * A raw-style query where you can pass any WHERE clause and arguments.
     */
    public List<FlyScreen> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }

    /**
     * Properties of entity FlyScreen.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property EventId = new Property(1, Long.class, "eventId", false, "EVENT_ID");
        public final static Property Type = new Property(2, Integer.class, "type", false, "TYPE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property TimeStamp = new Property(4, Long.class, "timeStamp", false, "TIME_STAMP");
    }

}
