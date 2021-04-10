package co.edu.eafit.bank.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.eafit.bank.domain.DocumentType;
@SpringBootTest

class DocumentTypeRepositoryIT {
	
	@Autowired
	DocumentTypeRepository documentRepository;

	@Test
	void findAll() {
		// Arrange
		List<DocumentType> documents = null;
				
		// Act
		documents = documentRepository.findAll();
		
		// Assert
		assertNotNull(documents);
		assertFalse(documents.isEmpty());
	}

}
