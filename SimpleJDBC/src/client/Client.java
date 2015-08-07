package client;

import dao.CustomerDAO;
import entities.Customer;

public class Client {
    public static void main(String[] args) {
        CustomerDAO dao = CustomerDAO.get();
        Customer c = dao.findByPk(1);
        System.out.println(c);
    }
}
