package com.android.tonight8.dao.entity;

import com.android.tonight8.dao.DaoSession;

import de.greenrobot.dao.DaoException;

import com.android.tonight8.dao.EventDao;
import com.android.tonight8.dao.FlyScreenDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table FLY_SCREEN.
 */
public class FlyScreen {

    private long id;
    private Long eventId;
    private Integer type;
    private String content;
    private Long timeStamp;

    /**
     * Used to resolve relations
     */
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient FlyScreenDao myDao;

    private Event event;
    private Long event__resolvedKey;


    public FlyScreen() {
    }

    public FlyScreen(long id) {
        this.id = id;
    }

    public FlyScreen(long id, Long eventId, Integer type, String content, Long timeStamp) {
        this.id = id;
        this.eventId = eventId;
        this.type = type;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFlyScreenDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    public Event getEvent() {
        Long __key = this.eventId;
        if (event__resolvedKey == null || !event__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EventDao targetDao = daoSession.getEventDao();
            Event eventNew = targetDao.load(__key);
            synchronized (this) {
                event = eventNew;
                event__resolvedKey = __key;
            }
        }
        return event;
    }

    public void setEvent(Event event) {
        synchronized (this) {
            this.event = event;
            eventId = event == null ? null : event.getId();
            event__resolvedKey = eventId;
        }
    }

    /**
     * Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context.
     */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context.
     */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context.
     */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

}
