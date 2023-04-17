/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer.helpdesk;

import com.csc340sp23.customer.Room;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Hilda
 */
@Entity
@Table(name = "messages")
public class HelpDesk{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long messageId;
   
   @Column(name = "Guest Name", nullable = false)
   private String name;
   
   //@ManyToOne
   //@JoinColumn(name = "Room Id", nullable = false, referencedColumnName = "roomId")
  // private Room room;
   
     
  
   
   @Column (name = "Message Content", nullable = false)
   private String messageContent;
   
   @Column(name = "Message Date", nullable = false)
   private LocalDateTime messageDate = LocalDateTime.now();
   
   public HelpDesk(){
   
   }
   
   public HelpDesk(Long messageId,String name, String messageContent, LocalDateTime messageDate ){
       this.messageId = messageId;
       this.name = name;
       this.messageContent = messageContent;
       this.messageDate = messageDate;
   
   
   }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

   
  
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }
   
    
}
  
 