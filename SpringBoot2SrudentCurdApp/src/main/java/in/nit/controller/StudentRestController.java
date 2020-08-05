package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Student;
import in.nit.service.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {
	@Autowired
	private IStudentService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list=service.getAllStudents();
		return ResponseEntity.ok(list);
		//return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Student student)
	{
		Integer id=service.saveStudent(student);
		return ResponseEntity.ok("Student saved=>"+id);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		service.deleteStudent(id);
		return ResponseEntity.ok("Student '"+id+"' deleted");
	}
	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getOne(@PathVariable Integer id)
	{
		Student s=service.getOneStudent(id);
		return ResponseEntity.ok(s);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(
			@RequestBody Student student
			)
	{
		service.updateStudent(student);
		return ResponseEntity.ok("Updated!");
	}
	
}



