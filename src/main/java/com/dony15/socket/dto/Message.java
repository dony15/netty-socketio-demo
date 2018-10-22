package com.dony15.socket.dto;

import java.io.Serializable;

/**
 * @author DonY15
 * @description
 * @create 2018\10\20 0020
 */
public class Message implements Serializable {
    private Integer fromId;
    private Integer toId;
    private String userName;
    private Integer messageId;
    private String message;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "fromId=" + fromId +
                ", toId=" + toId +
                ", userName='" + userName + '\'' +
                ", messageId=" + messageId +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
