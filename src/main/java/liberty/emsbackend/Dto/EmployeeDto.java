package liberty.emsbackend.Dto;


public class EmployeeDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private byte[] image;
	private String status;
	
	
	
	public EmployeeDto(Long id, String firstName, String lastName, String email, byte[] image , String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.image = image;
		this.status = status;
	}
	public EmployeeDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatu(String status) {
		this.status = status;
	}
	

}
