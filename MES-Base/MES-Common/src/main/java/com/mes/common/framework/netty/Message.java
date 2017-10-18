package com.mes.common.framework.netty;

import javax.validation.constraints.NotNull;

/**
 * 业务消息实体
 * Created by xiuyou.xu on 2017/6/23.
 */
public class Message {
    /**
     * 消息业务类型
     */
    public static enum BizType {
        /**
         * 标签打印
         */
        LABEL_PRINT
    }

    /**
     * 消息传输类型
     */
    public static enum Type {
        /**
         * 心跳探测，没有实际报文
         */
        HEARTBEAT,
        /**
         * agent向mes发送普通文本数据
         */
        AGENT2MES_DATA,
        /**
         * mes向agent发送普通文本数据
         */
        MES2AGENT_DATA,
        /**
         * agent向mes发送文件
         */
        AGENT2MES_FILE,
        /**
         * mes向agent发送文件
         */
        MES2AGENT_FILE
    }

    /**
     * 消息id，心跳消息每次发送相同的messageId，普通文本消息每次messageId都不同，文件消息在发送同一个文件数据的时候messageId相同
     */
    @NotNull(message = "消息Id不可以为null")
    private String messageId;
    /**
     * 发送者ip，agent向mes发送消息时，需要设置该字段，mes向agent发送消息时，可以为空
     */
    private String senderIp;
    /**
     * 消息类型
     */
    @NotNull(message = "消息类型不可以为null")
    private Type type;
    /**
     * 普通类型报文体
     */
    private String body;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件数据，不定长字节数组
     */
    private byte[] fileData;
    /**
     * 是否为最后一个文件数据包
     */
    private boolean last;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSenderIp() {
        return senderIp;
    }

    public void setSenderIp(String senderIp) {
        this.senderIp = senderIp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * 普通数据
     */
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public String toString() {
        if (this.getType() == Type.HEARTBEAT) {
            return this.getType().name();
        }
        if (this.getType() == Type.AGENT2MES_DATA || this.getType() == Type.MES2AGENT_DATA) {
            return this.getType() + " " + this.getBody();
        }
        if (this.getType() == Type.AGENT2MES_FILE || this.getType() == Type.MES2AGENT_FILE) {
            return this.getType() + " " + this.getFileName() + ", size: " + this.getFileData().length + ", last part: " + this.isLast();
        }
        return "";
    }
}
