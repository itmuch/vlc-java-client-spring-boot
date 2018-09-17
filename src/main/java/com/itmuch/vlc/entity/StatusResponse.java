package com.itmuch.vlc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class StatusResponse {

    /**
     * fullscreen : 0
     * audiodelay : 0
     * apiversion : 3
     * currentplid : -1
     * time : 0
     * volume : 256
     * length : 0
     * random : false
     * audiofilters : {"filter_0":""}
     * rate : 1
     * videoeffects : {"hue":0,"saturation":1,"contrast":1,"brightness":1,"gamma":1}
     * state : stopped
     * loop : false
     * version : 3.0.4 Vetinari
     * position : 0
     * repeat : true
     * subtitledelay : 0
     * equalizer : []
     */

    private boolean fullscreen;
    private int audiodelay;
    private int apiversion;
    private int currentplid;
    private int time;
    private int volume;
    private int length;
    private boolean random;
    private Audiofilters audiofilters;
    private int rate;
    private Videoeffects videoeffects;
    private String state;
    private boolean loop;
    private String version;
    private int position;
    private boolean repeat;
    private int subtitledelay;
    private List<?> equalizer;

    @NoArgsConstructor
    @Data
    public static class Audiofilters {
        /**
         * filter_0 :
         */

        private String filter_0;
    }

    @NoArgsConstructor
    @Data
    public static class Videoeffects {
        /**
         * hue : 0
         * saturation : 1
         * contrast : 1
         * brightness : 1
         * gamma : 1
         */

        private int hue;
        private int saturation;
        private int contrast;
        private int brightness;
        private int gamma;
    }
}
