package it.softwareInside.NoteAppLezione22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.repository.NotaRepository;
import jakarta.validation.Valid;

@Service
public class NotaService {

	
	@Autowired
	NotaRepository nr;
	
	
	
	public Nota cercaNota(int id) {
		
		try {
			return nr.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	public boolean addNote(@Valid Nota nota) {
		
		try {
			 nr.save(nota);
			 return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	public Iterable<Nota> tornaNote() {
		
		return nr.findAll();
	}
	
	
	
	public Nota deleteNota(int id) {
		 
		try {
			
			Nota nota = nr.findById(id).get();
			nr.deleteById(id);
			return nota;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	public void deleteAll() {
		
		 nr.deleteAll();
	}
	
	
	
	public boolean update(@Valid Nota nota) {
		
		return addNote(nota);
	}
	
	
	
	
//	public PDDocument pdf (int id) {
//		PDDocument  docu = new PDDocument();
//		PDPage page = new PDPage();
//		try {
//			PDPageContentStream contentStream = new PDPageContentStream(docu, page);
//			contentStream.beginText();
//			contentStream.setFont(PDType1Font.SYMBOL, 6);
//			contentStream.newLineAtOffset(20, 800);
//			contentStream.showText(nr.findById(id).toString());
//			contentStream.endText();
//			contentStream.close();
//			docu.addPage(page);
//			docu.save(new File("./nome.pdf"));
//	        return docu;
//	        
//		} catch (Exception e) {
//			return null;
//		}
//		
//	}
	
	
	
	
	
	
}
