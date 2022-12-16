package com.codegym.repository;

import com.codegym.model.Mailbox;

import java.util.List;

public interface IMailboxRepository {
    List<Mailbox> finAll();
    void save(Mailbox mailbox);
    Mailbox findIndexById(int id);

}
