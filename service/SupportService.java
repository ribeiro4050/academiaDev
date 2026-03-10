package academiaDev.service;

import academiaDev.support.SupportTicket;

import java.util.Queue;

public class SupportService {

    private Queue<SupportTicket> tickets;

    public SupportService(Queue<SupportTicket> tickets) {
        this.tickets = tickets;
    }

    public void openTicket(SupportTicket ticket){
        tickets.add(ticket);
    }

    public SupportTicket processTicket(){
        return tickets.poll();
    }
}