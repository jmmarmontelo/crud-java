package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id. */
	private String id;
	
	/** The nome. */
	private String nome;
	
	/** The ano. */
	private String ano;
	
	/** The descricao. */
	private String descricao;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
		
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	public JavaBeans(String id, String nome, String fone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano = fone;
		this.descricao = email;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the ano.
	 *
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * Sets the ano.
	 *
	 * @param ano the new ano
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
