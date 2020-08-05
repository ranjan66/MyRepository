package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Student;
import in.nit.repo.StudentRepository;
import in.nit.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(Student s) {
		return repo.save(s).getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		repo.save(s);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Student getOneStudent(Integer id) {
		Optional<Student> opt=repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	
	@Override
	public boolean isStudentExist(Integer id) {
		return repo.existsById(id);
	}

}
