package Cliente;

public class usuario {
	String nombre;
	String email;
	String contrasenya;
	String fechaNac;
	float peso;
	float altura;
	int frecCardMax;
	int frecCardRepo;
	public usuario(String nombre, String email, String contrasenya, float peso, float altura, int frecCardMax,
			int frecCardRepo, String fechaNac) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contrasenya = contrasenya;
		this.peso = peso;
		this.altura = altura;
		this.frecCardMax = frecCardMax;
		this.frecCardRepo = frecCardRepo;
		this.fechaNac = fechaNac;
	}
	public usuario() {
		super();
		this.nombre = "";
		this.email = "";
		this.contrasenya = "";
		this.peso = 0;
		this.altura = 0;
		this.frecCardMax = 0;
		this.frecCardRepo = 0;
		this.fechaNac = "";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public int getFrecCardMax() {
		return frecCardMax;
	}
	public void setFrecCardMax(int frecCardMax) {
		this.frecCardMax = frecCardMax;
	}
	public int getFrecCardRepo() {
		return frecCardRepo;
	}
	public void setFrecCardRepo(int frecCardRepo) {
		this.frecCardRepo = frecCardRepo;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	@Override
	public String toString() {
		return "Usuario con el nombre:" + nombre + ", email:" + email + ", contrasenya:" + contrasenya + ", peso:" + peso
				+ ", altura:" + altura + ", frecCardMax:" + frecCardMax + ", frecCardRepo:" + frecCardRepo+ ", FechaNac: "+fechaNac;
	}
	
	
	
}
