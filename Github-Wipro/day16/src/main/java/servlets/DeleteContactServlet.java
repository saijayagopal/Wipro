package servlets;

import dao.ContactDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet {

    private ContactDAO dao = new ContactDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");
        HttpSession session = request.getSession();

        if (dao.delete(id)) {
            session.setAttribute("msg", "✔ Contact deleted successfully.");
        } else {
            session.setAttribute("msg", "❌ Error: Unable to delete contact.");
        }

        response.sendRedirect("list");
    }
}
