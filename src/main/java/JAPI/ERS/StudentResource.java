package JAPI.ERS;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Application;

import java.util.List;

@Path("smc")
public class StudentResource {

	StudentRepo Repo = new StudentRepo();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public List<Students> ourClass () {
		return Repo.GetAllstudents();
	}
	
	

	@GET
	@Path("student/{id}")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Students GetStudent (@PathParam("id") int id) {
		System.out.println(id);
		return Repo.getStudents(id);
	}
	
	
	//Insert Data
	@POST
	@Path("enter")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Students createStudent(Students s1) {
	
		System.out.println("Crate student called.!");
		System.out.println(s1);
		Repo.createStd(s1);
		return s1;
		
	}
	
	
	//Upd1ate method
	
	@PUT
	@Path("update")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Students UpdateStudent(Students s1) {
		
		System.out.println("Update query called");
		System.out.println(s1);
		Repo.updateStd(s1);
		return s1;
		
	}
	
	// Delete method
	
	@DELETE
	@Path("student/{id}")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Students DelStudent (@PathParam("id") int id) {

		Students s1 = Repo.getStudents(id);
		
		if(s1.getId()!=0)
		Repo.DeleteStudents(id);
		return s1;
	}
}


