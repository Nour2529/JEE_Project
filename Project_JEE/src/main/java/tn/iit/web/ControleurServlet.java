package tn.iit.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import tn.iit.dao.ClasseDaoImpl;
import tn.iit.dao.IClasseDao;
import tn.iit.dao.IMatiereDao;
import tn.iit.dao.IPersonneDao;
import tn.iit.dao.ITirageDao;
import tn.iit.dao.MatiereDaoImpl;
import tn.iit.dao.PersonneDaoImpl;
import tn.iit.dao.TirageDaoImpl;
import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Matiere;
import tn.iit.metier.entites.Personne;
import tn.iit.metier.entites.Tirage;



@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IClasseDao metier;
	IMatiereDao matiere;
	ITirageDao tirage;
	IPersonneDao personne;
	 @Override
	public void init() throws ServletException {
		metier = new ClasseDaoImpl();
		matiere = new MatiereDaoImpl();
		tirage = new TirageDaoImpl();
		personne = new PersonneDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		/*classe**********************************************************/
		else if (path.equals("/classe.do"))
		{
			request.getRequestDispatcher("classe.jsp").forward(request,response);
		}
		
	
		
		else if (path.equals("/chercherclasse.do"))
		{
			String motCle=request.getParameter("motCle");
			ClasseGroup model= new ClasseGroup();
			model.setMotCle(motCle);
			List<Classe> clas = metier.classeParMC(motCle);
			model.setClasse(clas);
			request.setAttribute("model", model);
			request.getRequestDispatcher("classe.jsp").forward(request,response);
		}
		else if (path.equals("/saisieclasse.do")  )
		{
			request.getRequestDispatcher("saisieClasse.jsp").forward(request,response);
		}
		else if (path.equals("/saveclasse.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom");
			Classe c = metier.save(new Classe(nom));
			request.setAttribute("classe", c);
			request.getRequestDispatcher("classe.jsp").forward(request,response);
		}
		else if (path.equals("/supprimerclasse.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteClasse(id);
		    response.sendRedirect("chercherclasse.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editerclasse.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Classe c = metier.getClasse(id);
		    request.setAttribute("classe", c);
			request.getRequestDispatcher("editerClasse.jsp").forward(request,response);
		}
		else if (path.equals("/updateclasse.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 Classe c = new Classe();
			 c.setId(id);
			 c.setNom(nom);
			
			 metier.updateClasse(c);
			 request.setAttribute("classe", c);
			 request.getRequestDispatcher("classe.jsp").forward(request,response);
		}
		/*fin classe***********************************************************/
		/*Personne**********************************************************/
		else if (path.equals("/personne.do"))
		{
			request.getRequestDispatcher("personne.jsp").forward(request,response);
		}
		
	
		
		else if (path.equals("/chercherpersonne.do"))
		{
			String motCle=request.getParameter("motCle");
			PersonneS model= new PersonneS();
			model.setMotCle(motCle);
			List<Personne> clas = personne.personneParMC(motCle);
			model.setPersonne(clas);
			request.setAttribute("model", model);
			request.getRequestDispatcher("personne.jsp").forward(request,response);
		}
		
		else if (path.equals("/saisiepersonne.do")  )
		{
			request.getRequestDispatcher("saisiePersonne.jsp").forward(request,response);
		}
		else if (path.equals("/savepersonne.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom");
		    String prenom=request.getParameter("prenom");
		    String login=request.getParameter("login");
		    String mdp=request.getParameter("mdp");
		    String type=request.getParameter("type");
			Personne p = personne.save(new Personne(nom,prenom,login,mdp,type));
			request.setAttribute("personne", p);
			request.getRequestDispatcher("personne.jsp").forward(request,response);
		}
		else if (path.equals("/supprimerpersonne.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    personne.deletePersonne(id);
		    response.sendRedirect("chercherpersonne.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editerpersonne.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Personne p = personne.getPersonne(id);
		    request.setAttribute("personne", p);
			request.getRequestDispatcher("editerPersonne.jsp").forward(request,response);
		}
		else if (path.equals("/updatepersonne.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			 String login=request.getParameter("login");
			 String mdp=request.getParameter("mdp");
			 String type=request.getParameter("type");
			 Personne p = new Personne();
			 p.setId(id);
			 p.setNom(nom);
			 p.setPrenom(prenom);
			 p.setLogin(login);
			 p.setMdp(mdp);
			 p.setType(type);
			
			 personne.updatePersonne(p);
			 request.setAttribute("personne", p);
			 request.getRequestDispatcher("personne.jsp").forward(request,response);
		}
		
		/*Tirage**********************************************************/
		else if (path.equals("/tirage.do"))
		{
			request.getRequestDispatcher("tirage.jsp").forward(request,response);
		}
		
	
		
		else if (path.equals("/cherchertirage.do"))
		{
			String motCle=request.getParameter("motCle");
			TirageS model= new TirageS();
			model.setMotCle(motCle);
			List<Tirage> clas = tirage.tirageParMC(motCle);
			model.setTirage(clas);
			request.setAttribute("model", model);
			request.getRequestDispatcher("tirage.jsp").forward(request,response);
		}
		else if (path.equals("/saisietirage.do")  )
		{
			request.getRequestDispatcher("saisieTirage.jsp").forward(request,response);
		}
		else if (path.equals("/savetirage.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom_fichier");
		    String date_env=request.getParameter("date_env");
		    String date_tret=request.getParameter("date_tret");
		    String etat=request.getParameter("etat");
		    String nom_ens=request.getParameter("nom_ens");
			Tirage c = tirage.save(new Tirage(nom,date_env,date_tret,etat,nom_ens));
			request.setAttribute("tirage", c);
			request.getRequestDispatcher("tirage.jsp").forward(request,response);
		}
		else if (path.equals("/supprimertirage.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    tirage.deleteTirage(id);
		    response.sendRedirect("cherchertirage.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editertirage.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Tirage c = tirage.getTirage(id);
		    request.setAttribute("tirage", c);
			request.getRequestDispatcher("editerTirage.jsp").forward(request,response);
		}
		else if (path.equals("/updateclasse.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom_fichier");
			 String nom_ens=request.getParameter("nom_ens");
			 Tirage c = new Tirage(nom, nom_ens, nom, nom, nom);
			 c.setId(id);
			 c.setNom_fichier(nom);
			 c.setNom_ens(nom_ens);
			
			 tirage.updateTirage(c);
			 request.setAttribute("tirage", c);
			 request.getRequestDispatcher("tirage.jsp").forward(request,response);
		}
		/*matiere***************************************************************/
		
		else if (path.equals("/matiere.do"))
		{
			request.getRequestDispatcher("matiere.jsp").forward(request,response);
		}
		
		else if (path.equals("/cherchermatiere.do"))
		{
			String motCle=request.getParameter("motCle");
			MatiereS model= new MatiereS();
			model.setMotCle(motCle);
			List<Matiere> mat = matiere.matiereParMC(motCle);
			model.setMatiere(mat);
			request.setAttribute("model", model);
			request.getRequestDispatcher("matiere.jsp").forward(request,response);
		}
		else if (path.equals("/saisiematiere.do")  )
		{
			request.getRequestDispatcher("saisieMatiere.jsp").forward(request,response);
		}
		else if (path.equals("/savematiere.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom");
		    String id_ens=request.getParameter("id_ens");
		    String id_class=request.getParameter("id_class");
			Matiere m = matiere.save(new Matiere(nom,1,3));
			request.setAttribute("matiere", m);
			request.getRequestDispatcher("matiere.jsp").forward(request,response);
		}
		else if (path.equals("/supprimermatiere.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    matiere.deleteMatiere(id);
		    response.sendRedirect("cherchermatiere.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editermatiere.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Matiere m = matiere.getMatiere(id);
		    request.setAttribute("matiere", m);
			request.getRequestDispatcher("editerMatiere.jsp").forward(request,response);
		}
		else if (path.equals("/updatematiere.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 Matiere m = new Matiere();
			 m.setId(id);
			 m.setNom(nom);
			
			 matiere.updateMatiere(m);
			 request.setAttribute("matiere", m);
			 request.getRequestDispatcher("matiere.jsp").forward(request,response);
		}
		/*fin matiere*******************************************************/
		
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
