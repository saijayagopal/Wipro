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

@WebServlet("/edit")
public class EditContactServlet extends HttpServlet {

    private ContactDAO dao = new ContactDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Contact contact = dao.getById(id);

        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/jsp/editContact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Contact updatedContact = new Contact(
                request.getParameter("id"),
                request.getParameter("name"),
                request.getParameter("phone"),
                request.getParameter("email"),
                request.getParameter("address")
        );

        HttpSession session = request.getSession();

        if (dao.update(updatedContact)) {
            session.setAttribute("msg", "✔ Contact updated successfully!");
        } else {
            session.setAttribute("msg", "❌ Error updating contact!");
        }

        response.sendRedirect("list");
    }
}
