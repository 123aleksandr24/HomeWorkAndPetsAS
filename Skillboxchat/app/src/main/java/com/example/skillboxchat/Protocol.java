package com.example.skillboxchat;

import com.google.gson.Gson;

public class Protocol {
    //описывать взаимодействие с сервером
    // USER_STATUS - соощать в онлайне челвек или в офлайне
    // MESSAGE - сообщение входящее / исходящее сообщение
    //USER_NAME - сообщаем серверу наше имя

    public  final static int USER_STATUS = 1;
    public  final static int MESSAGE = 2;
    public  final static int USER_NAME = 3;

    //USER_NAME:    3{ name: "Мишаня" }
    //USER_STATUS:  1{ connected: true , user : { name: "Вася",id: 1828282 } }
    //MESSAGE       2{ encodedTaxt: "Прифки" , sender: 1828282 }

    static class UserStatus {
        private boolean connected;
        private User user;

        public boolean isConnected() {
            return connected;
        }

        public void setConnected(boolean connected) {
            this.connected = connected;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    static class User {
        private String name;
        private long id;

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    static class UserName {
        public UserName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

    static class Message {
        public final static int GROUP_CHAT = 1;
        private long sender; //id отправителя
        private String encodedText;
        private long receiver = GROUP_CHAT;

        public Message(String encodedText) {
            this.encodedText = encodedText;
        }

        public long getSender() {
            return sender;
        }

        public void setSender(long sender) {
            this.sender = sender;
        }

        public String getEncodedText() {
            return encodedText;
        }

        public void setEncodedText(String encodedText) {
            this.encodedText = encodedText;
        }

        public long getReceiver() {
            return receiver;
        }

        public void setReceiver(long receiver) {
            this.receiver = receiver;
        }
    }

    //Будем вызывать при отправке своего имени на сервер
    public static String packName (UserName name) {
        Gson g = new Gson(); // поможет запаковать в json
        return USER_NAME + g.toJson(name); // 3{"Мишаня"}
    }

    //Как получать с сервера прочую информацию:
    // Статусы пользователей , имена польователей и собственно сообщения

    public static int getType(String json) {
        if (json == null || json.length() == 0) {
            return -1;
        }
        return Integer.parseInt(json.substring(0, 1));
    }

    public static String packMessage (Message mess) {
        Gson g = new Gson();
        return MESSAGE + g.toJson(mess);
    }

    public static Message unpackMessage (String json) {
        Gson g = new Gson();
        return g.fromJson(json.substring(1),Message.class);
    }

    public static UserStatus unpackStatus (String json) {
        Gson g = new Gson();
        return g.fromJson(json.substring(1),UserStatus.class);
    }


}
