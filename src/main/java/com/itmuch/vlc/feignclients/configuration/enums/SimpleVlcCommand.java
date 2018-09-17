package com.itmuch.vlc.feignclients.configuration.enums;

/**
 * @author reno
 */

public enum SimpleVlcCommand implements NamedEnum {
    // 暂停
    PAUSE("pl_pause"),
    // 停止
    STOP("pl_stop"),
    // 继续播放
    RESUME("pl_play"),
    // 截屏
    SNAPSHOT("snapshot"),
    // 全屏/退出全屏
    FULL_SCREEN("fullscreen"),
    // 随机播放
    RANDOM("pl_random"),
    // 上一个
    PREVIOUS("pl_previous"),
    // 下一个
    NEXT("pl_next"),
    // 打开/关闭重复
    REPEAT("pl_repeat"),
    LOOP("pl_loop"),
    // 清空播放列表
    EMPTY("pl_empty"),;

    SimpleVlcCommand(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return this.name;
    }
}