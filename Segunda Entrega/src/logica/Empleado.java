package logica;

public class Empleado extends Persona {
	public String nomsede;
	public Empleado(String cargo, String nombre, double cedula, String fechadeNacimiento, String nacionalidad,
			String email, double celular, String login, String password, String nomsede) {
		super(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, celular, login, password);
		// TODO Auto-generated constructor stub
		this.nomsede = nomsede;
	}

	
	
	
	public String getNomsede() {
		return nomsede;
	}
	public void setNomsede(String nomsede) {
		this.nomsede = nomsede;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
	}

	@Override
	public double getCedula() {
		// TODO Auto-generated method stub
		return this.cedula;
	}

	@Override
	public void setCedula(Double cedula) {
		// TODO Auto-generated method stub
		this.cedula = cedula;
		
	}
	@Override
	public String getFechadeNacimiento() {
		// TODO Auto-generated method stub
		return this.fechadeNacimiento ;
	}
	@Override
	public void setFechadeNacimiento(String fechadenacimiento) {
		// TODO Auto-generated method stub
		this.fechadeNacimiento = fechadenacimiento;
		
	}
	@Override
	public String getNacionalidad() {
		// TODO Auto-generated method stub
		return this.nacionalidad;
	}
	@Override
	public void setNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		this.nacionalidad = nacionalidad;
		
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public void setEmail(String mail) {
		// TODO Auto-generated method stub
		this.email = mail;
	}
	@Override
	public double getCelular() {
		// TODO Auto-generated method stub
		return this.cedula;
	}
	@Override
	public void setCelular(Double celular) {
		// TODO Auto-generated method stub
		this.celular = celular;
	}
	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return this.login;
	}
	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		this.login = login;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	@Override
	public String getCargo() {
		// TODO Auto-generated method stub
		return this.cargo;
	}
	@Override
	public void setCargo(String cargo) {
		// TODO Auto-generated method stub
		this.cargo = cargo;
	}



}
