package logica;

public abstract class Persona {
	public String nombre;
	public double cedula;
	public String fechadeNacimiento;
	public String nacionalidad;
	public String email;
	public String cargo;
	public double celular;
	//public **imagen documento**//
	public String login;
	public String password;
	public Persona(String cargo,String nombre, double cedula, String fechadeNacimiento, String nacionalidad, String email,
			double celular, String login, String password) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.fechadeNacimiento = fechadeNacimiento;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.celular = celular;
		this.login = login;
		this.password = password;
		this.cargo = cargo;
	}
	public abstract String getNombre();
	
	

	
	public abstract double getCedula();
	
	public abstract void setCedula(Double cedula) ;
	public abstract String getFechadeNacimiento();
	public abstract void setFechadeNacimiento(String fechadenacimiento);
	public abstract String getNacionalidad();
	public abstract void setNacionalidad(String nacionalidad);
	public abstract String getEmail();
	public abstract void setEmail(String mail);
	public abstract double getCelular();
	public abstract void setCelular(Double celular);
	public abstract String getLogin();
	public abstract void setLogin(String login);
	public abstract String getPassword();
	public abstract void setPassword(String password);
	public abstract String getCargo();
	public abstract void setCargo(String cargo);
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
