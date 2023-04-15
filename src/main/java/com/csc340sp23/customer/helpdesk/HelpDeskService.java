/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer.helpdesk;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hilda
 */
@Service
@Transactional
public class HelpDeskService {

    @Autowired
    private HelpDeskRepository helpDeskRepo;
   

    public List<HelpDesk> getAllMessages() {
        return helpDeskRepo.findAll();

    }

    public HelpDesk getMessageById(Long messageId) {
        return helpDeskRepo.findById(messageId).orElseThrow(() -> new RuntimeException("message not found"));
    }

    public HelpDesk updateMessage(Long messageId, HelpDesk helpDeskDetails) {
        HelpDesk helpDesk = helpDeskRepo.findById(messageId).orElseThrow(() -> new RuntimeException("Message not found"));
        helpDesk.setName(helpDeskDetails.getName());
        helpDesk.setMessageContent(helpDeskDetails.getMessageContent());
        helpDesk.setMessageDate(helpDeskDetails.getMessageDate());
        return helpDeskRepo.save(helpDesk);
    }
    
    public void deleteMessageById(Long messageId){
    helpDeskRepo.deleteById(messageId);
    
    }
     public void saveMessage(HelpDesk message) {
        helpDeskRepo.save(message);
    }
   
}
