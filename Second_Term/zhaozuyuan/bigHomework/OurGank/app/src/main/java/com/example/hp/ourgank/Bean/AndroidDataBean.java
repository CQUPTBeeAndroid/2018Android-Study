package com.example.hp.ourgank.Bean;

import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/8 2:03
 * @简述: Android的json数据种子
 */
/*
{
  "error": false,
  "results": [
    {
      "_id": "5b17f772421aa910a82cf51a",
      "createdAt": "2018-06-07T11:41:31.949Z",
      "desc": "\u8584\u8377\u5065\u5eb7\u4f53\u91cd\u9009\u62e9\u63a7\u4ef6\u3002",
      "images": [
        "http://img.gank.io/731d1a9b-04ea-4d2f-b4c7-7418d87aa8fe"
      ],
      "publishedAt": "2018-06-07T00:00:00.0Z",
      "source": "chrome",
      "type": "Android",
      "url": "https://github.com/totond/BooheeRuler",
      "used": true,
      "who": "\u827e\u7c73"
    },

 */
public class AndroidDataBean {
    private boolean error;
    private List<Results> results;

    public static class Results{
        private String desc;
        private List<String>images;

        private String publishedAt;
        private String url;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
