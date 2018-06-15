package com.example.zhangfan.work6.Gson;

import java.util.List;

/**
 * Created by Super_chao on 2018/6/9.
 */

public class NewsJsonBean {
    public Results results;
    public static class Results {
        public List<iOS> iOS;
        public static class iOS{
            private String desc;
            private String publishedAt;
            private String type;
            private String url;
            private String who;







            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDesc() {
                return desc;
            }


            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }




            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public List<android> Android;
        public static class android{
            private String desc;
            private String publishedAt;
            private String type;
            private String url;
            private String who;












            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDesc() {
                return desc;
            }





            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }



            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public List<reconmend> 瞎推荐;
        public static class reconmend{  private String desc;
            private String publishedAt;
            private String type;
            private String url;
            private String who;












            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDesc() {
                return desc;
            }





            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }



            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public List<source> 拓展资源;
        public static  class source{private String desc;
            private String publishedAt;
            private String type;
            private String url;
            private String who;












            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDesc() {
                return desc;
            }





            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }



            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public List<weifare> 福利;
        public static class weifare{
            private String desc;
            private String publishedAt;
            private String type;
            private String url;
            private String who;












            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDesc() {
                return desc;
            }





            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }



            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public List<video> 休息视频;
        public static class video{
            private String desc;
            private String publishedAt;
            private String type;
            private String url;
            private String who;












            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDesc() {
                return desc;
            }





            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }



            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public List<source> get拓展资源() {
            return 拓展资源;
        }

        public List<video> get休息视频() {
            return 休息视频;
        }

        public List<weifare> get福利() {
            return 福利;
        }

        public void set休息视频(List<video> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public void set拓展资源(List<source> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public void set福利(List<weifare> 福利) {
            this.福利 = 福利;
        }

        public List<reconmend> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<reconmend> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<android> getAndroid() {
            return Android;
        }

        public void setiOS(List<Results.iOS> iOS) {
            this.iOS = iOS;
        }

        public List<Results.iOS> getiOS() {
            return iOS;
        }

        public void setAndroid(List<android> android) {
            Android = android;
        }
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}

