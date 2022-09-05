package models;

import java.time.LocalDate;

public class Livro {
	
	private Integer id;
	private String name;
	private String description;
	private String resumedDescription;
	private String autor;
	private LocalDate dataLancamento;
	private Status status;
	
	public Livro() {}
	 
	public Livro(Integer id, String name, String description, String autor, String data) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.resumedDescription = this.description;
		this.dataLancamento = dateStringToLocalDate(data); 

	}
	
	public Livro(String name, String description, String autor, String data) {
		super();
		this.name = name;
		this.description = description;
		this.resumedDescription = this.description;
		this.autor = autor;
		this.dataLancamento = dateStringToLocalDate(data); 
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResumedDescription() {
		return resumedDescription;
	}

	public void setResumedDescription(String resumedDescription) {
		this.resumedDescription = resumedDescription;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {	
		
		this.status = status;
	}

	public void setDataLancamento(String data) {
		LocalDate dataLanc = null;
		try {
			
			dataLanc = this.dateStringToLocalDate(data);
		
		} catch (Exception e) {
			throw new IllegalArgumentException("data não informada ou formato incorreto");
		}
		this.dataLancamento = dataLanc; 
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public LocalDate dateStringToLocalDate(String data) {
		
		
		LocalDate localDate = LocalDate.parse(data);
		
		return localDate;
	}
	
	 public enum Status {
	        EMPRESTADO("emprestado"), DISPONIVEL("disponivel"), INDISPONIVEL("indisponivel");

	        private Status(String label) {
	            this.label = label;
	        }

	        public String label;

	        @SuppressWarnings("unused")
			public String getLabel() {
	            return label;
	        }
	    } 

}
