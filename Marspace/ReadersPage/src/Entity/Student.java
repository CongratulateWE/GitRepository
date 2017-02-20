package Entity;
/**
 * 2016年12月11日 12:53:34
 * @author nokan
 *
 */
public class Student {
	
	private String id;			//id
	private String student_id;	//学号
	private String name;			//身份证号
	private String id_card;
	private String campus_card;	//一卡通卡号
	private String campus_card_lib;	//一卡通图书证号
	private String gender;		
	private String nationality;	//民族
	private String division;	//部门
	private String div_code;	//
	
	private String dormitory;
	private String dormitory_id;
	private String room_id;
	private String room;
	private String floor;
	
	private String bed;
	private String startdate;
	private String type;
	private String photopath;	//照片的文件地址

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	
	public Student() {
		super();
	}

	/**
	 * 没有照片
	 * @param id
	 * @param student_id
	 * @param name
	 * @param id_card
	 * @param campus_card
	 * @param campus_card_lib
	 * @param gender
	 * @param nationality
	 * @param division
	 * @param div_code
	 * @param dormitory
	 * @param dormitory_id
	 * @param room_id
	 * @param room
	 * @param floor
	 * @param bed
	 * @param startdate
	 * @param type
	 */
	public Student(String id, String student_id, String name, String id_card, String campus_card,
			String campus_card_lib, String gender, String nationality, String division, String div_code,
			String dormitory, String dormitory_id, String room_id, String room, String floor, String bed,
			String startdate, String type) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.name = name;
		this.id_card = id_card;
		this.campus_card = campus_card;
		this.campus_card_lib = campus_card_lib;
		this.gender = gender;
		this.nationality = nationality;
		this.division = division;
		this.div_code = div_code;
		this.dormitory = dormitory;
		this.dormitory_id = dormitory_id;
		this.room_id = room_id;
		this.room = room;
		this.floor = floor;
		this.bed = bed;
		this.startdate = startdate;
		this.type = type;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", student_id=" + student_id + ", name=" + name + ", id_card=" + id_card
				+ ", campus_card=" + campus_card + ", campus_card_lib=" + campus_card_lib + ", gender=" + gender
				+ ", nationality=" + nationality + ", division=" + division + ", div_code=" + div_code + ", dormitory="
				+ dormitory + ", dormitory_id=" + dormitory_id + ", room_id=" + room_id + ", room=" + room + ", floor="
				+ floor + ", bed=" + bed + ", startdate=" + startdate + ", type=" + type + ", photopath=" + photopath
				+ "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId_card() {
		return id_card;
	}


	public void setId_card(String id_card) {
		this.id_card = id_card;
	}


	public String getCampus_card() {
		return campus_card;
	}


	public void setCampus_card(String campus_card) {
		this.campus_card = campus_card;
	}


	public String getCampus_card_lib() {
		return campus_card_lib;
	}


	public void setCampus_card_lib(String campus_card_lib) {
		this.campus_card_lib = campus_card_lib;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public String getDiv_code() {
		return div_code;
	}


	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}


	public String getDormitory() {
		return dormitory;
	}


	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}


	public String getDormitory_id() {
		return dormitory_id;
	}


	public void setDormitory_id(String dormitory_id) {
		this.dormitory_id = dormitory_id;
	}


	public String getRoom_id() {
		return room_id;
	}


	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getBed() {
		return bed;
	}


	public void setBed(String bed) {
		this.bed = bed;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPhotopath() {
		return photopath;
	}


	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	
}
