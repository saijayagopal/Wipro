package servlets;

import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(urlPatterns = "/add")
public class AddContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Create contact
        Contact c = new Contact(
                UUID.randomUUID().toString(),
                name,
                phone,
                email,
                address
        );

        // Get shared contact list
        List<Contact> contacts =
                (List<Contact>) getServletContext().getAttribute("contacts");

        if (contacts == null) {
            contacts = new CopyOnWriteArrayList<>();
            getServletContext().setAttribute("contacts", contacts);
        }

        contacts.add(c);

        // Redirect to list page
        response.sendRedirect(request.getContextPath() + "/list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addContact.jsp").forward(request, response);
    }
}
