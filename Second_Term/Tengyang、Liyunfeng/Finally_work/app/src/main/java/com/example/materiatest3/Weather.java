package com.example.materiatest3;

import java.util.List;

public class Weather {

    public String msg;
    public data123 data;

    public static class data123 {

       public yesterday123 yesterday;
        public static class yesterday123 {
            public String date;
            public String high;
            public String fx;
            public String low;
            public String type;
        }

        public String city;

        public List<Forecast> forecast;

        public static class Forecast {
            public String date;
            public String high;
            public String low;
            public String fengxiang;
            public String type;
        }
        public String ganmao;
        public String wendu;
    }

}

