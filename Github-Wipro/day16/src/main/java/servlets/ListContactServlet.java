package servlets;

import dao.ContactDAO;
import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListContactServlet extends HttpServlet {

    private ContactDAO dao = new ContactDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Contact> contacts = dao.getAll();

        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/jsp/listContacts.jsp").forward(request, response);
    }
}
