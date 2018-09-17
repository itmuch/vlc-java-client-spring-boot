package com.itmuch.vlc.feignclients.configuration.enums;

/**
 * @author 周立
 */
public enum ComplexVlcCommand implements NamedEnum {
    /**
     * 播放指定素材
     * eg. http://localhost:8080/requests/status.json?command=in_play&input=file%3A%2F%2F%2FUsers%2Freno%2FDownloads%2FIMG_4196.MOV
     */
    IN_PLAY("in_play"),

    /**
     * 队列指定素材
     * eg. http://localhost:8080/requests/status.json?command=in_enqueue&input=file%3A%2F%2F%2FUsers%2Freno%2FDownloads%2FIMG_4196.MOV
     */
    QUEUE("in_enqueue"),

    /**
     * 设置音量
     * - 256表示100%
     * - 512表示200% 以此类推
     * eg. http://localhost:8080/requests/status.json?command=volume&val=256
     */
    VOLUME("volume"),

    /**
     * 播放指定id的素材
     * eg. http://localhost:8080/requests/status.json?command=pl_play&id=13
     */
    PLAY("pl_play");

    private String name;

    ComplexVlcCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
