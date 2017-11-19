package br.com.profcamila.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import br.com.profcamila.google.IdTokenVerifierAndParser;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            TaskBean task = new TaskBean();
            task.iniciar(name, email);
            
            HttpSession ses = req.getSession();
            ses.setAttribute("usuario", name);
            req.getServletContext()
               .getRequestDispatcher("/tela_inicial.jsf").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

}
