package com.codegym.service;

import com.codegym.model.Mailbox;

import java.util.List;

public interface IMailboxService {
    List<Mailbox> finAll();
    void save(Mailbox mailbox);
    Mailbox findIndexById(int id);
}
