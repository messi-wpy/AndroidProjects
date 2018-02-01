package com.bignerdranch.androidboy.douban;

import java.util.List;

/**
 * Created by androidboy on 18-2-1.
 * 用GsonFormat解析的对象
 */

public class Movie {

    /**
     * count : 20
     * start : 0
     * total : 20
     * subjects : [{"rating":{"max":10,"average":8.8,"stars":"45","min":0},"genres":["动作","科幻"],"title":"黑客帝国","casts":[{"alt":"https://movie.douban.com/celebrity/1008070/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg"},"name":"基努·里维斯","id":"1008070"},{"alt":"https://movie.douban.com/celebrity/1022581/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg"},"name":"凯瑞-安·莫斯","id":"1022581"},{"alt":"https://movie.douban.com/celebrity/1022596/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg"},"name":"劳伦斯·菲什伯恩","id":"1022596"}],"collect_count":389529,"original_title":"The Matrix","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1013899/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg"},"name":"莉莉·沃卓斯基","id":"1013899"},{"alt":"https://movie.douban.com/celebrity/1161012/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg"},"name":"拉娜·沃卓斯基","id":"1161012"}],"year":"1999","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg"},"alt":"https://movie.douban.com/subject/1291843/","id":"1291843"},{"rating":{"max":10,"average":8.5,"stars":"45","min":0},"genres":["动作","科幻"],"title":"黑客帝国3：矩阵革命","casts":[{"alt":"https://movie.douban.com/celebrity/1008070/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg"},"name":"基努·里维斯","id":"1008070"},{"alt":"https://movie.douban.com/celebrity/1022596/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg"},"name":"劳伦斯·菲什伯恩","id":"1022596"},{"alt":"https://movie.douban.com/celebrity/1022581/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg"},"name":"凯瑞-安·莫斯","id":"1022581"}],"collect_count":208405,"original_title":"The Matrix Revolutions","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1013899/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg"},"name":"莉莉·沃卓斯基","id":"1013899"},{"alt":"https://movie.douban.com/celebrity/1161012/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg"},"name":"拉娜·沃卓斯基","id":"1161012"}],"year":"2003","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p443461818.jpg","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p443461818.jpg","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p443461818.jpg"},"alt":"https://movie.douban.com/subject/1302467/","id":"1302467"},{"rating":{"max":10,"average":8.4,"stars":"45","min":0},"genres":["动作","科幻"],"title":"黑客帝国2：重装上阵","casts":[{"alt":"https://movie.douban.com/celebrity/1008070/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg"},"name":"基努·里维斯","id":"1008070"},{"alt":"https://movie.douban.com/celebrity/1022581/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg"},"name":"凯瑞-安·莫斯","id":"1022581"},{"alt":"https://movie.douban.com/celebrity/1022596/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg"},"name":"劳伦斯·菲什伯恩","id":"1022596"}],"collect_count":190236,"original_title":"The Matrix Reloaded","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1013899/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg"},"name":"莉莉·沃卓斯基","id":"1013899"},{"alt":"https://movie.douban.com/celebrity/1161012/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg"},"name":"拉娜·沃卓斯基","id":"1161012"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p459054512.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p459054512.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p459054512.jpg"},"alt":"https://movie.douban.com/subject/1304141/","id":"1304141"},{"rating":{"max":10,"average":8.9,"stars":"45","min":0},"genres":["纪录片"],"title":"黑客帝国：重访矩阵","casts":[],"collect_count":377,"original_title":"The Matrix Revisited","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"Josh Oreck","id":null}],"year":"2001","images":{"small":"https://img3.doubanio.com/spic/s5022815.jpg","large":"https://img3.doubanio.com/lpic/s5022815.jpg","medium":"https://img3.doubanio.com/mpic/s5022815.jpg"},"alt":"https://movie.douban.com/subject/5132228/","id":"5132228"},{"rating":{"max":10,"average":8.7,"stars":"45","min":0},"genres":["动作","剧情","动画"],"title":"黑客帝国动画版","casts":[{"alt":"https://movie.douban.com/celebrity/1035615/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10168.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10168.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10168.jpg"},"name":"大塚明夫","id":"1035615"},{"alt":"https://movie.douban.com/celebrity/1000638/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371393842.29.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371393842.29.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371393842.29.jpg"},"name":"克莱顿·华生","id":"1000638"},{"alt":"https://movie.douban.com/celebrity/1143044/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21887.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21887.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21887.jpg"},"name":"帕梅拉·阿德龙","id":"1143044"}],"collect_count":39112,"original_title":"The Animatrix","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1349165/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"钟彼得","id":"1349165"},{"alt":null,"avatars":null,"name":"Andy Jones","id":null},{"alt":"https://movie.douban.com/celebrity/1041573/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1650.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1650.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1650.jpg"},"name":"川尻善昭","id":"1041573"},{"alt":"https://movie.douban.com/celebrity/1274470/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4534.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4534.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4534.jpg"},"name":"小池健","id":"1274470"},{"alt":"https://movie.douban.com/celebrity/1314381/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23745.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23745.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23745.jpg"},"name":"前田真宏","id":"1314381"},{"alt":"https://movie.douban.com/celebrity/1016896/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4579.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4579.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4579.jpg"},"name":"森本晃司","id":"1016896"},{"alt":"https://movie.douban.com/celebrity/1274349/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg"},"name":"渡边信一郎","id":"1274349"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1185327352.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1185327352.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1185327352.jpg"},"alt":"https://movie.douban.com/subject/1292347/","id":"1292347"},{"rating":{"max":10,"average":8.9,"stars":"45","min":0},"genres":["动画","科幻","短片"],"title":"少年故事","casts":[{"alt":null,"avatars":null,"name":"Keanu Reeves","id":null},{"alt":null,"avatars":null,"name":"Carrie-Anne Moss","id":null}],"collect_count":5115,"original_title":"Kid's Story","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274349/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg"},"name":"渡边信一郎","id":"1274349"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189186402.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189186402.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189186402.jpg"},"alt":"https://movie.douban.com/subject/1900321/","id":"1900321"},{"rating":{"max":10,"average":8.8,"stars":"45","min":0},"genres":["剧情","奇幻","动画"],"title":"侦探的故事","casts":[{"alt":null,"avatars":null,"name":"James Arnold Taylor","id":null},{"alt":null,"avatars":null,"name":"Carrie-Anne Moss","id":null},{"alt":null,"avatars":null,"name":"Terrence 'T.C.' Carson","id":null}],"collect_count":4711,"original_title":"A Detective Story","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274349/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3569.jpg"},"name":"渡边信一郎","id":"1274349"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185991.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185991.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185991.jpg"},"alt":"https://movie.douban.com/subject/2049560/","id":"2049560"},{"rating":{"max":10,"average":9.1,"stars":"45","min":0},"genres":["剧情","奇幻","科幻"],"title":"机器的复兴：第1部","casts":[{"alt":null,"avatars":null,"name":"Dane A. Davis","id":null},{"alt":null,"avatars":null,"name":"Debi Derryberry","id":null},{"alt":null,"avatars":null,"name":"Julia Fletcher","id":null}],"collect_count":4824,"original_title":"The Second Renaissance Part I","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"前田真宏","id":null}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189949483.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189949483.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189949483.jpg"},"alt":"https://movie.douban.com/subject/2049553/","id":"2049553"},{"rating":{"max":10,"average":9,"stars":"45","min":0},"genres":["动画","科幻","短片"],"title":"世界纪录","casts":[{"alt":null,"avatars":null,"name":"Victor Williams","id":null},{"alt":null,"avatars":null,"name":"John Wesley","id":null},{"alt":null,"avatars":null,"name":"Alex Fernandez","id":null}],"collect_count":4963,"original_title":"World Record","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"小池健","id":null}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185870.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185870.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185870.jpg"},"alt":"https://movie.douban.com/subject/2049559/","id":"2049559"},{"rating":{"max":10,"average":3.6,"stars":"20","min":0},"genres":["剧情","犯罪","悬疑"],"title":"黑客悲情","casts":[{"alt":"https://movie.douban.com/celebrity/1315848/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1465797322.17.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1465797322.17.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1465797322.17.jpg"},"name":"何杜娟","id":"1315848"},{"alt":"https://movie.douban.com/celebrity/1274776/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6307.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6307.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6307.jpg"},"name":"高鑫","id":"1274776"},{"alt":"https://movie.douban.com/celebrity/1315849/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"权贞恩","id":"1315849"}],"collect_count":152,"original_title":"黑客悲情","subtype":"Movie","directors":[],"year":"2011","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1229375904.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1229375904.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1229375904.jpg"},"alt":"https://movie.douban.com/subject/5915784/","id":"5915784"},{"rating":{"max":10,"average":8.8,"stars":"45","min":0},"genres":["动画","科幻","短片"],"title":"超越极限","casts":[{"alt":"https://movie.douban.com/celebrity/1076221/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52977.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52977.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52977.jpg"},"name":"海蒂·布雷斯","id":"1076221"},{"alt":"https://movie.douban.com/celebrity/1120584/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20306.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20306.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20306.jpg"},"name":"崔丝·麦妮利","id":"1120584"},{"alt":null,"avatars":null,"name":"Kath Soucie","id":null}],"collect_count":4590,"original_title":"Beyond","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"森本晃司","id":null}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185514.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185514.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189185514.jpg"},"alt":"https://movie.douban.com/subject/1961961/","id":"1961961"},{"rating":{"max":10,"average":9.1,"stars":"45","min":0},"genres":["动画","科幻","短片"],"title":"机器的复兴：第2部","casts":[{"alt":null,"avatars":null,"name":"Dane A. Davis","id":null},{"alt":null,"avatars":null,"name":"Debi Derryberry","id":null},{"alt":null,"avatars":null,"name":"Julia Fletcher","id":null}],"collect_count":4599,"original_title":"The Second Renaissance Part II","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"前田真宏","id":null}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189949652.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189949652.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189949652.jpg"},"alt":"https://movie.douban.com/subject/2049556/","id":"2049556"},{"rating":{"max":10,"average":8.4,"stars":"45","min":0},"genres":["动作","动画","科幻"],"title":"终极战役","casts":[{"alt":"https://movie.douban.com/celebrity/1142715/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11205.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11205.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11205.jpg"},"name":"凯文·迈克尔·理查德森","id":"1142715"},{"alt":null,"avatars":null,"name":"Pamela Adlon","id":null},{"alt":"https://movie.douban.com/celebrity/1049627/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6159.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6159.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6159.jpg"},"name":"约翰·迪·玛吉欧","id":"1049627"}],"collect_count":3866,"original_title":"Final Flight of the Osiris","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"Andy Jones 安迪·琼斯","id":null}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2255040645.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2255040645.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2255040645.jpg"},"alt":"https://movie.douban.com/subject/2049545/","id":"2049545"},{"rating":{"max":10,"average":8.7,"stars":"45","min":0},"genres":["动作","科幻","短片"],"title":"虚拟程序","casts":[{"alt":"https://movie.douban.com/celebrity/1076221/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52977.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52977.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52977.jpg"},"name":"海蒂·布雷斯","id":"1076221"},{"alt":"https://movie.douban.com/celebrity/1007036/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20469.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20469.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20469.jpg"},"name":"菲尔·拉马","id":"1007036"},{"alt":"https://movie.douban.com/celebrity/1049627/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6159.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6159.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6159.jpg"},"name":"约翰·迪·玛吉欧","id":"1049627"}],"collect_count":3913,"original_title":"Program","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1041573/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1650.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1650.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1650.jpg"},"name":"川尻善昭","id":"1041573"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189186242.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189186242.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189186242.jpg"},"alt":"https://movie.douban.com/subject/2049547/","id":"2049547"},{"rating":{"max":10,"average":8.2,"stars":"40","min":0},"genres":["动画","科幻","短片"],"title":"矩阵化","casts":[{"alt":null,"avatars":null,"name":"Melinda Clarke","id":null},{"alt":null,"avatars":null,"name":"Dwight Schultz","id":null},{"alt":null,"avatars":null,"name":"Rodney Saulsberry","id":null}],"collect_count":3380,"original_title":"Matriculated","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1349165/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"钟彼得","id":"1349165"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189167793.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189167793.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2189167793.jpg"},"alt":"https://movie.douban.com/subject/2049544/","id":"2049544"},{"rating":{"max":10,"average":8.6,"stars":"45","min":0},"genres":["科幻","纪录片"],"title":"黑客帝国的根源","casts":[{"alt":null,"avatars":null,"name":"肯 威尔伯","id":null}],"collect_count":364,"original_title":"The roots of the Matrix","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1013899/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg"},"name":"莉莉·沃卓斯基","id":"1013899"}],"year":"2005","images":{"small":"https://img3.doubanio.com/spic/s24972263.jpg","large":"https://img3.doubanio.com/lpic/s24972263.jpg","medium":"https://img3.doubanio.com/mpic/s24972263.jpg"},"alt":"https://movie.douban.com/subject/20374408/","id":"20374408"},{"rating":{"max":10,"average":6.8,"stars":"35","min":0},"genres":["动画","短片"],"title":"动物版黑客帝国","casts":[{"alt":"https://movie.douban.com/celebrity/1314217/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"路易斯·福克斯","id":"1314217"}],"collect_count":169,"original_title":"The Meatrix","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1314217/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"路易斯·福克斯","id":"1314217"}],"year":"2003","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2342081534.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2342081534.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2342081534.jpg"},"alt":"https://movie.douban.com/subject/1906149/","id":"1906149"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["科幻","纪录片","短片"],"title":"黑客帝国的制作","casts":[{"alt":"https://movie.douban.com/celebrity/1022596/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg"},"name":"劳伦斯·菲什伯恩","id":"1022596"},{"alt":"https://movie.douban.com/celebrity/1049557/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360151030.33.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360151030.33.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360151030.33.jpg"},"name":"乔·潘托里亚诺","id":"1049557"},{"alt":"https://movie.douban.com/celebrity/1005225/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33694.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33694.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33694.jpg"},"name":"巴里·M·奥斯本","id":"1005225"}],"collect_count":2,"original_title":"Making The Matrix","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1293612/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"Josh Oreck","id":"1293612"}],"year":"1999","images":{"small":"https://img1.doubanio.com/f/movie/b6dc761f5e4cf04032faa969826986efbecd54bb/pics/movie/movie_default_small.png","large":"https://img3.doubanio.com/f/movie/30c6263b6db26d055cbbe73fe653e29014142ea3/pics/movie/movie_default_large.png","medium":"https://img1.doubanio.com/f/movie/5081e011b4b06f1a8c3735122b38e781bd852ab6/pics/movie/movie_default_medium.png"},"alt":"https://movie.douban.com/subject/27083413/","id":"27083413"},{"rating":{"max":10,"average":6.3,"stars":"35","min":0},"genres":["剧情","动作","犯罪"],"title":"不义之财2","casts":[{"alt":"https://movie.douban.com/celebrity/1036743/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25522.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25522.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p25522.jpg"},"name":"乔尔·金纳曼","id":"1036743"},{"alt":"https://movie.douban.com/celebrity/1045340/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1364187303.3.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1364187303.3.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1364187303.3.jpg"},"name":"法瑞斯·法瑞斯","id":"1045340"},{"alt":"https://movie.douban.com/celebrity/1135870/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p47214.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p47214.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p47214.jpg"},"name":"马蒂亚斯·瓦雷拉","id":"1135870"}],"collect_count":300,"original_title":"Snabba Cash II","subtype":"Movie","directors":[{"alt":"https://movie.douban.com/celebrity/1317990/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42004.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42004.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42004.jpg"},"name":"巴巴克·纳加非","id":"1317990"}],"year":"2012","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1812931013.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1812931013.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1812931013.jpg"},"alt":"https://movie.douban.com/subject/5326133/","id":"5326133"},{"rating":{"max":10,"average":8.9,"stars":"45","min":0},"genres":["纪录片"],"title":"骇客帝国与哲学","casts":[],"collect_count":58,"original_title":"Return To Source: Philosophy & The Matrix","subtype":"Movie","directors":[{"alt":null,"avatars":null,"name":"Josh Oreck","id":null}],"year":"2004","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2045615606.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2045615606.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2045615606.jpg"},"alt":"https://movie.douban.com/subject/3200994/","id":"3200994"}]
     * title : 搜索 "黑客帝国" 的结果
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":8.8,"stars":"45","min":0}
         * genres : ["动作","科幻"]
         * title : 黑客帝国
         * casts : [{"alt":"https://movie.douban.com/celebrity/1008070/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg"},"name":"基努·里维斯","id":"1008070"},{"alt":"https://movie.douban.com/celebrity/1022581/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2799.jpg"},"name":"凯瑞-安·莫斯","id":"1022581"},{"alt":"https://movie.douban.com/celebrity/1022596/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490098154.3.jpg"},"name":"劳伦斯·菲什伯恩","id":"1022596"}]
         * collect_count : 389529
         * original_title : The Matrix
         * subtype : Movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1013899/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg"},"name":"莉莉·沃卓斯基","id":"1013899"},{"alt":"https://movie.douban.com/celebrity/1161012/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375188599.19.jpg"},"name":"拉娜·沃卓斯基","id":"1161012"}]
         * year : 1999
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg"}
         * alt : https://movie.douban.com/subject/1291843/
         * id : 1291843
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 8.8
             * stars : 45
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910908765.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1008070/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg"}
             * name : 基努·里维斯
             * id : 1008070
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58124.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1013899/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg"}
             * name : 莉莉·沃卓斯基
             * id : 1013899
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1457491343.23.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
