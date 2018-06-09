package com.example.hp.ourgank.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/8 23:31
 * @简述:  可序列化的数据在AndroidFragment和AndroidDetail之间传递
 */
public class AndroidIntentData implements Serializable {
    private List<String>images;
    private String url;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
