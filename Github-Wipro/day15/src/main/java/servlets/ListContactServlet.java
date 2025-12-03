package servlets;

import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(urlPatterns = "/list")
public class ListContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        List<Contact> list = new CopyOnWriteArrayList<>();
        getServletContext().setAttribute("contacts", list);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Contact> contacts =
                (List<Contact>) getServletContext().getAttribute("contacts");

        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/jsp/listContacts.jsp").forward(request, response);
    }
}

