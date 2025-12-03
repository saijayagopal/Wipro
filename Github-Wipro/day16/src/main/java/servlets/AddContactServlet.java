package servlets;

import dao.ContactDAO;
import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add")
public class AddContactServlet extends HttpServlet {

    private ContactDAO dao = new ContactDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        HttpSession session = request.getSession();

        if (isEmpty(name) || isEmpty(phone) || isEmpty(email) || isEmpty(address)) {
            session.setAttribute("msg", "All fields are required.");
            response.sendRedirect("list");
            return;
        }

        // Add contact
        dao.add(new Contact(null, name, phone, email, address));

        session.setAttribute("msg", "✔ Contact added successfully!");
        response.sendRedirect("list");
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addContact.jsp").forward(request, response);
    }
}
