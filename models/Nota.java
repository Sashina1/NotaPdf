package it.softwareInside.NoteAppLezione22.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nota {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public int id;
	
	
	@NotNull(message = "il nome non può essere nullo")
	@NotEmpty(message = "il nome nn può essere vuoto")
	private String testo, autore;
	
	
	
	public Nota( String testo, String autore) {
		setTesto(testo);
		setAutore(autore);
		
		
	}
	
	
	
	
}
