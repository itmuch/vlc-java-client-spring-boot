package com.itmuch.vlc;

import com.itmuch.vlc.entity.Request;
import com.itmuch.vlc.entity.StatusResponse;
import com.itmuch.vlc.feignclients.VlcFeignClient;
import com.itmuch.vlc.feignclients.configuration.enums.ComplexVlcCommand;
import com.itmuch.vlc.feignclients.configuration.enums.SimpleVlcCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周立
 */
@RestController
public class VlcTestController {
    @Autowired
    private VlcFeignClient vlcFeignClient;

    /**
     * 测试：http://localhost:8081/playlist
     *
     * @return 播放列表
     */
    @GetMapping("/playlist")
    public Request playlist() {
        return this.vlcFeignClient.playlist();
    }

    /**
     * 测试：
     * http://localhost:8081/status?command=PAUSE
     * http://localhost:8081/status?command=RESUME
     * http://localhost:8081/status?command=SNAPSHOT
     *
     * @param command 命令
     * @return 状态返回
     */
    @GetMapping("/status")
    public StatusResponse status(@RequestParam String command) {
        return this.vlcFeignClient.status(
                SimpleVlcCommand.valueOf(command.toUpperCase())
        );
    }

    /**
     * 测试：
     * http://localhost:8081/play-or-enqueue?command=in_play&input=file%3A%2F%2F%2FUsers%2Freno%2FDownloads%2FIMG_4196.MOV
     *
     * @param command 命令
     * @param input   文件名
     * @return 状态返回
     */
    @GetMapping("/play-or-enqueue")
    public StatusResponse inPlay(@RequestParam String command,
                                 @RequestParam(value = "input") String input) {
        return this.vlcFeignClient.status(
                ComplexVlcCommand.valueOf(command.toUpperCase()),
                input
        );
    }

    /**
     * 设置音量
     *
     * @param val 音量值
     * @return 状态返回
     */
    @GetMapping("/volume")
    public StatusResponse val(@RequestParam(value = "val") Integer val) {
        return this.vlcFeignClient.volume(
                ComplexVlcCommand.valueOf("volume"),
                val
        );
    }
}
