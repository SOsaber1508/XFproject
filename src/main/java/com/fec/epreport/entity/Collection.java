package com.fec.epreport.entity;

import java.io.Serializable;

//收藏
public class Collection implements Serializable {
    //序列化实例化
    private static final long serialVersionUID = 1L;
    private Integer collection_id;
    private String collection_user_id;
    private String collection_user_ids;

    public Collection() {
    }

    public Collection(Integer collection_id, String collection_user_id, String collection_user_ids) {
        this.collection_id = collection_id;
        this.collection_user_id = collection_user_id;
        this.collection_user_ids = collection_user_ids;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Integer collection_id) {
        this.collection_id = collection_id;
    }

    public String getCollection_user_id() {
        return collection_user_id;
    }

    public void setCollection_user_id(String collection_user_id) {
        this.collection_user_id = collection_user_id;
    }

    public String getCollection_user_ids() {
        return collection_user_ids;
    }

    public void setCollection_user_ids(String collection_user_ids) {
        this.collection_user_ids = collection_user_ids;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collection_id=" + collection_id +
                ", collection_user_id='" + collection_user_id + '\'' +
                ", collection_user_ids='" + collection_user_ids + '\'' +
                '}';
    }
}
