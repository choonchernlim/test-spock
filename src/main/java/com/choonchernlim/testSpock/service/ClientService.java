package com.choonchernlim.testSpock.service;

public class ClientService {

    private MessageService messageService;

    public ClientService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String greet(String name) {
        return messageService.getMessage() + "! What's up, " + name + "?";
    }
}
