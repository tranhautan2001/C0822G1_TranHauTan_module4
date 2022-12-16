package com.codegym.repository.impl;

import com.codegym.model.Mailbox;
import com.codegym.repository.IMailboxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {
    private static List<Mailbox> mailboxList;


    static {
        mailboxList = new ArrayList<>();
        mailboxList.add(new Mailbox(1,"English",5,true,"Thor"));
        mailboxList.add(new Mailbox(2,"Vietnamese",10,false,"Thor"));
        mailboxList.add(new Mailbox(3,"Japanese",15,false,"Thor"));
        mailboxList.add(new Mailbox(4,"Chinese",25,true,"Thor"));
    }

    @Override
    public List<Mailbox> finAll() {
        return mailboxList;
    }

    @Override
    public void save(Mailbox mailbox) {
        for (Mailbox mb : mailboxList) {
            if (mb.getId() == mailbox.getId()) {
                mb.setLanguage(mailbox.getLanguage());
                mb.setSignature(mailbox.getSignature());
                return;
            }
        }

//      int index = findIndexById(mailbox.getId());
//      mailboxList.set(index,mailbox);
    }

    @Override
    public Mailbox findIndexById(int id) {
       for (int i = 0; i< mailboxList.size(); i++){
           if (mailboxList.get(i).getId() == id){
               return mailboxList.get(i);
           }
       }
       return null;
    }
}
