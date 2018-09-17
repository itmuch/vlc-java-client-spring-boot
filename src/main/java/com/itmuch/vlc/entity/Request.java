package com.itmuch.vlc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Request {
    /**
     * 读写策略
     * - eg. rw
     */
    private String ro;
    /**
     * 类型
     * - eg. node/leaf
     */
    private String type;
    /**
     * 名称
     */
    private String name;
    /**
     * id
     */
    private String id;
    private List<Request> children;
}
