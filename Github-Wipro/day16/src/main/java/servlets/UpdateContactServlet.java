package servlets;

import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/update")
public class UpdateContactServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        List<Contact> contacts = (List<Contact>) getServletContext().getAttribute("contacts");

        if (contacts != null) {
            for (Contact c : contacts) {
                if (c.getId().equals(id)) {
                    c.setName(name);
                    c.setPhone(phone);
                    c.setEmail(email);
                    c.setAddress(address);
                    break;
                }
            }
        }

        // Set success message
        request.getSession().setAttribute("msg", "Contact updated successfully!");

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
