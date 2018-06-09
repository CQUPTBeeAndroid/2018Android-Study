package com.example.hp.ourgank.Bean;

import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/8 0:10
 * @简述: 推荐的json种子
 */
/*
{
  "error": false,
  "results": [
    {
      "_id": "5b18a3f8421aa9109f56a6bd",
      "createdAt": "2018-06-07T11:18:16.255Z",
      "desc": "\u60f3\u9a97\u5403\u7684 \u88ab\u8bc6\u7834\u540e\u2026\u2026",
      "publishedAt": "2018-06-07T00:00:00.0Z",
      "source": "web",
      "type": "\u4f11\u606f\u89c6\u9891",
      "url": "https://www.iesdouyin.com/share/video/6563115752382008590/?region=CN&mid=6525072666016254727&titleType
      =title&utm_source=copy_link&utm_campaign=client_share&utm_medium=android&app=aweme&iid=33383525082&timestamp=1528341373",
      "used": true,
      "who": "lijinshanmx"
    },
 */
public class RecommendDataBean {
    private boolean error;
    private List<Results>results;

    public static class Results{
        private String desc;
        private String publishedAt;
        private String url;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
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
