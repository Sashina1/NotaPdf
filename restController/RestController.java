package it.softwareInside.NoteAppLezione22.restController;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.service.NotaService;
import it.softwareInside.NoteAppLezione22.service.PDFService;



@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	NotaService ns;

	
	@Autowired
	PDFService pdfs;
	
	
	
	@PostMapping("/add")
	public boolean addNote(@RequestBody Nota nota) {
		
		return ns.addNote(nota);
	}
	
	
	
	@PostMapping("/cercaId")
	public Nota cercaNota(@RequestParam("id") int id) {
		
		Nota nota = ns.cercaNota(id);
		
		return nota;  
		
	}
	
	
	@GetMapping("/printAll")
	public Iterable<Nota> printAll(){
		
		return ns.tornaNote();
	}
	
	
	
	@DeleteMapping("/deleteId")
	public Nota deleteId(@RequestParam("id")int id) {
		
		return ns.deleteNota(id);
	}
	
	
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		
		ns.deleteAll();
	}
	
	
	
	@PostMapping("/update")
	public boolean updateNota(@RequestBody Nota nota) {
		try {
			return ns.update(nota);
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	 @RequestMapping(value = "/pdf", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> generaNota(@RequestParam("id") int id ) {

	    	
	    	try {
	    		
	            ByteArrayInputStream bis = pdfs.generaPDFNota(id); 

	            var headers = new HttpHeaders();
	            headers.add("Content-Disposition", "inline; filename=nome.pdf");
	    		
	            
	            
	            return ResponseEntity
	                    .ok()
	                    .headers(headers)
	                    .contentType(MediaType.APPLICATION_PDF)
	                    .body(new InputStreamResource(bis));
	    		
	    	}catch (Exception e) {
				return null;
	    	
	    
	    	}
		
	    }
	
	
}
