package push;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Optional.ofNullable(req.newPushBuilder()).ifPresentOrElse(
				p -> p.path("images/login_user.png").addHeader("content-type", "image/png").push(),
				() -> System.out.println("HTTP/2 is not supported"));

		Optional.ofNullable(req.newPushBuilder()).ifPresentOrElse(
				p -> p.path("css/bootstrap.min.css").addHeader("content-type", "text/css").push(),
				() -> System.out.println("HTTP/2 is not supported"));

		Optional.ofNullable(req.newPushBuilder()).ifPresentOrElse(
				p -> p.path("js/bootstrap.min.js").addHeader("content-type", "text/javascript").push(),
				() -> System.out.println("HTTP/2 is not supported"));

		Optional.ofNullable(req.newPushBuilder()).ifPresentOrElse(
				p -> p.path("js/jquery.min.js").addHeader("content-type", "text/javascript").push(),
				() -> System.out.println("HTTP/2 is not supported"));

		Optional.ofNullable(req.newPushBuilder()).ifPresentOrElse(
				p -> p.path("js/npm.js").addHeader("content-type", "text/javascript").push(),
				() -> System.out.println("HTTP/2 is not supported"));

		req.getRequestDispatcher("/login.html").forward(req, resp);
	}

}
