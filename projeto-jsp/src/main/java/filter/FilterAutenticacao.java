package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/principal/*" }) // Intercepta toda as requisições que vierem do projeto ou mapeamento
public class FilterAutenticacao extends HttpFilter implements Filter {

	private static Connection connection;

	public FilterAutenticacao() {
		super();

	}

	public void destroy() {// Encerra os processos quando o servidor é parado
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Tudo que fizer no sistema vai passar aqui
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuariLogado = (String) session.getAttribute("usuario");
			String urlParaAutenticar = req.getServletPath();// URL que está sendo acessada
			String url = request.getParameter("url");

			/* Validar se está logado, senão redirecionar para a tela de login */
			if (usuariLogado == null
					&& !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {/* Não está logado */

				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor, realize o login!");
				redireciona.forward(request, response);
				return;// Para a execução e redireciona para login

			} else {
				chain.doFilter(request, response);
			}
			
			connection.commit();
		
		} catch (Exception e) {
			e.printStackTrace();	
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {// Inicia os processos ou recursos quando o servidor
		connection = SingleConnectionBanco.getConnection();

	}

}
