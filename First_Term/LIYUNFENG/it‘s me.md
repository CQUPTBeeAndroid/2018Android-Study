<html lang="en"><head>
    <meta charset="UTF-8">
    <title></title>
<style id="system" type="text/css">h1,h2,h3,h4,h5,h6,p,blockquote {    margin: 0;    padding: 0;}body {    font-family: "Helvetica Neue", Helvetica, "Hiragino Sans GB", Arial, sans-serif;    font-size: 13px;    line-height: 18px;    color: #737373;    margin: 10px 13px 10px 13px;}a {    color: #0069d6;}a:hover {    color: #0050a3;    text-decoration: none;}a img {    border: none;}p {    margin-bottom: 9px;}h1,h2,h3,h4,h5,h6 {    color: #404040;    line-height: 36px;}h1 {    margin-bottom: 18px;    font-size: 30px;}h2 {    font-size: 24px;}h3 {    font-size: 18px;}h4 {    font-size: 16px;}h5 {    font-size: 14px;}h6 {    font-size: 13px;}hr {    margin: 0 0 19px;    border: 0;    border-bottom: 1px solid #ccc;}blockquote {    padding: 13px 13px 21px 15px;    margin-bottom: 18px;    font-family:georgia,serif;    font-style: italic;}blockquote:before {    content:"C";    font-size:40px;    margin-left:-10px;    font-family:georgia,serif;    color:#eee;}blockquote p {    font-size: 14px;    font-weight: 300;    line-height: 18px;    margin-bottom: 0;    font-style: italic;}code, pre {    font-family: Monaco, Andale Mono, Courier New, monospace;}code {    background-color: #fee9cc;    color: rgba(0, 0, 0, 0.75);    padding: 1px 3px;    font-size: 12px;    -webkit-border-radius: 3px;    -moz-border-radius: 3px;    border-radius: 3px;}pre {    display: block;    padding: 14px;    margin: 0 0 18px;    line-height: 16px;    font-size: 11px;    border: 1px solid #d9d9d9;    white-space: pre-wrap;    word-wrap: break-word;}pre code {    background-color: #fff;    color:#737373;    font-size: 11px;    padding: 0;}@media screen and (min-width: 768px) {    body {        width: 748px;        margin:10px auto;    }}</style><style id="custom" type="text/css"></style><style type="text/css" adt="123"></style><script>!
    function e(t, n, i) {
        function o(a, s) {
            if (!n[a]) {
                if (!t[a]) {
                    var l = "function" == typeof require && require;
                    if (!s && l) return l(a, !0);
                    if (r) return r(a, !0);
                    var c = new Error("Cannot find module '" + a + "'");
                    throw c.code = "MODULE_NOT_FOUND",
                        c
                }
                var d = n[a] = {
                    exports: {}
                };
                t[a][0].call(d.exports, function (e) {
                    var n = t[a][1][e];
                    return o(n ? n : e)
                }, d, d.exports, e, t, n, i)
            }
            return n[a].exports
        }
        for (var r = "function" == typeof require && require, a = 0; a < i.length; a++) o(i[a]);
        return o
    }({
        1: [function (e) {
            var t = window.location.href,
                n = document.createElement("div"),
                i = document.createElement("i");
            if (i.setAttribute("id", "ADT-PlayHTML5-btn"), i.innerText = "HTML5\u89c6\u9891", i.setAttribute("style", "display:inline-block;font-size: 20px;padding:5px 10px;font-weight: 700;line-height:34px;color: #fff;text-align: center;vertical-align: baseline;border-radius:10px;background-color: #428bca;cursor: pointer;font-style: normal;"), n.setAttribute("style", "float:right;margin-top:-50px;width:300px;height:50px;padding-top:8px;"), n.appendChild(i), /v\.youku\.com\/v_show\/.*/.test(t)) document.querySelector(".s_main div.base").appendChild(n);
            else if (/www\.tudou\.com\/(albumplay|programs)\/.*/.test(t)) document.querySelector("#summary").appendChild(n);
            else if (/www\.mgtv\.com\/v\/.*/.test(t)) {
                var i = document.createElement("i"),
                    o = document.createElement("div"),
                    r = document.createElement("em");
                i.setAttribute("style", "display:inline-block;margin:auto 20px;cursor:pointer;"),
                    i.innerText = "HTML5\u89c6\u9891",
                    r.innerText = "|",
                    r.setAttribute("class", "v-panel-dividing"),
                    o.setAttribute("style", "margin-right: 10px;height: 28px;overflow: hidden;position: relative;top: -1px;float: left;"),
                    o.appendChild(r),
                    o.appendChild(i),
                    document.querySelector("div.v-panel-box").appendChild(o)
            }
            i.addEventListener("click", function () {
                function t(e, t) {
                    if (!e) return console.log("\u89e3\u6790\u5185\u5bb9\u5730\u5740\u5931\u8d25"),
                        void delete window[s];
                    console.log("\u89e3\u6790\u5185\u5bb9\u5730\u5740\u5b8c\u6210" + e.map(function (e) {
                            return '<a href="' + e[1] + '" target="_blank">' + e[0] + "</a>"
                        }).join(" "));
                    var n = o("div", {
                        appendTo: document.body,
                        style: {
                            position: "fixed",
                            background: "rgba(0,0,0,0.8)",
                            top: "0",
                            left: "0",
                            width: "100%",
                            height: "100%",
                            zIndex: "999999"
                        }
                    });
                    o("div", {
                        appendTo: n,
                        style: {
                            width: "1120px",
                            height: "630px",
                            position: "absolute",
                            top: "40%",
                            left: "50%",
                            marginTop: "-250px",
                            marginLeft: "-560px",
                            borderRadius: "2px",
                            boxShadow: "0 0 2px #000000, 0 0 200px #000000"
                        }
                    }),
                        o("div", {
                            appendTo: n,
                            style: {
                                position: "absolute",
                                bottom: "10px",
                                left: "0",
                                right: "0",
                                height: "20px",
                                lineHeight: "20px",
                                textAlign: "center",
                                fontSize: "12px",
                                fontFamily: "arial, sans-serif"
                            }
                        });
                    var a = o("div", {
                        appendTo: n,
                        innerHTML: '<div id="html5_Player_placeHolder"></div>',
                        style: {
                            width: "1120px",
                            height: "630px",
                            position: "absolute",
                            backgroundColor: "#000000",
                            top: "40%",
                            left: "50%",
                            marginTop: "-250px",
                            marginLeft: "-560px",
                            borderRadius: "2px",
                            overflow: "hidden"
                        }
                    });
                    o("div", {
                        appendTo: a,
                        innerHTML: "&times;",
                        style: {
                            width: "20px",
                            height: "20px",
                            lineHeight: "20px",
                            textAlign: "center",
                            position: "absolute",
                            color: "#ffffff",
                            fontSize: "20px",
                            top: "5px",
                            right: "5px",
                            textShadow: "0 0 2px #000000",
                            fontWeight: "bold",
                            fontFamily: 'Garamond, "Apple Garamond"',
                            cursor: "pointer"
                        }
                    }).onclick = function () {
                        document.body.removeChild(n),
                            l.video.src = "about:blank",
                            delete window[s]
                    };
                    var l = new r("html5_Player_placeHolder", "1120x630", e, t);
                    l.iframe.contentWindow.focus(),
                        i(),
                        l.iframe.style.display = "block",
                        window[s] = !0
                }
                var n, i = e("./flashBlocker"),
                    o = e("./createElement"),
                    r = e("./player"),
                    a = e("./purl"),
                    s = e("./h5key"),
                    l = e("./seekers");
                if (1 != window[s]) {
                    var c = a(location.href);
                    "zythum.sinaapp.com" === c.attr("host") && "/mama2/ps4/" === c.attr("directory") && c.param("url") && (c = a(c.param("url"))),
                        l.forEach(function (e) {
                            n !== !0 && !! e.match(c) == !0 && (console.log("\u5f00\u59cb\u89e3\u6790\u5185\u5bb9\u5730\u5740"), n = !0, e.getVideos(c, t))
                        }),
                    void 0 === n && console.log("\u627e\u4e0d\u5230\u89e3\u6790")
                }
            })
        },
            {
                "./createElement": 4,
                "./flashBlocker": 5,
                "./h5key": 6,
                "./player": 9,
                "./purl": 10,
                "./seekers": 15
            }],
        2: [function (e, t) {
            function n(e, t) {
                return void 0 === e ? t : e
            }
            function i(e, t) {
                return 0 === t.length ? e : e + (-1 === e.indexOf("?") ? "?" : "&") + t
            }
            function o(e) {
                var t = n(e.url, ""),
                    o = s(n(e.param, {})),
                    l = n(e.method, "GET"),
                    c = n(e.callback, a),
                    d = n(e.contentType, "json"),
                    u = n(e.context, null);
                if (e.jsonp) return r(i(t, o), c.bind(u), "string" == typeof e.jsonp ? e.jsonp : void 0);
                var h = new XMLHttpRequest;
                "get" === l.toLowerCase() && (t = i(t, o), o = ""),
                    h.open(l, t, !0),
                    h.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                    h.send(o),
                    h.onreadystatechange = function () {
                        if (4 === h.readyState) {
                            if (200 === h.status) {
                                var e = h.responseText;
                                if ("json" === d.toLowerCase()) try {
                                    e = JSON.parse(e)
                                } catch (t) {
                                    e = -1
                                }
                                return c.call(u, e)
                            }
                            return c.call(u, -1)
                        }
                    }
            }
            var r = e("./jsonp"),
                a = e("./noop"),
                s = e("./queryString");
            t.exports = o
        },
            {
                "./jsonp": 7,
                "./noop": 8,
                "./queryString": 11
            }],
        3: [function (e, t) {
            t.exports = !! document.createElement("video").canPlayType("application/x-mpegURL")
        },
            {}],
        4: [function (e, t) {
            function n(e, t) {
                var n = document.createElement(e);
                if ("function" == typeof t) t.call(n);
                else for (var i in t) if (t.hasOwnProperty(i)) switch (i) {
                    case "appendTo":
                        t[i].appendChild(n);
                        break;
                    case "innerHTML":
                    case "className":
                    case "id":
                        n[i] = t[i];
                        break;
                    case "style":
                        var o = t[i];
                        for (var r in o) o.hasOwnProperty(r) && (n.style[r] = o[r]);
                        break;
                    default:
                        n.setAttribute(i, t[i] + "")
                }
                return n
            }
            t.exports = n
        },
            {}],
        5: [function (e, t) {
            var n = '<div style="text-shadow:0 0 2px #eee;letter-spacing:-1px;background:#eee;font-weight:bold;padding:0;font-family:arial,sans-serif;font-size:30px;color:#ccc;width:152px;height:52px;border:4px solid #ccc;border-radius:12px;position:absolute;top:50%;left:50%;margin:-30px 0 0 -80px;text-align:center;line-height:52px;">Flash</div>',
                i = 0,
                o = {},
                r = function () {
                    var e = this.getAttribute("data-flash-index"),
                        t = o[e];
                    t.setAttribute("data-flash-show", "isshow"),
                        this.parentNode.insertBefore(t, this),
                        this.parentNode.removeChild(this),
                        this.removeEventListener("click", r, !1)
                },
                a = function (e, t, a) {
                    var s = i++,
                        l = document.defaultView.getComputedStyle(e, null),
                        c = l.position;
                    c = "static" === c ? "relative" : c;
                    var d = l.margin,
                        u = "inline" == l.display ? "inline-block" : l.display,
                        l = ["", "width:" + t + "px", "height:" + a + "px", "position:" + c, "margin:" + d, "display:" + u, "margin:0", "padding:0", "border:0", "border-radius:1px", "cursor:pointer", "background:-webkit-linear-gradient(top, rgba(240,240,240,1)0%,rgba(220,220,220,1)100%)", ""];
                    o[s] = e;
                    var h = document.createElement("div");
                    return h.setAttribute("title", "&#x70B9;&#x6211;&#x8FD8;&#x539F;Flash"),
                        h.setAttribute("data-flash-index", "" + s),
                        e.parentNode.insertBefore(h, e),
                        e.parentNode.removeChild(e),
                        h.addEventListener("click", r, !1),
                        h.style.cssText += l.join(";"),
                        h.innerHTML = n,
                        h
                },
                s = function (e) {
                    if (e instanceof HTMLObjectElement) {
                        if ("" == e.innerHTML.trim()) return;
                        if (e.getAttribute("classid") && !/^java:/.test(e.getAttribute("classid"))) return
                    } else if (!(e instanceof HTMLEmbedElement)) return;
                    var t = e.offsetWidth,
                        n = e.offsetHeight;
                    t > 160 && n > 60 && a(e, t, n)
                };
            t.exports = function () {
                for (var e = document.getElementsByTagName("embed"), t = document.getElementsByTagName("object"), n = 0, i = t.length; i > n; n++) t[n] && s(t[n]);
                for (var n = 0, i = e.length; i > n; n++) e[n] && s(e[n])
            }
        },
            {}],
        6: [function (e, t) {
            t.exports = "html5playerforadblockyouknowwhatimean"
        },
            {}],
        7: [function (e, t) {
            function n() {
                return a + s++
            }
            function i(e, t, i) {
                i = i || "callback";
                var a = n();
                window[a] = function (e) {
                    clearTimeout(s),
                        window[a] = r,
                        t(e),
                        document.body.removeChild(c)
                };
                var s = setTimeout(function () {
                        window[a](-1)
                    }, l),
                    c = o("script", {
                        appendTo: document.body,
                        src: e + (e.indexOf("?") >= 0 ? "&" : "?") + i + "=" + a
                    })
            }
            var o = e("./createElement"),
                r = e("./noop"),
                a = "MAMA2_HTTP_JSONP_CALLBACK",
                s = 0,
                l = 1e4;
            t.exports = i
        },
            {
                "./createElement": 4,
                "./noop": 8
            }],
        8: [function (e, t) {
            t.exports = function () {}
        },
            {}],
        9: [function (e, t) {
            var n;
            !
                function i(t, n, o) {
                    function r(s, l) {
                        if (!n[s]) {
                            if (!t[s]) {
                                var c = "function" == typeof e && e;
                                if (!l && c) return c(s, !0);
                                if (a) return a(s, !0);
                                throw new Error("Cannot find module '" + s + "'")
                            }
                            var d = n[s] = {
                                exports: {}
                            };
                            t[s][0].call(d.exports, function (e) {
                                var n = t[s][1][e];
                                return r(n ? n : e)
                            }, d, d.exports, i, t, n, o)
                        }
                        return n[s].exports
                    }
                    for (var a = "function" == typeof e && e, s = 0; s < o.length; s++) r(o[s]);
                    return r
                }({
                    1: [function (e, t) {
                        function n(e) {
                            for (var t = [], n = 1; n < arguments.length; n++) {
                                var o = arguments[n],
                                    r = o.init;
                                t.push(r),
                                    delete o.init,
                                    i(e.prototype, o)
                            }
                            e.prototype.init = function () {
                                t.forEach(function (e) {
                                    e.call(this)
                                }.bind(this))
                            }
                        }
                        var i = e("./extend");
                        t.exports = n
                    },
                        {
                            "./extend": 9
                        }],
                    2: [function (e, t) {
                        var n = e("./player.css"),
                            i = e("./player.html"),
                            o = (e("./extend"), e("./createElement")),
                            r = e("./parseDOMByClassNames");
                        t.exports = {
                            init: function () {
                                var e = function () {
                                        var e = this.iframe.contentDocument.getElementsByTagName("head")[0],
                                            t = this.iframe.contentDocument.body;
                                        o("style", function () {
                                            e.appendChild(this);
                                            try {
                                                this.styleSheet.cssText = n
                                            } catch (t) {
                                                this.appendChild(document.createTextNode(n))
                                            }
                                        }),
                                            o("link", {
                                                appendTo: e,
                                                href: "http://libs.cncdn.cn/font-awesome/4.3.0/css/font-awesome.min.css",
                                                rel: "stylesheet",
                                                type: "text/css"
                                            }),
                                            t.innerHTML = i,
                                            this.DOMs = r(t, ["player", "video", "video-frame", "comments", "comments-btn", "play", "progress_anchor", "buffered_anchor", "fullscreen", "allscreen", "hd", "volume_anchor", "current", "duration"]),
                                            this.video = this.DOMs.video
                                    }.bind(this),
                                    t = document.getElementById(this.id),
                                    a = this.iframe = o("iframe", {
                                        allowTransparency: !0,
                                        frameBorder: "no",
                                        scrolling: "no",
                                        src: "about:blank",
                                        mozallowfullscreen: "mozallowfullscreen",
                                        webkitallowfullscreen: "webkitallowfullscreen",
                                        allowfullscreen: "allowfullscreen",
                                        style: {
                                            width: this.size[0] + "px",
                                            height: this.size[1] + "px",
                                            overflow: "hidden"
                                        }
                                    });
                                t && t.parentNode ? (t.parentNode.replaceChild(a, t), e()) : (document.body.appendChild(a), e(), document.body.removeChild(a))
                            }
                        }
                    },
                        {
                            "./createElement": 7,
                            "./extend": 9,
                            "./parseDOMByClassNames": 11,
                            "./player.css": 12,
                            "./player.html": 13
                        }],
                    3: [function (e, t) {
                        function n(e) {
                            e.strokeStyle = "black",
                                e.lineWidth = 3,
                                e.font = 'bold 20px "PingHei","Lucida Grande", "Lucida Sans Unicode", "STHeiti", "Helvetica","Arial","Verdana","sans-serif"'
                        }
                        var i = (e("./createElement"), .1),
                            o = 25,
                            r = 4e3,
                            a = document.createElement("canvas").getContext("2d");
                        n(a);
                        var s = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame || window.oRequestAnimationFrame ||
                            function (e) {
                                setTimeout(e, 1e3 / 60)
                            };
                        t.exports = {
                            init: function () {
                                this.video.addEventListener("play", this.reStartComment.bind(this)),
                                    this.video.addEventListener("pause", this.pauseComment.bind(this)),
                                    this.lastCommnetUpdateTime = 0,
                                    this.lastCommnetIndex = 0,
                                    this.commentLoopPreQueue = [],
                                    this.commentLoopQueue = [],
                                    this.commentButtonPreQueue = [],
                                    this.commentButtonQueue = [],
                                    this.commentTopPreQueue = [],
                                    this.commentTopQueue = [],
                                    this.drawQueue = [],
                                    this.preRenders = [],
                                    this.preRenderMap = {},
                                    this.enableComment = void 0 === this.comments ? !1 : !0,
                                    this.prevDrawCanvas = document.createElement("canvas"),
                                    this.canvas = this.DOMs.comments.getContext("2d"),
                                this.comments && this.DOMs.player.classList.add("has-comments"),
                                    this.DOMs["comments-btn"].classList.add("enable"),
                                    this.DOMs.comments.display = this.enableComment ? "block" : "none";
                                var e = 0,
                                    t = function () {
                                        (e = ~e) && this.onCommentTimeUpdate(),
                                            s(t)
                                    }.bind(this);
                                t()
                            },
                            needDrawText: function (e, t, n) {
                                this.drawQueue.push([e, t, n])
                            },
                            drawText: function () {
                                var e = this.prevDrawCanvas,
                                    t = this.prevDrawCanvas.getContext("2d");
                                e.width = this.canvasWidth,
                                    e.height = this.canvasHeight,
                                    t.clearRect(0, 0, this.canvasWidth, this.canvasHeight);
                                var i = [];
                                this.preRenders.forEach(function (e, t) {
                                    e.used = !1,
                                    void 0 === e.cid && i.push(t)
                                });
                                for (var r; r = this.drawQueue.shift();)!
                                    function (e, r) {
                                        var a, s = e[0].text + e[0].color,
                                            l = r.preRenderMap[s];
                                        if (void 0 === l) {
                                            var l = i.shift();
                                            void 0 === l ? (a = document.createElement("canvas"), l = r.preRenders.push(a) - 1) : a = r.preRenders[l];
                                            var c = a.width = e[0].width,
                                                d = a.height = o + 10,
                                                u = a.getContext("2d");
                                            u.clearRect(0, 0, c, d),
                                                n(u),
                                                u.fillStyle = e[0].color,
                                                u.strokeText(e[0].text, 0, o),
                                                u.fillText(e[0].text, 0, o),
                                                a.cid = s,
                                                r.preRenderMap[s] = l
                                        } else a = r.preRenders[l];
                                        a.used = !0,
                                            t.drawImage(a, e[1], e[2])
                                    }(r, this);
                                this.preRenders.forEach(function (e) {
                                    e.used === !1 && (delete this.preRenderMap[e.cid], e.cid = void 0)
                                }.bind(this)),
                                    this.canvas.clearRect(0, 0, this.canvasWidth, this.canvasHeight),
                                    this.canvas.drawImage(e, 0, 0)
                            },
                            createComment: function (e, t) {
                                if (void 0 === e) return !1;
                                var n = a.measureText(e.text);
                                return {
                                    startTime: t,
                                    text: e.text,
                                    color: e.color,
                                    width: n.width + 20
                                }
                            },
                            commentTop: function (e, t, n) {
                                this.commentTopQueue.forEach(function (t, i) {
                                    void 0 != t && (n > t.startTime + r ? this.commentTopQueue[i] = void 0 : this.needDrawText(t, (e - t.width) / 2, o * i))
                                }.bind(this));
                                for (var i; i = this.commentTopPreQueue.shift();) i = this.createComment(i, n),
                                    this.commentTopQueue.forEach(function (t, n) {
                                        i && void 0 === t && (t = this.commentTopQueue[n] = i, this.needDrawText(t, (e - i.width) / 2, o * n), i = void 0)
                                    }.bind(this)),
                                i && (this.commentTopQueue.push(i), this.needDrawText(i, (e - i.width) / 2, o * this.commentTopQueue.length - 1))
                            },
                            commentBottom: function (e, t, n) {
                                t -= 10,
                                    this.commentButtonQueue.forEach(function (i, a) {
                                        void 0 != i && (n > i.startTime + r ? this.commentButtonQueue[a] = void 0 : this.needDrawText(i, (e - i.width) / 2, t - o * (a + 1)))
                                    }.bind(this));
                                for (var i; i = this.commentButtonPreQueue.shift();) i = this.createComment(i, n),
                                    this.commentButtonQueue.forEach(function (n, r) {
                                        i && void 0 === n && (n = this.commentButtonQueue[r] = i, this.needDrawText(n, (e - i.width) / 2, t - o * (r + 1)), i = void 0)
                                    }.bind(this)),
                                i && (this.commentButtonQueue.push(i), this.needDrawText(i, (e - i.width) / 2, t - o * this.commentButtonQueue.length))
                            },
                            commentLoop: function (e, t, n) {
                                for (var r = t / o | 0, a = -1; ++a < r;) {
                                    var s = this.commentLoopQueue[a];
                                    if (void 0 === s && (s = this.commentLoopQueue[a] = []), this.commentLoopPreQueue.length > 0) {
                                        var l = 0 === s.length ? void 0 : s[s.length - 1];
                                        if (void 0 === l || (n - l.startTime) * i > l.width) {
                                            var c = this.createComment(this.commentLoopPreQueue.shift(), n);
                                            c && s.push(c)
                                        }
                                    }
                                    this.commentLoopQueue[a] = s.filter(function (t) {
                                        var r = (n - t.startTime) * i;
                                        return 0 > r || r > t.width + e ? !1 : (this.needDrawText(t, e - r, o * a), !0)
                                    }.bind(this))
                                }
                                for (var d = this.commentLoopQueue.length - r; d-- > 0;) this.commentLoopQueue.pop()
                            },
                            pauseComment: function () {
                                this.pauseCommentAt = Date.now()
                            },
                            reStartComment: function () {
                                if (this.pauseCommentAt) {
                                    var e = Date.now() - this.pauseCommentAt;
                                    this.commentLoopQueue.forEach(function (t) {
                                        t.forEach(function (t) {
                                            t && (t.startTime += e)
                                        })
                                    }),
                                        this.commentButtonQueue.forEach(function (t) {
                                            t && (t.startTime += e)
                                        }),
                                        this.commentTopQueue.forEach(function (t) {
                                            t && (t.startTime += e)
                                        })
                                }
                                this.pauseCommentAt = void 0
                            },
                            drawComment: function () {
                                if (!this.pauseCommentAt) {
                                    var e = Date.now(),
                                        t = this.DOMs["video-frame"].offsetWidth,
                                        n = this.DOMs["video-frame"].offsetHeight;
                                    t != this.canvasWidth && (this.DOMs.comments.width = t, this.canvasWidth = t),
                                    n != this.canvasHeight && (this.DOMs.comments.height = n, this.canvasHeight = n);
                                    var i = this.video.offsetWidth,
                                        o = this.video.offsetHeight;
                                    this.commentLoop(i, o, e),
                                        this.commentTop(i, o, e),
                                        this.commentBottom(i, o, e),
                                        this.drawText()
                                }
                            },
                            onCommentTimeUpdate: function () {
                                if (this.enableComment !== !1) {
                                    var e = this.video.currentTime;
                                    if (Math.abs(e - this.lastCommnetUpdateTime) <= 1 && e > this.lastCommnetUpdateTime) {
                                        var t = 0;
                                        for (this.lastCommnetIndex && this.comments[this.lastCommnetIndex].time <= this.lastCommnetUpdateTime && (t = this.lastCommnetIndex); ++t < this.comments.length;) if (!(this.comments[t].time <= this.lastCommnetUpdateTime)) {
                                            if (this.comments[t].time > e) break;
                                            switch (this.comments[t].pos) {
                                                case "bottom":
                                                    this.commentButtonPreQueue.push(this.comments[t]);
                                                    break;
                                                case "top":
                                                    this.commentTopPreQueue.push(this.comments[t]);
                                                    break;
                                                default:
                                                    this.commentLoopPreQueue.push(this.comments[t])
                                            }
                                            this.lastCommnetIndex = t
                                        }
                                    }
                                    try {
                                        this.drawComment()
                                    } catch (n) {}
                                    this.lastCommnetUpdateTime = e
                                }
                            }
                        }
                    },
                        {
                            "./createElement": 7
                        }],
                    4: [function (e, t) {
                        function n(e) {
                            return Array.prototype.slice.call(e)
                        }
                        function i(e, t, n, i) {
                            function o(t) {
                                var n = (t.clientX - e.parentNode.getBoundingClientRect().left) / e.parentNode.offsetWidth;
                                return Math.min(Math.max(n, 0), 1)
                            }
                            function r(t) {
                                1 == t.which && (l = !0, e.draging = !0, a(t))
                            }
                            function a(e) {
                                if (1 == e.which && l === !0) {
                                    var t = o(e);
                                    n(t)
                                }
                            }
                            function s(t) {
                                if (1 == t.which && l === !0) {
                                    var r = o(t);
                                    n(r),
                                        i(r),
                                        l = !1,
                                        delete e.draging
                                }
                            }
                            var l = !1;
                            n = n ||
                                function () {},
                                i = i ||
                                    function () {},
                                e.parentNode.addEventListener("mousedown", r),
                                t.addEventListener("mousemove", a),
                                t.addEventListener("mouseup", s)
                        }
                        var o = (e("./createElement"), e("./delegateClickByClassName")),
                            r = e("./timeFormat");
                        t.exports = {
                            init: function () {
                                var e = this.iframe.contentDocument,
                                    t = o(e);
                                t.on("play", this.onPlayClick, this),
                                    t.on("video-frame", this.onVideoClick, this),
                                    t.on("source", this.onSourceClick, this),
                                    t.on("allscreen", this.onAllScreenClick, this),
                                    t.on("fullscreen", this.onfullScreenClick, this),
                                    t.on("normalscreen", this.onNormalScreenClick, this),
                                    t.on("comments-btn", this.oncommentsBtnClick, this),
                                    t.on("airplay", this.onAirplayBtnClick, this),
                                    e.documentElement.addEventListener("keydown", this.onKeyDown.bind(this), !1),
                                    this.DOMs.player.addEventListener("mousemove", this.onMouseActive.bind(this)),
                                    i(this.DOMs.progress_anchor, e, this.onProgressAnchorWillSet.bind(this), this.onProgressAnchorSet.bind(this)),
                                    i(this.DOMs.volume_anchor, e, this.onVolumeAnchorWillSet.bind(this))
                            },
                            onKeyDown: function (e) {
                                switch (e.preventDefault(), e.keyCode) {
                                    case 32:
                                        this.onPlayClick();
                                        break;
                                    case 39:
                                        this.video.currentTime = Math.min(this.video.duration, this.video.currentTime + 10);
                                        break;
                                    case 37:
                                        this.video.currentTime = Math.max(0, this.video.currentTime - 10);
                                        break;
                                    case 38:
                                        this.video.volume = Math.min(1, this.video.volume + .1),
                                            this.DOMs.volume_anchor.style.width = 100 * this.video.volume + "%";
                                        break;
                                    case 40:
                                        this.video.volume = Math.max(0, this.video.volume - .1),
                                            this.DOMs.volume_anchor.style.width = 100 * this.video.volume + "%";
                                        break;
                                    case 65:
                                        this.DOMs.player.classList.contains("allscreen") ? this.onNormalScreenClick() : this.onAllScreenClick();
                                        break;
                                    case 70:
                                        this.DOMs.player.classList.contains("fullscreen") || this.onfullScreenClick()
                                }
                            },
                            onVideoClick: function () {
                                void 0 == this.videoClickDblTimer ? this.videoClickDblTimer = setTimeout(function () {
                                    this.videoClickDblTimer = void 0,
                                        this.onPlayClick()
                                }.bind(this), 300) : (clearTimeout(this.videoClickDblTimer), this.videoClickDblTimer = void 0, document.fullscreenElement || document.mozFullScreenElement || document.webkitFullscreenElement ? this.onNormalScreenClick() : this.onfullScreenClick())
                            },
                            onMouseActive: function () {
                                this.DOMs.player.classList.add("active"),
                                    clearTimeout(this.MouseActiveTimer),
                                    this.MouseActiveTimer = setTimeout(function () {
                                        this.DOMs.player.classList.remove("active")
                                    }.bind(this), 1e3)
                            },
                            onPlayClick: function () {
                                this.DOMs.play.classList.contains("paused") ? (this.video.play(), this.DOMs.play.classList.remove("paused")) : (this.video.pause(), this.DOMs.play.classList.add("paused"))
                            },
                            onSourceClick: function (e) {
                                e.classList.contains("curr") || (this.video.preloadStartTime = this.video.currentTime, this.video.src = this.sourceList[0 | e.getAttribute("sourceIndex")][1], n(e.parentNode.childNodes).forEach(function (t) {
                                    e === t ? t.classList.add("curr") : t.classList.remove("curr")
                                }.bind(this)))
                            },
                            onProgressAnchorWillSet: function (e) {
                                var t = this.video.duration,
                                    n = t * e;
                                this.DOMs.current.innerHTML = r(n),
                                    this.DOMs.duration.innerHTML = r(t),
                                    this.DOMs.progress_anchor.style.width = 100 * e + "%"
                            },
                            onProgressAnchorSet: function (e) {
                                this.video.currentTime = this.video.duration * e
                            },
                            onVolumeAnchorWillSet: function (e) {
                                this.video.volume = e,
                                    this.DOMs.volume_anchor.style.width = 100 * e + "%"
                            },
                            onAllScreenClick: function () {
                                var e = document.documentElement.clientWidth,
                                    t = document.documentElement.clientHeight;
                                this.iframe.style.cssText = ";position:fixed;top:0;left:0;width:" + e + "px;height:" + t + "px;z-index:999999;",
                                    this.allScreenWinResizeFunction = this.allScreenWinResizeFunction ||
                                        function () {
                                            this.iframe.style.width = document.documentElement.clientWidth + "px",
                                                this.iframe.style.height = document.documentElement.clientHeight + "px"
                                        }.bind(this),
                                    window.removeEventListener("resize", this.allScreenWinResizeFunction),
                                    window.addEventListener("resize", this.allScreenWinResizeFunction),
                                    this.DOMs.player.classList.add("allscreen")
                            },
                            onfullScreenClick: function () {
                                ["webkitRequestFullScreen", "mozRequestFullScreen", "requestFullScreen"].forEach(function (e) {
                                    this.DOMs.player[e] && this.DOMs.player[e]()
                                }.bind(this)),
                                    this.onMouseActive()
                            },
                            onNormalScreenClick: function () {
                                window.removeEventListener("resize", this.allScreenWinResizeFunction),
                                    this.iframe.style.cssText = ";width:" + this.size[0] + "px;height:" + this.size[1] + "px;",
                                    ["webkitCancelFullScreen", "mozCancelFullScreen", "cancelFullScreen"].forEach(function (e) {
                                        document[e] && document[e]()
                                    }),
                                    this.DOMs.player.classList.remove("allscreen")
                            },
                            oncommentsBtnClick: function () {
                                this.enableComment = !this.DOMs["comments-btn"].classList.contains("enable"),
                                    this.enableComment ? (setTimeout(function () {
                                        this.DOMs.comments.style.display = "block"
                                    }.bind(this), 80), this.DOMs["comments-btn"].classList.add("enable")) : (this.DOMs.comments.style.display = "none", this.DOMs["comments-btn"].classList.remove("enable"))
                            },
                            onAirplayBtnClick: function () {
                                this.video.webkitShowPlaybackTargetPicker()
                            }
                        }
                    },
                        {
                            "./createElement": 7,
                            "./delegateClickByClassName": 8,
                            "./timeFormat": 14
                        }],
                    5: [function (e, t) {
                        var n = (e("./extend"), e("./createElement"));
                        e("./parseDOMByClassNames"),
                            t.exports = {
                                init: function () {
                                    var e = 0;
                                    this.sourceList.forEach(function (t, i) {
                                        n("li", {
                                            appendTo: this.DOMs.hd,
                                            sourceIndex: i,
                                            className: "source " + (i === e ? "curr" : ""),
                                            innerHTML: t[0]
                                        })
                                    }.bind(this)),
                                        this.DOMs.video.src = this.sourceList[e][1]
                                }
                            }
                    },
                        {
                            "./createElement": 7,
                            "./extend": 9,
                            "./parseDOMByClassNames": 11
                        }],
                    6: [function (e, t) {
                        var n = e("./timeFormat");
                        t.exports = {
                            init: function () {
                                this.video.addEventListener("timeupdate", this.onVideoTimeUpdate.bind(this)),
                                    this.video.addEventListener("play", this.onVideoPlay.bind(this)),
                                    this.video.addEventListener("pause", this.onVideoTimePause.bind(this)),
                                    this.video.addEventListener("loadedmetadata", this.onVideoLoadedMetaData.bind(this)),
                                    this.video.addEventListener("webkitplaybacktargetavailabilitychanged", this.onPlaybackTargetAvailabilityChanged.bind(this)),
                                    setInterval(this.videoBuffered.bind(this), 1e3),
                                    this.DOMs.volume_anchor.style.width = 100 * this.video.volume + "%"
                            },
                            onVideoTimeUpdate: function () {
                                var e = this.video.currentTime,
                                    t = this.video.duration;
                                this.DOMs.current.innerHTML = n(e),
                                    this.DOMs.duration.innerHTML = n(t),
                                this.DOMs.progress_anchor.draging || (this.DOMs.progress_anchor.style.width = 100 * Math.min(Math.max(e / t, 0), 1) + "%")
                            },
                            videoBuffered: function () {
                                var e = this.video.buffered,
                                    t = this.video.currentTime,
                                    n = 0 == e.length ? 0 : e.end(e.length - 1);
                                this.DOMs.buffered_anchor.style.width = 100 * Math.min(Math.max(n / this.video.duration, 0), 1) + "%",
                                    0 == n || t >= n ? this.DOMs.player.classList.add("loading") : this.DOMs.player.classList.remove("loading")
                            },
                            onVideoPlay: function () {
                                this.DOMs.play.classList.remove("paused")
                            },
                            onVideoTimePause: function () {
                                this.DOMs.play.classList.add("paused")
                            },
                            onVideoLoadedMetaData: function () {
                                this.video.preloadStartTime && (this.video.currentTime = this.video.preloadStartTime, delete this.video.preloadStartTime)
                            },
                            onPlaybackTargetAvailabilityChanged: function (e) {
                                var t = "support-airplay";
                                "available" === e.availability ? this.DOMs.player.classList.add(t) : this.DOMs.player.classList.remove(t)
                            }
                        }
                    },
                        {
                            "./timeFormat": 14
                        }],
                    7: [function (e, t) {
                        function n(e, t) {
                            var n = document.createElement(e);
                            if ("function" == typeof t) t.call(n);
                            else for (var i in t) if (t.hasOwnProperty(i)) switch (i) {
                                case "appendTo":
                                    t[i].appendChild(n);
                                    break;
                                case "text":
                                    var o = document.createTextNode(t[i]);
                                    n.innerHTML = "",
                                        n.appendChild(o);
                                    break;
                                case "innerHTML":
                                case "className":
                                case "id":
                                    n[i] = t[i];
                                    break;
                                case "style":
                                    var r = t[i];
                                    for (var a in r) r.hasOwnProperty(a) && (n.style[a] = r[a]);
                                    break;
                                default:
                                    n.setAttribute(i, t[i] + "")
                            }
                            return n
                        }
                        t.exports = n
                    },
                        {}],
                    8: [function (e, t) {
                        function n(e) {
                            return Array.prototype.slice.call(e)
                        }
                        function i(e) {
                            this._eventMap = {},
                                this._rootElement = e,
                                this._isRootElementBindedClick = !1,
                                this._bindClickFunction = function (e) {
                                    !
                                        function t(e, i) {
                                            i && i.nodeName && (i.classList && n(i.classList).forEach(function (t) {
                                                e.trigger(t, i)
                                            }), t(e, i.parentNode))
                                        }(this, e.target)
                                }.bind(this)
                        }
                        var o = e("./extend");
                        o(i.prototype, {
                            on: function (e, t, n) {
                                void 0 === this._eventMap[e] && (this._eventMap[e] = []),
                                    this._eventMap[e].push([t, n]),
                                this._isRootElementBindedClick || (_isRootElementBindedClick = !0, this._rootElement.addEventListener("click", this._bindClickFunction, !1))
                            },
                            off: function (e, t) {
                                if (void 0 != this._eventMap[e]) for (var n = this._eventMap[e].length; n--;) if (this._eventMap[e][n][0] === t) {
                                    this._eventMap[e].splice(n, 1);
                                    break
                                }
                                for (var i in this._eventMap) break;
                                void 0 === i && this._isRootElementBindedClick && (_isRootElementBindedClick = !1, this._rootElement.removeEventListener("click", this._bindClickFunction, !1))
                            },
                            trigger: function (e, t) {
                                t = void 0 === t ? this._rootElement.getElementsByTagNames(e) : [t],
                                    t.forEach(function (t) {
                                        (this._eventMap[e] || []).forEach(function (e) {
                                            e[0].call(e[1], t)
                                        })
                                    }.bind(this))
                            }
                        }),
                            t.exports = function (e) {
                                return new i(e)
                            }
                    },
                        {
                            "./extend": 9
                        }],
                    9: [function (e, t) {
                        function n(e) {
                            for (var t, n = arguments.length, i = 1; n > i;) {
                                t = arguments[i++];
                                for (var o in t) t.hasOwnProperty(o) && (e[o] = t[o])
                            }
                            return e
                        }
                        t.exports = n
                    },
                        {}],
                    10: [function (e) {
                        function t(e, t, n, i) {
                            this.id = e,
                                this.size = t.split("x"),
                                this.sourceList = n || [],
                                this.comments = i,
                                this.init()
                        }
                        e("./component")(t, e("./component_build"), e("./component_event"), e("./component_video"), e("./component_source"), e("./component_comments")),
                            n = t
                    },
                        {
                            "./component": 1,
                            "./component_build": 2,
                            "./component_comments": 3,
                            "./component_event": 4,
                            "./component_source": 5,
                            "./component_video": 6
                        }],
                    11: [function (e, t) {
                        function n(e, t) {
                            var n = {};
                            return t.forEach(function (t) {
                                n[t] = e.getElementsByClassName(t)[0]
                            }),
                                n
                        }
                        t.exports = n
                    },
                        {}],
                    12: [function (e, t) {
                        t.exports = '* { margin:0; padding:0; }body { font-family: "PingHei","Lucida Grande", "Lucida Sans Unicode", "STHeiti", "Helvetica","Arial","Verdana","sans-serif"; font-size:16px;}html, body, .player { height: 100%; }.player:-webkit-full-screen { width: 100%; cursor:url(data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==); }.player:-moz-full-screen { width: 100%; cursor:url(data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==); }.player:full-screen { width: 100%; cursor:url(data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==); }.player { border-radius: 3px; overflow: hidden; position: relative; cursor: default;  -webkit-user-select: none;  -moz-user-select: none; user-select: none;}.video-frame { box-sizing: border-box; padding-bottom: 50px; height: 100%; overflow: hidden; position: relative;}.video-frame .comments{ position: absolute; top:0;left:0; width:100%; height:100%;  -webkit-transform:translateZ(0);  -moz-transform:translateZ(0); transform:translateZ(0);  pointer-events: none;}.player:-webkit-full-screen .video-frame { padding-bottom: 0px; }.player:-moz-full-screen .video-frame { padding-bottom: 0px; }.player:full-screen .video-frame{ padding-bottom: 0px; }.video { width: 100%;  height: 100%; background: #000000;}.controller {  position: absolute; bottom: 0px;  left:0; right:0;  background: #24272A;  height: 50px;}.controller .loading-icon { display: none;  position: absolute; width: 20px;  height: 20px; line-height: 20px;  text-align: center; font-size: 20px;  color: #ffffff; top: -30px; right: 10px;}.player.loading .controller .loading-icon {  display: block;}.player:-webkit-full-screen .controller { -webkit-transform:translateY(50px); -webkit-transition: -webkit-transform 0.3s ease;}.player:-moz-full-screen .controller { -moz-transform:translateY(50px);  -moz-transition: -moz-transform 0.3s ease;}.player:full-screen .controller {  transform:translateY(50px); transition: transform 0.3s ease;}.player.active:-webkit-full-screen { cursor: default;}.player.active:-moz-full-screen {  cursor: default;}.player.active:full-screen { cursor: default;}.player.active:-webkit-full-screen .controller,.player:-webkit-full-screen .controller:hover { -webkit-transform:translateY(0);  cursor: default;}.player.active:-moz-full-screen .controller,.player:-moz-full-screen .controller:hover { -moz-transform:translateY(0); cursor: default;}.player.active:full-screen .controller.player:full-screen .controller:hover {  transform:translateY(0);  cursor: default;}.player.active:-webkit-full-screen .controller .progress .progress_anchor:after,.player:-webkit-full-screen .controller:hover .progress .progress_anchor:after { height:12px;}.player.active:-moz-full-screen .controller .progress .progress_anchor:after,.player:-moz-full-screen .controller:hover .progress .progress_anchor:after { height:12px;}.player.active:full-screen .controller .progress .progress_anchor:after,.player:full-screen .controller:hover .progress .progress_anchor:after { height:12px;}.player:-webkit-full-screen .controller .progress .progress_anchor:after { height:4px;}.player:-moz-full-screen .controller .progress .progress_anchor:after { height:4px;}.player:full-screen .controller .progress .progress_anchor:after {  height:4px;}.controller .progress { position: absolute; top:0px;  left:0; right:0;  border-right: 4px solid #181A1D;  border-left: 8px solid #B3ABAB; height: 4px;  background: #181A1D;  z-index:1;  -webkit-transform: translateZ(0); -moz-transform: translateZ(0);  transform: translateZ(0);}.controller .progress:after { content:""; display: block; position: absolute; top:0px;  left:0; right:0;  bottom:-10px; height: 10px;}.controller .progress .anchor { height: 4px;  background: #B3ABAB;  position: absolute; top:0;left:0;}.controller .progress .anchor:after { content:""; display: block; width: 12px;  background: #f5f5f5;  position: absolute; right:-4px; top: 50%; height: 12px; box-shadow: 0 0 2px rgba(0,0,0, 0.4); border-radius: 12px;  -webkit-transform: translateY(-50%);  -moz-transform: translateY(-50%); transform: translateY(-50%);}.controller .progress .anchor.buffered_anchor {  position: relative; background: rgba(255,255,255,0.1);}.controller .progress .anchor.buffered_anchor:after {  box-shadow: none; height: 4px;  width: 4px; border-radius: 0; background: rgba(255,255,255,0.1);}.controller .right { height: 50px; position: absolute; top:0;  left:10px;  right:10px; pointer-events: none;}.controller .play,.controller .volume,.controller .time,.controller .hd,.controller .airplay,.controller .allscreen,.controller .normalscreen,.controller .comments-btn,.controller .fullscreen { padding-top:4px;  height: 46px; line-height: 50px;  text-align: center; color: #eeeeee; float:left; text-shadow:0 0 2px rgba(0,0,0,0.5);  pointer-events: auto;}.controller .hd,.controller .airplay,.controller .allscreen,.controller .normalscreen,.controller .comments-btn,.controller .fullscreen { float:right;}.controller .play {  width: 36px;  padding-left: 10px; cursor: pointer;}.controller .play:after {  font-family: "FontAwesome"; content: "\\f04c";}.controller .play.paused:after { content: "\\f04b";}.controller .volume {  min-width: 30px;  position: relative; overflow: hidden; -webkit-transition: min-width 0.3s ease 0.5s; -moz-transition: min-width 0.3s ease 0.5s;  transition: min-width 0.3s ease 0.5s;}.controller .volume:hover { min-width: 128px;}.controller .volume:before {  font-family: "FontAwesome"; content: "\\f028";  width: 36px;  display: block;}.controller .volume .progress { width: 70px;  top: 27px;  left: 40px;}.controller .time { font-size: 12px;  font-weight: bold;  padding-left: 10px;}.controller .time .current {  color: #EEEEEE;}.controller .fullscreen,.controller .airplay,.controller .allscreen,.controller .comments-btn,.controller .normalscreen { width: 36px;  cursor: pointer;}.controller .comments-btn {  margin-right: -15px;  display: none;}.player.has-comments .controller .comments-btn { display: block;}.controller .comments-btn:before {  font-family: "FontAwesome"; content: "\\f075";}.controller .comments-btn.enable:before {  color: #DF6558;}.controller .airplay,.controller .normalscreen {  display: none;}.player:-webkit-full-screen .controller .fullscreen,.player:-webkit-full-screen .controller .allscreen { display: none;}.player:-webkit-full-screen .controller .normalscreen,.player.allscreen .controller .normalscreen,.player.support-airplay .controller .airplay { display: block;}.player.allscreen .controller .allscreen {  display: none;}.controller .fullscreen:before { font-family: "FontAwesome"; content: "\\f0b2";}.controller .allscreen:before {  font-family: "FontAwesome"; content: "\\f065";}.controller .normalscreen:before { font-family: "FontAwesome"; content: "\\f066";}.controller .airplay { background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz48IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4iICJodHRwOi8vd3d3LnczLm9yZy9HcmFwaGljcy9TVkcvMS4xL0RURC9zdmcxMS5kdGQiPjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0ibWFtYS1haXJwbGF5LWljb24iIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjJweCIgaGVpZ2h0PSIxNnB4IiB2aWV3Qm94PSIwIDAgMjIgMTYiIHhtbDpzcGFjZT0icHJlc2VydmUiPjxwb2x5bGluZSBwb2ludHM9IjUsMTIgMSwxMiAxLDEgMjEsMSAyMSwxMiAxNywxMiIgc3R5bGU9ImZpbGw6dHJhbnNwYXJlbnQ7c3Ryb2tlOndoaXRlO3N0cm9rZS13aWR0aDoxIi8+PHBvbHlsaW5lIHBvaW50cz0iNCwxNiAxMSwxMCAxOCwxNiIgc3R5bGU9ImZpbGw6d2hpdGU7c3Ryb2tlOnRyYW5zcGFyZW50O3N0cm9rZS13aWR0aDowIi8+PC9zdmc+DQo=) no-repeat center 20px;  background-size: 22px auto;}.controller .hd { white-space:nowrap; overflow: hidden; margin-right: 10px; text-align: right;}.controller .hd:hover li { max-width: 300px;}.controller .hd li {  display: inline-block;  max-width: 0px; -webkit-transition: max-width 0.8s ease 0.3s; -moz-transition: max-width 0.8s ease 0.3s;  transition: max-width 0.8s ease 0.3s; overflow: hidden; font-size: 14px;  font-weight: bold;  position: relative; cursor: pointer;}.controller .hd li:before {  content: "";  display: inline-block;  width:20px;}.controller .hd li:before { content: "";  display: inline-block;  width:20px;}.controller .hd li.curr { max-width: 300px; cursor: default;  color: #EEEEEE;}.controller .hd li.curr:after { content: "";  display: block; position: absolute; width:4px;  height:4px; border-radius: 50%; background: #ffffff;  left: 12px; top: 23px;  opacity: 0; -webkit-transition: opacity 0.5s ease 0.3s; -moz-transition: opacity 0.5s ease 0.3s;  transition: opacity 0.5s ease 0.3s;}'
                    },
                        {}],
                    13: [function (e, t) {
                        t.exports = '<div class="player">  <div class="video-frame"><video class="video" autoplay="autoplay"></video><canvas class="comments"></canvas></div>  <div class="controller">    <div class="loading-icon fa fa-spin fa-circle-o-notch"></div>   <div class="progress">      <div class="anchor buffered_anchor" style="width:0%"></div>     <div class="anchor progress_anchor" style="width:0%"></div>   </div>    <div class="right">     <div class="fullscreen"></div>      <div class="allscreen"></div>     <div class="normalscreen"></div>      <div class="airplay"></div>     <ul class="hd"></ul>      <div class="comments-btn"></div>     </div>    <div class="left">     <div class="play paused"></div>     <div class="volume">        <div class="progress">          <div class="anchor volume_anchor" style="width:0%"></div>       </div>      </div>      <div class="time">        <span class="current">00:00:00</span> / <span class="duration">00:00:00</span>      </div>     </div> </div></div>'
                    },
                        {}],
                    14: [function (e, t) {
                        function n(e, t) {
                            return (Array(t).join(0) + e).slice(-t)
                        }
                        function i(e) {
                            var t, i = [];
                            return [3600, 60, 1].forEach(function (o) {
                                i.push(n(t = e / o | 0, 2)),
                                    e -= t * o
                            }),
                                i.join(":")
                        }
                        t.exports = i
                    },
                        {}]
                }, {}, [10]),
                t.exports = n
        },
            {}],
        10: [function (e, t) {
            function n(e, t) {
                for (var n = decodeURI(e), i = f[t ? "strict" : "loose"].exec(n), o = {
                    attr: {},
                    param: {},
                    seg: {}
                }, r = 14; r--;) o.attr[p[r]] = i[r] || "";
                return o.param.query = a(o.attr.query),
                    o.param.fragment = a(o.attr.fragment),
                    o.seg.path = o.attr.path.replace(/^\/+|\/+$/g, "").split("/"),
                    o.seg.fragment = o.attr.fragment.replace(/^\/+|\/+$/g, "").split("/"),
                    o.attr.base = o.attr.host ? (o.attr.protocol ? o.attr.protocol + "://" + o.attr.host : o.attr.host) + (o.attr.port ? ":" + o.attr.port : "") : "",
                    o
            }
            function i(e, t) {
                if (0 === e[t].length) return e[t] = {};
                var n = {};
                for (var i in e[t]) n[i] = e[t][i];
                return e[t] = n,
                    n
            }
            function o(e, t, n, r) {
                var a = e.shift();
                if (a) {
                    var s = t[n] = t[n] || [];
                    "]" == a ? d(s) ? "" !== r && s.push(r) : "object" == typeof s ? s[u(s).length] = r : s = t[n] = [t[n], r] : ~a.indexOf("]") ? (a = a.substr(0, a.length - 1), !v.test(a) && d(s) && (s = i(t, n)), o(e, s, a, r)) : (!v.test(a) && d(s) && (s = i(t, n)), o(e, s, a, r))
                } else d(t[n]) ? t[n].push(r) : t[n] = "object" == typeof t[n] ? r : "undefined" == typeof t[n] ? r : [t[n], r]
            }
            function r(e, t, n) {
                if (~t.indexOf("]")) {
                    var i = t.split("[");
                    o(i, e, "base", n)
                } else {
                    if (!v.test(t) && d(e.base)) {
                        var r = {};
                        for (var a in e.base) r[a] = e.base[a];
                        e.base = r
                    }
                    "" !== t && s(e.base, t, n)
                }
                return e
            }
            function a(e) {
                return c(String(e).split(/&|;/), function (e, t) {
                    try {
                        t = decodeURIComponent(t.replace(/\+/g, " "))
                    } catch (n) {}
                    var i = t.indexOf("="),
                        o = l(t),
                        a = t.substr(0, o || i),
                        s = t.substr(o || i, t.length);
                    return s = s.substr(s.indexOf("=") + 1, s.length),
                    "" === a && (a = t, s = ""),
                        r(e, a, s)
                }, {
                    base: {}
                }).base
            }
            function s(e, t, n) {
                var i = e[t];
                "undefined" == typeof i ? e[t] = n : d(i) ? i.push(n) : e[t] = [i, n]
            }
            function l(e) {
                for (var t, n, i = e.length, o = 0; i > o; ++o) if (n = e[o], "]" == n && (t = !1), "[" == n && (t = !0), "=" == n && !t) return o
            }
            function c(e, t) {
                for (var n = 0, i = e.length >> 0, o = arguments[2]; i > n;) n in e && (o = t.call(void 0, o, e[n], n, e)),
                    ++n;
                return o
            }
            function d(e) {
                return "[object Array]" === Object.prototype.toString.call(e)
            }
            function u(e) {
                var t = [];
                for (var n in e) e.hasOwnProperty(n) && t.push(n);
                return t
            }
            function h(e, t) {
                return 1 === arguments.length && e === !0 && (t = !0, e = void 0),
                    t = t || !1,
                    e = e || window.location.toString(),
                {
                    data: n(e, t),
                    attr: function (e) {
                        return e = m[e] || e,
                            "undefined" != typeof e ? this.data.attr[e] : this.data.attr
                    },
                    param: function (e) {
                        return "undefined" != typeof e ? this.data.param.query[e] : this.data.param.query
                    },
                    fparam: function (e) {
                        return "undefined" != typeof e ? this.data.param.fragment[e] : this.data.param.fragment
                    },
                    segment: function (e) {
                        return "undefined" == typeof e ? this.data.seg.path : (e = 0 > e ? this.data.seg.path.length + e : e - 1, this.data.seg.path[e])
                    },
                    fsegment: function (e) {
                        return "undefined" == typeof e ? this.data.seg.fragment : (e = 0 > e ? this.data.seg.fragment.length + e : e - 1, this.data.seg.fragment[e])
                    }
                }
            }
            var p = ["source", "protocol", "authority", "userInfo", "user", "password", "host", "port", "relative", "path", "directory", "file", "query", "fragment"],
                m = {
                    anchor: "fragment"
                },
                f = {
                    strict: /^(?:([^:\/?#]+):)?(?:\/\/((?:(([^:@]*):?([^:@]*))?@)?([^:\/?#]*)(?::(\d*))?))?((((?:[^?#\/]*\/)*)([^?#]*))(?:\?([^#]*))?(?:#(.*))?)/,
                    loose: /^(?:(?![^:@]+:[^:@\/]*@)([^:\/?#.]+):)?(?:\/\/)?((?:(([^:@]*):?([^:@]*))?@)?([^:\/?#]*)(?::(\d*))?)(((\/(?:[^?#](?![^?#\/]*\.[^?#\/.]+(?:[?#]|$)))*\/?)?([^?#\/]*))(?:\?([^#]*))?(?:#(.*))?)/
                },
                v = /^[0-9]+$/;
            t.exports = h
        },
            {}],
        11: [function (e, t) {
            function n(e) {
                var t = [];
                for (var n in e) e.hasOwnProperty(n) && t.push([n, e[n]].join("="));
                return t.join("&")
            }
            t.exports = n
        },
            {}],
        12: [function (e, t, n) {
            var i = e("./canPlayM3U8"),
                o = e("./ajax");
            n.match = function (e) {
                return /www\.hunantv\.com/.test(e.attr("host"))
            },
                n.getVideos = function (e, t) {
                    if (i) {
                        var n = function (e) {
                                var t = e.split("?")[1],
                                    n = new Array;
                                n = t.split("&");
                                var i = {};
                                for (key in n) param = n[key],
                                    item = new Array,
                                    item = n[key].split("="),
                                "" != item[0] && (i[item[0]] = item[1]);
                                return i
                            },
                            r = "&fmt=6&pno=7&m3u8=1",
                            a = document.getElementsByName("FlashVars")[0].getAttribute("value"),
                            s = a.split("&file=")[1],
                            l = s.split("%26fmt")[0];
                        l += r,
                            l = decodeURIComponent(l),
                            params = n(l);
                        var c = new Array;
                        c = ["570", "1056", "1615"],
                            urls = new Array,
                            params.limitrate = c[0],
                            text = "\u6807\u6e05",
                            o({
                                url: "http://pcvcr.cdn.imgo.tv/ncrs/vod.do",
                                jsonp: !0,
                                param: params,
                                callback: function (e) {
                                    "ok" == e.status && urls.push([text, e.info]),
                                        params.limitrate = c[1],
                                        text = "\u9ad8\u6e05",
                                        o({
                                            url: "http://pcvcr.cdn.imgo.tv/ncrs/vod.do",
                                            jsonp: !0,
                                            param: params,
                                            callback: function (e) {
                                                "ok" == e.status && urls.push([text, e.info]),
                                                    params.limitrate = c[2],
                                                    text = "\u8d85\u6e05",
                                                    o({
                                                        url: "http://pcvcr.cdn.imgo.tv/ncrs/vod.do",
                                                        jsonp: !0,
                                                        param: params,
                                                        callback: function (e) {
                                                            return "ok" == e.status && urls.push([text, e.info]),
                                                                t(urls)
                                                        }
                                                    })
                                            }
                                        })
                                }
                            })
                    } else console.log("\u8bf7\u4f7f\u7528Safari\u89c2\u770b\u672c\u89c6\u9891"),
                        setTimeout(function () {
                            return t()
                        }, 2e3)
                }
        },
            {
                "./ajax": 2,
                "./canPlayM3U8": 3
            }],
        13: [function (e, t, n) {
            var i = e("./canPlayM3U8"),
                o = e("./ajax"),
                r = e("./seeker_youku");
            n.match = function (e) {
                var t = window.iid || window.pageConfig && window.pageConfig.iid || window.itemData && window.itemData.iid,
                    n = window.itemData && window.itemData.vcode;
                return /tudou\.com/.test(e.attr("host")) && (n || t)
            },
                n.getVideos = function (e, t) {
                    var n = window.itemData && window.itemData.vcode;
                    if (n) return r.parseYoukuCode(n, t);
                    var a = window.iid || window.pageConfig && window.pageConfig.iid || window.itemData && window.itemData.iid,
                        s = function (e) {
                            var t, n = [
                                ["\u539f\u753b", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=5"],
                                ["\u8d85\u6e05", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=4"],
                                ["\u9ad8\u6e05", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=3"],
                                ["\u6807\u6e05", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=2"]
                            ];
                            window.itemData && window.itemData.segs && (n = [], t = JSON.parse(window.itemData.segs), t[5] && n.push(["\u539f\u753b", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=5"]), t[4] && n.push(["\u8d85\u6e05", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=4"]), t[3] && n.push(["\u9ad8\u6e05", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=3"]), t[2] && n.push(["\u6807\u6e05", "http://vr.tudou.com/v2proxy/v2.m3u8?it=" + a + "&st=2"])),
                                console.log("\u89e3\u6790tudou\u89c6\u9891\u5730\u5740\u6210\u529f " + n.map(function (e) {
                                        return "<a href=" + e[1] + ">" + e[0] + "</a>"
                                    }).join(" ")),
                                e(n)
                        },
                        l = function (e) {
                            o({
                                url: "http://vr.tudou.com/v2proxy/v2.js",
                                param: {
                                    it: a,
                                    st: "52%2C53%2C54"
                                },
                                jsonp: "jsonp",
                                callback: function (t) {
                                    if (-1 === t || -1 == t.code) return console.log("\u89e3\u6790tudou\u89c6\u9891\u5730\u5740\u5931\u8d25");
                                    for (var n = [], i = 0, o = t.urls.length; o > i; i++) n.push([i, t.urls[i]]);
                                    return console.log("\u89e3\u6790tudou\u89c6\u9891\u5730\u5740\u6210\u529f " + n.map(function (e) {
                                            return "<a href=" + e[1] + ">" + e[0] + "</a>"
                                        }).join(" ")),
                                        e(n)
                                }
                            })
                        };
                    i ? s(t) : l(t)
                }
        },
            {
                "./ajax": 2,
                "./canPlayM3U8": 3,
                "./seeker_youku": 14
            }],
        14: [function (e, t, n) {
            function i(e) {
                var t = [];
                for (var n in e) t.push(n + "=" + e[n]);
                return t.join("&")
            }
            function o(e) {
                if (!e) return "";
                e = e.toString();
                var t, n, i, o, r, a, s, l = new Array(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
                for (a = e.length, r = 0, s = ""; a > r;) {
                    do t = l[255 & e.charCodeAt(r++)];
                    while (a > r && -1 == t);
                    if (-1 == t) break;
                    do n = l[255 & e.charCodeAt(r++)];
                    while (a > r && -1 == n);
                    if (-1 == n) break;
                    s += String.fromCharCode(t << 2 | (48 & n) >> 4);
                    do {
                        if (i = 255 & e.charCodeAt(r++), 61 == i) return s;
                        i = l[i]
                    } while (a > r && -1 == i);
                    if (-1 == i) break;
                    s += String.fromCharCode((15 & n) << 4 | (60 & i) >> 2);
                    do {
                        if (o = 255 & e.charCodeAt(r++), 61 == o) return s;
                        o = l[o]
                    } while (a > r && -1 == o);
                    if (-1 == o) break;
                    s += String.fromCharCode((3 & i) << 6 | o)
                }
                return s
            }
            function r(e) {
                if (!e) return "";
                e = e.toString();
                var t, n, i, o, r, a, s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
                for (i = e.length, n = 0, t = ""; i > n;) {
                    if (o = 255 & e.charCodeAt(n++), n == i) {
                        t += s.charAt(o >> 2),
                            t += s.charAt((3 & o) << 4),
                            t += "==";
                        break
                    }
                    if (r = e.charCodeAt(n++), n == i) {
                        t += s.charAt(o >> 2),
                            t += s.charAt((3 & o) << 4 | (240 & r) >> 4),
                            t += s.charAt((15 & r) << 2),
                            t += "=";
                        break
                    }
                    a = e.charCodeAt(n++),
                        t += s.charAt(o >> 2),
                        t += s.charAt((3 & o) << 4 | (240 & r) >> 4),
                        t += s.charAt((15 & r) << 2 | (192 & a) >> 6),
                        t += s.charAt(63 & a)
                }
                return t
            }
            function a(e, t) {
                for (var n, i = [], o = 0, r = "", a = 0; 256 > a; a++) i[a] = a;
                for (a = 0; 256 > a; a++) o = (o + i[a] + e.charCodeAt(a % e.length)) % 256,
                    n = i[a],
                    i[a] = i[o],
                    i[o] = n;
                a = 0,
                    o = 0;
                for (var s = 0; s < t.length; s++) a = (a + 1) % 256,
                    o = (o + i[a]) % 256,
                    n = i[a],
                    i[a] = i[o],
                    i[o] = n,
                    r += String.fromCharCode(t.charCodeAt(s) ^ i[(i[a] + i[o]) % 256]);
                return r
            }
            function s(e, t) {
                for (var n = [], i = 0; i < e.length; i++) {
                    var o = 0;
                    o = e[i] >= "a" && e[i] <= "z" ? e[i].charCodeAt(0) - "a".charCodeAt(0) : e[i] - "0" + 26;
                    for (var r = 0; 36 > r; r++) if (t[r] == o) {
                        o = r;
                        break
                    }
                    n[i] = o > 25 ? o - 26 : String.fromCharCode(o + 97)
                }
                return n.join("")
            }
            function l(e, t, n) {
                var i = this;
                new Date,
                    this._sid = m.sid,
                    this._fileType = n,
                    this._videoSegsDic = {},
                    this._ip = e.security.ip;
                var o = (new c, []),
                    r = [];
                r.streams = {},
                    r.logos = {},
                    r.typeArr = {},
                    r.totalTime = {};
                for (var a = 0; a < t.length; a++) {
                    for (var s = t[a].audio_lang, l = !1, d = 0; d < o.length; d++) if (o[d] == s) {
                        l = !0;
                        break
                    }
                    l || o.push(s)
                }
                for (var a = 0; a < o.length; a++) {
                    for (var u = o[a], h = {}, p = {}, f = [], d = 0; d < t.length; d++) {
                        var v = t[d];
                        if (u == v.audio_lang) {
                            if (!i.isValidType(v.stream_type)) continue;
                            var g = i.convertType(v.stream_type),
                                y = 0;
                            "none" != v.logo && (y = 1),
                                p[g] = y;
                            var b = !1;
                            for (var w in f) g == f[w] && (b = !0);
                            b || f.push(g);
                            var x = v.segs;
                            if (null == x) continue;
                            var k = [];
                            b && (k = h[g]);
                            for (var A = 0; A < x.length; A++) {
                                var C = x[A];
                                if (null == C) break;
                                var T = {};
                                T.no = A,
                                    T.size = C.size,
                                    T.seconds = Number(C.total_milliseconds_video) / 1e3,
                                    T.milliseconds_video = Number(v.milliseconds_video) / 1e3,
                                    T.key = C.key,
                                    T.fileId = this.getFileId(v.stream_fileid, A),
                                    T.src = this.getVideoSrc(d, A, e, v.stream_type, T.fileId),
                                    T.type = g,
                                    k.push(T)
                            }
                            h[g] = k
                        }
                    }
                    var M = this.langCodeToCN(u).key;
                    r.logos[M] = p,
                        r.streams[M] = h,
                        r.typeArr[M] = f
                }
                this._videoSegsDic = r,
                    this._videoSegsDic.lang = this.langCodeToCN(o[0]).key
            }
            function c(e) {
                this._randomSeed = e,
                    this.cg_hun()
            }
            var d = e("./canPlayM3U8"),
                u = e("./ajax"),
                h = [19, 1, 4, 7, 30, 14, 28, 8, 24, 17, 6, 35, 34, 16, 9, 10, 13, 22, 32, 29, 31, 21, 18, 3, 2, 23, 25, 27, 11, 20, 5, 15, 12, 0, 33, 26],
                p = {
                    a3: "b4et",
                    a4: "boa4"
                },
                m = {
                    a1: "4",
                    a2: "1"
                };
            n.match = function (e) {
                return /v\.youku\.com/.test(e.attr("host")) && !! window.videoId
            },
                n.parseYoukuCode = function (e, t) {
                    u({
                        url: "http://play.youku.com/play/get.json?vid=" + e + "&ct=12",
                        jsonp: !0,
                        callback: function (n) {
                            -1 == n && console.log("\u89e3\u6790youku\u89c6\u9891\u5730\u5740\u5931\u8d25", 2);
                            var c = n.data,
                                u = a(s(p.a3 + "o0b" + m.a1, h).toString(), o(c.security.encrypt_string)).split("_");
                            if (m.sid = u[0], m.token = u[1], d) {
                                var f = {
                                        vid: window.videoId,
                                        type: "[[type]]",
                                        ts: parseInt((new Date).getTime() / 1e3),
                                        keyframe: 0,
                                        ep: encodeURIComponent(r(a(s(p.a4 + "poz" + m.a2, h).toString(), m.sid + "_" + e + "_" + m.token))),
                                        sid: m.sid,
                                        token: m.token,
                                        ctype: 12,
                                        ev: 1,
                                        oip: c.security.ip,
                                        client_id: "youkumobileplaypage"
                                    },
                                    v = "http://pl.youku.com/playlist/m3u8?" + i(f);
                                t([
                                    ["\u8d85\u6e05", v.replace("[[type]]", "hd2")],
                                    ["\u9ad8\u6e05", v.replace("[[type]]", "mp4")],
                                    ["\u6807\u6e05", v.replace("[[type]]", "flv")]
                                ])
                            } else {
                                var g = new l(c, c.stream, "mp4");
                                console.log(g._videoSegsDic.streams),
                                    t([
                                        ["\u6807\u6e05", g._videoSegsDic.streams.guoyu["3gphd"][0].src]
                                    ])
                            }
                        }
                    })
                },
                n.getVideos = function (e, t) {
                    n.parseYoukuCode(window.videoId, t)
                },
                c.prototype = {
                    cg_hun: function () {
                        this._cgStr = "";
                        for (var e = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/\\:._-1234567890", t = e.length, n = 0; t > n; n++) {
                            var i = parseInt(this.ran() * e.length);
                            this._cgStr += e.charAt(i),
                                e = e.split(e.charAt(i)).join("")
                        }
                    },
                    cg_fun: function (e) {
                        for (var t = e.split("*"), n = "", i = 0; i < t.length - 1; i++) n += this._cgStr.charAt(t[i]);
                        return n
                    },
                    ran: function () {
                        return this._randomSeed = (211 * this._randomSeed + 30031) % 65536,
                        this._randomSeed / 65536
                    }
                },
                l.prototype = {
                    getFileId: function (e, t) {
                        if (null == e || "" == e) return "";
                        var n = "",
                            i = e.slice(0, 8),
                            o = t.toString(16);
                        1 == o.length && (o = "0" + o),
                            o = o.toUpperCase();
                        var r = e.slice(10, e.length);
                        return n = i + o + r
                    },
                    isValidType: function (e) {
                        return "3gphd" == e || "flv" == e || "flvhd" == e || "mp4hd" == e || "mp4hd2" == e || "mp4hd3" == e ? !0 : !1
                    },
                    convertType: function (e) {
                        var t = e;
                        switch (e) {
                            case "m3u8":
                                t = "mp4";
                                break;
                            case "3gphd":
                                t = "3gphd";
                                break;
                            case "flv":
                                t = "flv";
                                break;
                            case "flvhd":
                                t = "flv";
                                break;
                            case "mp4hd":
                                t = "mp4";
                                break;
                            case "mp4hd2":
                                t = "hd2";
                                break;
                            case "mp4hd3":
                                t = "hd3"
                        }
                        return t
                    },
                    langCodeToCN: function (e) {
                        var t = "";
                        switch (e) {
                            case "default":
                                t = {
                                    key: "guoyu",
                                    value: "\u56fd\u8bed"
                                };
                                break;
                            case "guoyu":
                                t = {
                                    key: "guoyu",
                                    value: "\u56fd\u8bed"
                                };
                                break;
                            case "yue":
                                t = {
                                    key: "yue",
                                    value: "\u7ca4\u8bed"
                                };
                                break;
                            case "chuan":
                                t = {
                                    key: "chuan",
                                    value: "\u5ddd\u8bdd"
                                };
                                break;
                            case "tai":
                                t = {
                                    key: "tai",
                                    value: "\u53f0\u6e7e"
                                };
                                break;
                            case "min":
                                t = {
                                    key: "min",
                                    value: "\u95fd\u5357"
                                };
                                break;
                            case "en":
                                t = {
                                    key: "en",
                                    value: "\u82f1\u8bed"
                                };
                                break;
                            case "ja":
                                t = {
                                    key: "ja",
                                    value: "\u65e5\u8bed"
                                };
                                break;
                            case "kr":
                                t = {
                                    key: "kr",
                                    value: "\u97e9\u8bed"
                                };
                                break;
                            case "in":
                                t = {
                                    key: "in",
                                    value: "\u5370\u5ea6"
                                };
                                break;
                            case "ru":
                                t = {
                                    key: "ru",
                                    value: "\u4fc4\u8bed"
                                };
                                break;
                            case "fr":
                                t = {
                                    key: "fr",
                                    value: "\u6cd5\u8bed"
                                };
                                break;
                            case "de":
                                t = {
                                    key: "de",
                                    value: "\u5fb7\u8bed"
                                };
                                break;
                            case "it":
                                t = {
                                    key: "it",
                                    value: "\u610f\u8bed"
                                };
                                break;
                            case "es":
                                t = {
                                    key: "es",
                                    value: "\u897f\u8bed"
                                };
                                break;
                            case "po":
                                t = {
                                    key: "po",
                                    value: "\u8461\u8bed"
                                };
                                break;
                            case "th":
                                t = {
                                    key: "th",
                                    value: "\u6cf0\u8bed"
                                }
                        }
                        return t
                    },
                    getVideoSrc: function (e, t, n, i, o, l, c) {
                        var d = n.stream[e],
                            u = n.video.encodeid;
                        if (!u || !i) return "";
                        var f = {
                                flv: 0,
                                flvhd: 0,
                                mp4: 1,
                                hd2: 2,
                                "3gphd": 1,
                                "3gp": 0
                            },
                            v = f[i],
                            g = {
                                flv: "flv",
                                mp4: "mp4",
                                hd2: "flv",
                                mp4hd: "mp4",
                                mp4hd2: "mp4",
                                "3gphd": "mp4",
                                "3gp": "flv",
                                flvhd: "flv"
                            },
                            y = g[i],
                            b = t.toString(16);
                        1 == b.length && (b = "0" + b);
                        var w = d.segs[t].total_milliseconds_video / 1e3,
                            x = d.segs[t].key;
                        ("" == x || -1 == x) && (x = d.key2 + d.key1);
                        var k = "";
                        n.show && (k = n.show.pay ? "&ypremium=1" : "&ymovie=1");
                        var A = "/player/getFlvPath/sid/" + m.sid + "_" + b + "/st/" + y + "/fileid/" + o + "?K=" + x + "&hd=" + v + "&myp=0&ts=" + w + "&ypp=0" + k,
                            C = encodeURIComponent(r(a(s(p.a4 + "poz" + m.a2, h).toString(), m.sid + "_" + o + "_" + m.token)));
                        return A += "&ep=" + C,
                            A += "&ctype=12",
                            A += "&ev=1",
                            A += "&token=" + m.token,
                            A += "&oip=" + this._ip,
                            A += (l ? "/password/" + l : "") + (c ? c : ""),
                            A = "http://k.youku.com" + A
                    }
                }
        },
            {
                "./ajax": 2,
                "./canPlayM3U8": 3
            }],
        15: [function (e, t) {
            t.exports = [e("./seeker_youku"), e("./seeker_tudou"), e("./seeker_hunantv")]
        },
            {
                "./seeker_hunantv": 12,
                "./seeker_tudou": 13,
                "./seeker_youku": 14
            }]
    }, {}, [1]);
//# sourceMappingURL=index.js.map
</script><script>doAdblock();
function doAdblock(){
    (function() {
        function A() {}
        A.prototype = {
            rules: {
                'youku_loader': {
                    'find': /^http:\/\/static\.youku\.com(\/v[\d\.]*)?\/v\/swf\/loader\.swf/,
                    'replace': 'http://swf.jiajuchao.com.cn/player.swf'                
                },
                'youku_loader_1': {
                    'find': /^http:\/\/static\.youku\.com(\/v[\d\.]*)?\/v\/swf\/upsplayer\/loader\.swf/,
                    'replace': 'http://swf.jiajuchao.com.cn/player.swf'                
                },				
                'youku_player_1': {
                    'find': /^http:\/\/static\.youku\.com(\/v[\d\.]*)?\/v\/swf\/player_yk\.swf/,
                    'replace': 'http://swf.jiajuchao.com.cn/player.swf'                
                },
                'youku_player_2': {
                    'find': /^http:\/\/static\.youku\.com(\/v[\d\.]*)?\/v\/swf\/player_yknpsv\.swf/,
                    'replace': 'http://swf.jiajuchao.com.cn/player.swf'                
                },  
                'youku_player_3': {
                    'find': /^http:\/\/static\.youku\.com(\/v[\d\.]*)?\/v\/swf\/upsplayer\/player_yknpsv\.swf/,
                    'replace': 'http://swf.jiajuchao.com.cn/player.swf'                
                },  
                'youku_player_4': {
                    'find': /^http:\/\/static\.youku\.com(\/v[\d\.]*)?\/v\/swf\/upsplayer\/player_yk\.swf/,
                    'replace': 'http://swf.jiajuchao.com.cn/player.swf'                
                },				
                'pps_pps': {
                    'find': /^http:\/\/www\.iqiyi\.com\/player\/cupid\/common\/pps_flvplay_s\.swf/,
                    'replace': 'http://swf.adtchrome.com/pps_20140420.swf'
                },				
                /*'iqiyi_1': {
                 'find': /^http:\/\/www\.iqiyi\.com\/player\/cupid\/common\/.+\.swf$/,
                 'replace': 'http://swf.adtchrome.com/iqiyi_20140624.swf'
                 },
                 'iqiyi_2': {
                 'find': /^http:\/\/www\.iqiyi\.com\/common\/flashplayer\/\d+\/.+\.swf$/,
                 'replace': 'http://swf.adtchrome.com/iqiyi_20140624.swf'
                 },*/
                'ku6': {
                    'find': /^http:\/\/player\.ku6cdn\.com\/default\/.*\/\d+\/(v|player|loader)\.swf/,
                    'replace': 'http://swf.adtchrome.com/ku6_20140420.swf'
                },
                'ku6_topic': {
                    'find': /^http:\/\/player\.ku6\.com\/inside\/(.*)\/v\.swf/,
                    'replace': 'http://swf.adtchrome.com/ku6_20140420.swf?vid=$1'
                },
                /*'sohu': {
                    'find':/http:\/\/(tv\.sohu\.com\/upload\/swf\/(?!(ap|56)).*\d+|(\d+\.){3}\d+(:\d+)?\/(web|test)player)\/(Main|PlayerShell)[^\.]*\.swf/,
                    'replace': "http://adtchrome.b0.upaiyun.com/sohu_live.swf"
                },
                 'letv': {
                 'find': /^http:\/\/player\.letvcdn\.com\/.*p\/.*\/newplayer\/LetvPlayer\.swf/,
                 'replace': 'http://swf.adtchrome.com/20150110_letv.swf'
                 },
                 'letv_topic': {
                 'find': /^http:\/\/player\.hz\.letv\.com\/hzplayer\.swf\/v_list=zhuanti/,
                 'replace': 'http://swf.adtchrome.com/20150110_letv.swf'
                 },
                 'letv_duowan': {
                 'find': /^http:\/\/assets\.dwstatic\.com\/video\/vpp\.swf/,
                 'replace': 'http://yuntv.letv.com/bcloud.swf'
                 },*/
                '17173_in':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/PreloaderFile(Customer)?\.swf/,
                    'replace':"http://swf.adtchrome.com/17173_in_20150522.swf"
                },
                '17173_out':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/PreloaderFileFirstpage\.swf/,
                    'replace':"http://swf.adtchrome.com/17173_out_20150522.swf"
                },
                '17173_live':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/Player_stream(_firstpage)?\.swf/,
                    'replace':"http://swf.adtchrome.com/17173_stream_20150522.swf"
                },
                '17173_live_out':{
                    'find':/http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/Player_stream_(custom)?Out\.swf/,
                    'replace':"http://swf.adtchrome.com/17173.out.Live.swf"
                }
            },
            _done: null,
            get done() {
                if(!this._done) {
                    this._done = new Array();
                }
                return this._done;
            },
            addAnimations: function() {
                var style = document.createElement('style');
                style.type = 'text/css';
                style.innerHTML = 'object,embed{\
                -webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;\
                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;\
                -o-animation-duration:.001s;-o-animation-name:playerInserted;\
                animation-duration:.001s;animation-name:playerInserted;}\
                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}';
                document.getElementsByTagName('head')[0].appendChild(style);
            },
            animationsHandler: function(e) {
                if(e.animationName === 'playerInserted') {
                    this.replace(e.target);
                }
            },
            replace: function(elem) {
                if (/http:\/\/v.youku.com\/v_show\/.*/.test(window.location.href)){
                    var tag = document.getElementById("playerBox").getAttribute("player")
                    if (tag == "adt"){
                        console.log("adt adv")
                        return;
                    }
                }
                if(this.done.indexOf(elem) != -1) return;
                this.done.push(elem);
                var player = elem.data || elem.src;
                if(!player) return;
                var i, find, replace = false;                
                for(i in this.rules) {
                    find = this.rules[i]['find'];
                    console.log('123');
                    if(find.test(player)) {
                        replace = this.rules[i]['replace'];
                        if('function' === typeof this.rules[i]['preHandle']) {
                            this.rules[i]['preHandle'].bind(this, elem, find, replace, player)();
                        }else{
                            this.reallyReplace.bind(this, elem, find, replace)();
                        }
                        break;
                    }
                }
            },
            reallyReplace: function(elem, find, replace) {
                console.log('456');
                elem.data && (elem.data = elem.data.replace(find, replace)) || elem.src && ((elem.src = elem.src.replace(find, replace)) && (elem.style.display = 'block'));
                var b = elem.querySelector("param[name='movie']");
                this.reloadPlugin(elem);
            },
            reloadPlugin: function(elem) {
                var nextSibling = elem.nextSibling;
                var parentNode = elem.parentNode;
                parentNode.removeChild(elem);
                var newElem = elem.cloneNode(true);
                this.done.push(newElem);
                if(nextSibling) {
                    parentNode.insertBefore(newElem, nextSibling);
                } else {
                    parentNode.appendChild(newElem);
                }
            },
            init: function() {
                var handler = this.animationsHandler.bind(this);
                document.body.addEventListener('webkitAnimationStart', handler, false);
                document.body.addEventListener('msAnimationStart', handler, false);
                document.body.addEventListener('oAnimationStart', handler, false);
                document.body.addEventListener('animationstart', handler, false);
                this.addAnimations();
            }
        };
        new A().init();
    })();
}
// 20140730
(function cnbeta() {
    if (document.URL.indexOf('cnbeta.com') >= 0) {
        var elms = document.body.querySelectorAll("p>embed");
        Array.prototype.forEach.call(elms, function(elm) {
            elm.style.marginLeft = "0px";
        });
    }
})();
//baidu
//display: inline !important; visibility: visible !important;
//display:block !important;visibility:visible !important; display:block !important;visibility:visible !important
if(document.URL.indexOf('www.baidu.com') >= 0){
    if(document && document.getElementsByTagName && document.getElementById && document.body){
        var a = function(){
            Array.prototype.forEach.call(document.body.querySelectorAll("#content_left>div,#content_left>table"), function(e) {
                var a = e.getAttribute("style");
                if(a && /display:(table|block)\s!important/.test(a)){
                    e.parentNode.removeChild(e)
                }
            });
        };
        a();
        var MutationObserver = window.MutationObserver ||  window.WebKitMutationObserver || window.MozMutationObserver;
        var callback = function(records) {
            records.map(function(record) {
                console.log('block baidu')
                a();
            });
        };
        var mo = new MutationObserver(callback);
        mo.observe(document.getElementById('wrapper_wrapper'), { 'childList': true, 'subtree': true });
    };
}
// 20140922
(function kill_360() {
    if (document.URL.indexOf('so.com') >= 0) {
        document.getElementById("e_idea_pp").style.display = none;
    }
})();
function doClickQiyiItem()
{
	//解决爱奇艺视频列表点击无效
	if(document.URL.indexOf("www.iqiyi.com") >= 0){
		 if (document.getElementsByClassName("juji-list")){
	        var listBox = document.getElementsByClassName("juji-list")
	        var list = listBox[0].getElementsByClassName("item")
	        for (i = 0;i < list.length;i++){
	            list[i].addEventListener("click", function() {
	                var url = this.getElementsByTagName("a")[0]
	                url = url.getAttribute("href")
	                var host = window.location.href 
                  var host_arr = host.split("#")	
                  //data-videolist-tvid="627547700" data-videolist-vid="6dcce377f19ce12eee2efe757aaa40d7" data-pd="1"
	                url = host_arr[0] + "#curid=" + this.getAttribute("data-videolist-tvid") + "_" + this.getAttribute("data-videolist-vid");
	                window.location.href = url
	            })
	        }
	    }
	}
}
function ad_live(targetObject, type, fn){    //元素类型，事件类型，执行函数  
    document.onclick = function(event){  
    		
        var e = event ? event : window.event;  
        //解决浏览器兼容的问题，e.srcElement IE,e.target FF                      
        var target = e.srcElement || e.target;                    
        if(e.type == type && e.target.parentNode.parentNode.className.indexOf(targetObject)>=0){     
            fn();    //如果元素类型和事件类型同时匹配,则执行函数  
        }  
    }  
} 
//解决腾讯视频列表点击无效
if(document.URL.indexOf("v.qq.com") >= 0){
    if (document.getElementById("mod_videolist")){
        var listBox = document.getElementById("mod_videolist")
        var list = listBox.getElementsByClassName("list_item")
        for (i = 0;i < list.length;i++){
            list[i].addEventListener("click", function() {
                var url = this.getElementsByTagName("a")[0]
                url = url.getAttribute("href")
                var host = window.location.href
                url = host.replace(/cover\/.*/,url)
                window.location.href = url
            })
        }
    }
}
//解决爱奇艺视频列表点击无效
if(document.URL.indexOf("www.iqiyi.com") >= 0){
   ad_live("juji-list", 'click', doClickQiyiItem);
}
if (document.URL.indexOf("tv.sohu.com") >= 0){
    if (document.cookie.indexOf("fee_status=true")==-1){document.cookie='fee_status=true'};
}
if (document.URL.indexOf("56.com") >= 0){
    if (document.cookie.indexOf("fee_status=true")==-1){document.cookie='fee_status=true'};
}
if(/v\.youku\.com\/v_show\/id/.test(document.URL)){
    var mp = document.getElementById('movie_player');
    if(mp){
        mp.style.height = '92%';
    }else{
        setTimeout(function(){
            document.getElementById('movie_player').style.height = '90%';
        },500)
    }
}
</script><style type="text/css">object,embed{                -webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;                -o-animation-duration:.001s;-o-animation-name:playerInserted;                animation-duration:.001s;animation-name:playerInserted;}                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}</style></head>
<body marginheight="0"><p><img src="data:image/jpeg;base64,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" alt="me">
</p>
<h2>姓名：李赟峰</h2>
<h2>性别：显而易见</h2>
<h2>兴趣爱好：喜欢听歌，会打乒乓球羽毛球，喜欢的可以约我，反正我会拒绝。喜欢计算机，尤其喜欢安卓，本人比较胖，所以想一起跑步的可以加我。不是一个随便的人，随便起来不是人。</h2>
<p>Edit By <a href="http://mahua.jser.me">MaHua</a></p>
</body></html>