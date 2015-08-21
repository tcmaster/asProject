package com.android.tonight8.dao.entity;

import com.android.tonight8.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.android.tonight8.dao.GoodsCategoryDao;
import com.android.tonight8.dao.GoodsSpecificationDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table GOODS_SPECIFICATION.
 */
public class GoodsSpecification {

    private long id;
    private Long goodsCategoryId;
    private String name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GoodsSpecificationDao myDao;

    private GoodsCategory goodsCategory;
    private Long goodsCategory__resolvedKey;


    public GoodsSpecification() {
    }

    public GoodsSpecification(long id) {
        this.id = id;
    }

    public GoodsSpecification(long id, Long goodsCategoryId, String name) {
        this.id = id;
        this.goodsCategoryId = goodsCategoryId;
        this.name = name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGoodsSpecificationDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** To-one relationship, resolved on first access. */
    public GoodsCategory getGoodsCategory() {
        Long __key = this.goodsCategoryId;
        if (goodsCategory__resolvedKey == null || !goodsCategory__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GoodsCategoryDao targetDao = daoSession.getGoodsCategoryDao();
            GoodsCategory goodsCategoryNew = targetDao.load(__key);
            synchronized (this) {
                goodsCategory = goodsCategoryNew;
            	goodsCategory__resolvedKey = __key;
            }
        }
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory) {
        synchronized (this) {
            this.goodsCategory = goodsCategory;
            goodsCategoryId = goodsCategory == null ? null : goodsCategory.getId();
            goodsCategory__resolvedKey = goodsCategoryId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
