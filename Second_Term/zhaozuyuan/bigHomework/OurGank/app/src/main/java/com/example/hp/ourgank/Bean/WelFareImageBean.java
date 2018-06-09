package com.example.hp.ourgank.Bean;

import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/7 2:02
 * @简述: 福利获取图片json种子
 */
/*
{
  "error": false,
  "results": [
    {
      "_id": "5b1026a0421aa9029661ae00",
      "createdAt": "2018-06-01T00:45:20.83Z",
      "desc": "2018-06-01",
      "publishedAt": "2018-06-06T00:00:00.0Z",
      "source": "web",
      "type": "\u798f\u5229",
      "url": "http://ww1.sinaimg.cn/large/0065oQSqly1frv032vod8j30k80q6gsz.jpg",
      "used": true,
      "who": "lijinshanmx"
    },
 */
public class WelFareImageBean {
    private boolean error;
    private List<Results> results;

    public static class Results{
        private String createdAt;
        private String desc;
        private String url;
        private String who;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
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
