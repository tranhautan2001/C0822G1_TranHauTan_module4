package com.codegym.service.impl;

import com.codegym.model.Mailbox;
import com.codegym.repository.IMailboxRepository;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository mailboxRepository;

    @Override
    public List<Mailbox> finAll() { return mailboxRepository.finAll();
    }

    @Override
    public void save(Mailbox mailbox) { mailboxRepository.save(mailbox);
    }

    @Override
    public Mailbox findIndexById(int id) {
        Mailbox mailbox = mailboxRepository.findIndexById(id);
        return mailbox;
    }
}
