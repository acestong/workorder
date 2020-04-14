package com.fea.project.enums.interflow;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public enum MeetingTypeEnum {

    OFFLINE_MEETING(1,"线下会议"),
    TELECONFERENCING(2,"电话会议"),
    VIDEOCONFERENCING(3,"视频会议");

    private Integer code;
    private String text;

    MeetingTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Map<Integer,String> getMap(){
        return Stream.of(MeetingTypeEnum.values()).collect(Collectors.toMap(MeetingTypeEnum::getCode,
                MeetingTypeEnum::getText));
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
