package com.itmuch.vlc.feignclients;

import com.itmuch.vlc.entity.Request;
import com.itmuch.vlc.entity.StatusResponse;
import com.itmuch.vlc.feignclients.configuration.VlcConfiguration;
import com.itmuch.vlc.feignclients.configuration.enums.ComplexVlcCommand;
import com.itmuch.vlc.feignclients.configuration.enums.SimpleVlcCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 参考：https://forum.videolan.org/viewtopic.php?f=14&t=85347
 *
 * @author 周立
 */
@FeignClient(name = "vlc", url = "http://localhost:8080/requests", configuration = VlcConfiguration.class)
public interface VlcFeignClient {
    /**
     * 查看播放列表
     *
     * @return 播放列表
     */
    @GetMapping("/playlist.json")
    Request playlist();

    /**
     * 适用于：
     * 所有SimpleVlcCommand中的命令
     *
     * @param command 各种命令
     * @return response
     */
    @GetMapping("/status.json")
    StatusResponse status(@RequestParam("command") SimpleVlcCommand command);

    /**
     * 适用于：
     * - 播放指定素材
     * - 队列指定素材
     *
     * @param command in_play|in_enqueue
     * @param input   文件地址
     * @return response
     */
    @GetMapping("/status.json")
    StatusResponse status(
            @RequestParam("command") ComplexVlcCommand command,
            @RequestParam(value = "input") String input
    );

    /**
     * 适用于：
     * 播放指定id的素材
     *
     * @param command pl_play
     * @param id      素材id，在playlist中可以显示出来
     * @return response
     */
    @GetMapping("/status.json")
    StatusResponse play(
            @RequestParam("command") ComplexVlcCommand command,
            @RequestParam(value = "id") String id
    );

    /**
     * 适用于：设置音量
     * - 256表示100%
     * - 512表示200% 以此类推
     *
     * @param command volume
     * @param val     值
     * @return response
     */
    @GetMapping("/status.json")
    StatusResponse volume(
            @RequestParam("command") ComplexVlcCommand command,
            @RequestParam("val") Integer val
    );
}
