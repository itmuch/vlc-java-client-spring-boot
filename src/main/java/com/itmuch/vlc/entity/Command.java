package com.itmuch.vlc.entity;

public class Command {
    /**
     * 播放指定id的素材
     * eg. http://localhost:8080/requests/status.json?command=pl_play&id=13
     */
    public static final String PLAY = "pl_play";

    /**
     * 暂停
     */
    public static final String PAUSE = "pl_pause";

    /**
     * 停止
     */
    public static final String STOP = "pl_stop";

    /**
     * 继续播放
     */
    public static final String RESUME = "pl_play";

    /**
     * 截屏
     */
    public static final String SNAPSHOT = "snapshot";

    /**
     * 全屏/退出全屏
     */
    public static final String FULL_SCREEN = "fullscreen";

    /**
     * 随机播放
     */
    public static final String RANDOM = "pl_random";

    /**
     * 上一个
     */
    public static final String PREVIOUS = "pl_previous";

    /**
     * 下一个
     */
    public static final String NEXT = "pl_next";


    public static final String REPEAT = "pl_repeat";

    /**
     * 打开/关闭重复
     */
    public static final String LOOP = "pl_repeat";

    /**
     * 清空播放列表
     */
    public static final String EMPTY = "pl_empty";

    /**
     * 播放指定素材
     * eg. http://localhost:8080/requests/status.json?command=in_play&input=file%3A%2F%2F%2FUsers%2Freno%2FDownloads%2FIMG_4196.MOV
     */
    public static final String IN_PLAY = "in_play";

    /**
     * 队列指定素材
     * eg. http://localhost:8080/requests/status.json?command=in_enqueue&input=file%3A%2F%2F%2FUsers%2Freno%2FDownloads%2FIMG_4196.MOV
     */
    public static final String QUEUE = "in_enqueue";

    /**
     * 设置音量
     * - 256表示100%
     * - 512表示200% 以此类推
     * eg. http://localhost:8080/requests/status.json?command=volume&val=256
     */
    public static final String VOLUME = "volume";
}
