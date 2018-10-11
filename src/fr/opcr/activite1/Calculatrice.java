package fr.opcr.activite1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Calculatrice
 */
@WebServlet("/Calculatrice")
public class Calculatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculatrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float nb1;
		float nb2;
		float resultat = 0;
		String erreur = "";
		try {
			char operateur = request.getParameter("operateur").charAt(0);
			
			String str1 = (String) request.getParameter("nb1");
			String str2 = (String) request.getParameter("nb2");
			nb1 = str1.isEmpty()?0:Float.parseFloat(str1);
			nb2 = str2.isEmpty()?0:Float.parseFloat(str2);
		
			switch(operateur) {
				case '+':
					resultat =  nb1 + nb2;
				break;
				case '-':
					resultat =  nb1 - nb2;
				break;
				case '*':
					resultat =  nb1 * nb2;
				break;
				case '/':
						resultat =  nb1 / nb2;
				break;
			}
		}
		catch(ArithmeticException e) {
			erreur = "La division par zéro est interdite";
		}
		catch(Exception e) {
			erreur = "Vous n'avez probablement  pas effectué les opérations sur des entiers";
		}
		
		request.setAttribute("resultat", Float.toString(resultat));
		request.setAttribute("erreur", erreur);
		this.doGet(request, response);
	}

}
