package Entity;

public class Reader {
	private String lib_id;		//
	private String reader_id;
	private String name;
	private String gender;
	private String id_card;
	private String level;
	private String level_code;
	private String div_code;
	private String division;
	private String tel;
	private String address;
	private String post_code;
	private String email;
	private String deposit = "0";
	private String borrow_limit = "0";
	private String borrowed = "0";
	private String startDate;	//	发证日期	
	private String endDate;		//	失效日期	
	private String lock;		//	挂失注销
	private String lockDate;		//	挂失日期
	
	private String fine = "0";		//	欠罚款	double
	private String compensate = "0";		//	欠赔款	double
	private String lastDate;		//	上次到馆时间	date
	private String lastMonthBrrowed = "0";		//	上月外借册数
	private String thisMonthBrrowed = "0";		//	本月外借册数
	private String thisYearBrrowed = "0";		//	今年外借册数
	private String lastYearBrrowed = "0";		//	去年外借册数
	private String totalBrrowed = "0";		//	累计外借册数
	private String totalExpiryBooknum = "0";		//	累计超期册数
	private String totalPaiedfine = "0";		//	累计交罚款
	private String totalPaiedcompensate = "0";		//	累计赔款
	private String thisMonthVisited = "0";		//	本月到馆次数
	private String lastMonthVisited = "0";		//	上月到馆次数
	private String thisYearVisited = "0";		//	今年到馆次数
	private String lastYearVisited = "0";		//	去年到馆次数
	private String totalVisited = "0";		//	累计到馆次数
	private String password;		//	密码
	private String remark;			//	备注
	private String photopath;		//	照片
	private String Retain_info;		//	保留信息
	
	private String nationality;		//	民族
	private String readingroomBrrowed = "0";		//	阅览室外借	int
	private String agent;		//	代理人
	private String balance = "0";		//	余额
	private String total = "0";		//	总计
	private String freeHours = "0";		//	免费机时
	private String specialBrrowedDeposit = "0";		//	特借押金
	private String specialBrrowed = "0";		//	已借特借书
	private String primarykey = "0";		//	主键码
	private String libkey = "0";		//	馆键码
	private String freezedDate;		//	停用日期
	private String freezedDays;		//	停用天数
	private String classnum;		//	班级
	private String breaktime;		//	预约违章次数
	private String servicefee;		//	服务费
	private String badRecommendTimes;		//	恶意推荐次数
	private String grade;		//	年级
	private String major;		//	专业
	private String department;		//	系别
	private String phone;		//	手机
	
	private String ISSYNC;		//如果加上照片的话刚好第61个，Photo用String表示路径
	
	public Reader()
	{
		
	}
	
	/*
	 * 最开始的全局搜索用到了它，暂时先不改动
	 */
	public Reader(String lib_id, String reader_id, String name, String gender, String id_card, String level)
	{
		this.lib_id = lib_id;
		this.reader_id = reader_id;
		this.name = name;
		this.gender = gender;
		this.id_card = id_card;
		this.level = level;
	}
	
	/*
	 * 借书证号,读者条码,姓名,性别,身份证号, 读者级别, 级别代码, 单位代码, 单位, 主键码, 馆键码	
	 * 
	 * --单位之前的顺序与数据库列名一致
	 * --这个构造方法用在主要信息检索的时候，构造reader。
	 */
	public Reader(String lib_id, String reader_id, String name, String gender, String id_card, String level,
			String level_code, String div_code, String division, String primarykey, String libkey) {
		super();
		this.lib_id = lib_id;
		this.reader_id = reader_id;
		this.name = name;
		this.gender = gender;
		this.id_card = id_card;
		this.level = level;
		this.level_code = level_code;
		this.div_code = div_code;
		this.division = division;
		this.primarykey = primarykey;
		this.libkey = libkey;
	}
	
	
/*
 * 详细信息检索的时候用到,就是不包含备注信息
 */
	public Reader(String lib_id, String reader_id, String name, String gender, String id_card, String level,
			String level_code, String div_code, String division, String tel, String address, String post_code,
			String email, String deposit, String borrow_limit, String borrowed, String startDate, String endDate,
			String lock, String lockDate, String fine, String compensate, String lastDate, String lastMonthBrrowed,
			String thisMonthBrrowed, String thisYearBrrowed, String lastYearBrrowed, String totalBrrowed,
			String totalExpiryBooknum, String totalPaiedfine, String totalPaiedcompensate, String thisMonthVisited,
			String lastMonthVisited, String thisYearVisited, String lastYearVisited, String totalVisited,
			String password, String remark, String retain_info, String nationality, String readingroomBrrowed,
			String agent, String balance, String total, String freeHours, String specialBrrowedDeposit,
			String specialBrrowed, String primarykey, String libkey, String freezedDate, String freezedDays,
			String classnum, String breaktime, String servicefee, String badRecommendTimes, String grade, String major,
			String department, String phone, String iSSYNC) {
		super();
		this.lib_id = lib_id;
		this.reader_id = reader_id;
		this.name = name;
		this.gender = gender;
		this.id_card = id_card;
		this.level = level;
		this.level_code = level_code;
		this.div_code = div_code;
		this.division = division;
		this.tel = tel;
		this.address = address;
		this.post_code = post_code;
		this.email = email;
		this.deposit = deposit;
		this.borrow_limit = borrow_limit;
		this.borrowed = borrowed;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lock = lock;
		this.lockDate = lockDate;
		this.fine = fine;
		this.compensate = compensate;
		this.lastDate = lastDate;
		this.lastMonthBrrowed = lastMonthBrrowed;
		this.thisMonthBrrowed = thisMonthBrrowed;
		this.thisYearBrrowed = thisYearBrrowed;
		this.lastYearBrrowed = lastYearBrrowed;
		this.totalBrrowed = totalBrrowed;
		this.totalExpiryBooknum = totalExpiryBooknum;
		this.totalPaiedfine = totalPaiedfine;
		this.totalPaiedcompensate = totalPaiedcompensate;
		this.thisMonthVisited = thisMonthVisited;
		this.lastMonthVisited = lastMonthVisited;
		this.thisYearVisited = thisYearVisited;
		this.lastYearVisited = lastYearVisited;
		this.totalVisited = totalVisited;
		this.password = password;
		this.remark = remark;
		Retain_info = retain_info;
		this.nationality = nationality;
		this.readingroomBrrowed = readingroomBrrowed;
		this.agent = agent;
		this.balance = balance;
		this.total = total;
		this.freeHours = freeHours;
		this.specialBrrowedDeposit = specialBrrowedDeposit;
		this.specialBrrowed = specialBrrowed;
		this.primarykey = primarykey;
		this.libkey = libkey;
		this.freezedDate = freezedDate;
		this.freezedDays = freezedDays;
		this.classnum = classnum;
		this.breaktime = breaktime;
		this.servicefee = servicefee;
		this.badRecommendTimes = badRecommendTimes;
		this.grade = grade;
		this.major = major;
		this.department = department;
		this.phone = phone;
		ISSYNC = iSSYNC;
	}
	
	@Override
	public String toString() {
		return "Reader [lib_id=" + lib_id + ", reader_id=" + reader_id + ", name=" + name + ", gender=" + gender
				+ ", id_card=" + id_card + ", level=" + level + ", level_code=" + level_code + ", div_code=" + div_code
				+ ", division=" + division + ", tel=" + tel + ", address=" + address + ", post_code=" + post_code
				+ ", email=" + email + ", deposit=" + deposit + ", borrow_limit=" + borrow_limit + ", borrowed="
				+ borrowed + ", startDate=" + startDate + ", endDate=" + endDate + ", lock=" + lock + ", lockDate="
				+ lockDate + ", fine=" + fine + ", compensate=" + compensate + ", lastDate=" + lastDate
				+ ", lastMonthBrrowed=" + lastMonthBrrowed + ", thisMonthBrrowed=" + thisMonthBrrowed
				+ ", thisYearBrrowed=" + thisYearBrrowed + ", lastYearBrrowed=" + lastYearBrrowed + ", totalBrrowed="
				+ totalBrrowed + ", totalExpiryBooknum=" + totalExpiryBooknum + ", totalPaiedfine=" + totalPaiedfine
				+ ", totalPaiedcompensate=" + totalPaiedcompensate + ", thisMonthVisited=" + thisMonthVisited
				+ ", lastMonthVisited=" + lastMonthVisited + ", thisYearVisited=" + thisYearVisited
				+ ", lastYearVisited=" + lastYearVisited + ", totalVisited=" + totalVisited + ", password=" + password
				+ ", remark=" + remark + ", Retain_info=" + Retain_info + ", nationality=" + nationality
				+ ", readingroomBrrowed=" + readingroomBrrowed + ", agent=" + agent + ", balance=" + balance
				+ ", total=" + total + ", freeHours=" + freeHours + ", specialBrrowedDeposit=" + specialBrrowedDeposit
				+ ", specialBrrowed=" + specialBrrowed + ", primarykey=" + primarykey + ", libkey=" + libkey
				+ ", freezedDate=" + freezedDate + ", freezedDays=" + freezedDays + ", classnum=" + classnum
				+ ", breaktime=" + breaktime + ", servicefee=" + servicefee + ", badRecommendTimes=" + badRecommendTimes
				+ ", grade=" + grade + ", major=" + major + ", department=" + department + ", phone=" + phone
				+ ", ISSYNC=" + ISSYNC + "]";
	}

	public String getLib_id() {
		return lib_id;
	}

	public void setLib_id(String lib_id) {
		if(lib_id != "")
		this.lib_id = lib_id;
	}

	public String getReader_id() {
		return reader_id;
	}

	public void setReader_id(String reader_id) {
		if(reader_id != "")
		this.reader_id = reader_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != "")
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if(gender != "")
		this.gender = gender;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		if(gender != "")
		this.id_card = id_card;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		if(gender != "")
		this.level = level;
	}

	public String getLevel_code() {
		return level_code;
	}

	public void setLevel_code(String level_code) {
		if(level_code != "")
		this.level_code = level_code;
	}

	public String getDiv_code() {
		return div_code;
	}

	public void setDiv_code(String div_code) {
		if(div_code != "")
		this.div_code = div_code;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		if(division != "")
		this.division = division;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		if(tel != "")
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address != "")
		this.address = address;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		if(post_code != "")
		this.post_code = post_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != "")
		this.email = email;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		if(deposit != "")
		this.deposit = deposit;
	}

	public String getBorrow_limit() {
		return borrow_limit;
	}

	public void setBorrow_limit(String borrow_limit) {
		if(borrow_limit != "")
		this.borrow_limit = borrow_limit;
	}

	public String getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(String borrowed) {
		if(borrowed != "")
		this.borrowed = borrowed;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		if(endDate != "")
		this.endDate = endDate;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		if(lock != "")
		this.lock = lock;
	}

	public String getLockDate() {
		return lockDate;
	}

	public void setLockDate(String lockDate) {
		if(lockDate != "")
		this.lockDate = lockDate;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		if(fine != "")
		this.fine = fine;
	}

	public String getCompensate() {
		return compensate;
	}

	public void setCompensate(String compensate) {
		if(compensate != "")
		this.compensate = compensate;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		if(lastDate != "")
		this.lastDate = lastDate;
	}

	public String getLastMonthBrrowed() {
		return lastMonthBrrowed;
	}

	public void setLastMonthBrrowed(String lastMonthBrrowed) {
		if(lastMonthBrrowed != "")
		this.lastMonthBrrowed = lastMonthBrrowed;
	}

	public String getThisMonthBrrowed() {
		return thisMonthBrrowed;
	}

	public void setThisMonthBrrowed(String thisMonthBrrowed) {
		if(thisMonthBrrowed != "")
		this.thisMonthBrrowed = thisMonthBrrowed;
	}

	public String getThisYearBrrowed() {
		return thisYearBrrowed;
	}

	public void setThisYearBrrowed(String thisYearBrrowed) {
		if(thisYearBrrowed != "")
		this.thisYearBrrowed = thisYearBrrowed;
	}

	public String getLastYearBrrowed() {
		return lastYearBrrowed;
	}

	public void setLastYearBrrowed(String lastYearBrrowed) {
		if(lastYearBrrowed != "")
		this.lastYearBrrowed = lastYearBrrowed;
	}

	public String getTotalBrrowed() {
		return totalBrrowed;
	}

	public void setTotalBrrowed(String totalBrrowed) {
		if(totalBrrowed != "")
		this.totalBrrowed = totalBrrowed;
	}

	public String getTotalExpiryBooknum() {
		return totalExpiryBooknum;
	}

	public void setTotalExpiryBooknum(String totalExpiryBooknum) {
		if(totalExpiryBooknum != "")
		this.totalExpiryBooknum = totalExpiryBooknum;
	}

	public String getTotalPaiedfine() {
		return totalPaiedfine;
	}

	public void setTotalPaiedfine(String totalPaiedfine) {
		if(totalPaiedfine != "")
		this.totalPaiedfine = totalPaiedfine;
	}

	public String getTotalPaiedcompensate() {
		return totalPaiedcompensate;
	}

	public void setTotalPaiedcompensate(String totalPaiedcompensate) {
		if(totalPaiedcompensate != "")
		this.totalPaiedcompensate = totalPaiedcompensate;
	}

	public String getThisMonthVisited() {
		return thisMonthVisited;
	}

	public void setThisMonthVisited(String thisMonthVisited) {
		if(thisMonthVisited != "")
		this.thisMonthVisited = thisMonthVisited;
	}

	public String getLastMonthVisited() {
		return lastMonthVisited;
	}

	public void setLastMonthVisited(String lastMonthVisited) {
		if(lastMonthVisited != "")
		this.lastMonthVisited = lastMonthVisited;
	}

	public String getThisYearVisited() {
		return thisYearVisited;
	}

	public void setThisYearVisited(String thisYearVisited) {
		if(thisYearVisited != "")
		this.thisYearVisited = thisYearVisited;
	}

	public String getLastYearVisited() {
		return lastYearVisited;
	}

	public void setLastYearVisited(String lastYearVisited) {
		if(lastYearVisited != "")
		this.lastYearVisited = lastYearVisited;
	}

	public String getTotalVisited() {
		return totalVisited;
	}

	public void setTotalVisited(String totalVisited) {
		if(totalVisited != "")
		this.totalVisited = totalVisited;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password != "")
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		if(remark != "")
		this.remark = remark;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		if(nationality != "")
		this.nationality = nationality;
	}

	public String getReadingroomBrrowed() {
		return readingroomBrrowed;
	}

	public void setReadingroomBrrowed(String readingroomBrrowed) {
		if(readingroomBrrowed != "")
		this.readingroomBrrowed = readingroomBrrowed;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		if(agent != "")
		this.agent = agent;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		if(balance != "")
		this.balance = balance;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		if(total != "")
		this.total = total;
	}

	public String getFreeHours() {
		return freeHours;
	}

	public void setFreeHours(String freeHours) {
		if(freeHours != "")
		this.freeHours = freeHours;
	}

	public String getSpecialBrrowedDeposit() {
		return specialBrrowedDeposit;
	}

	public void setSpecialBrrowedDeposit(String specialBrrowedDeposit) {
		if(specialBrrowedDeposit != "")
		this.specialBrrowedDeposit = specialBrrowedDeposit;
	}

	public String getSpecialBrrowed() {
		return specialBrrowed;
	}

	public void setSpecialBrrowed(String specialBrrowed) {
		if(specialBrrowed != "")
		this.specialBrrowed = specialBrrowed;
	}

	public String getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(String primarykey) {
		if(primarykey != "")
		this.primarykey = primarykey;
	}

	public String getLibkey() {
		return libkey;
	}

	public void setLibkey(String libkey) {
		if(libkey != "")
		this.libkey = libkey;
	}

	public String getFreezedDate() {
		return freezedDate;
	}

	public void setFreezedDate(String freezedDate) {
		if(freezedDate != "")
		this.freezedDate = freezedDate;
	}

	public String getFreezedDays() {
		return freezedDays;
	}

	public void setFreezedDays(String freezedDays) {
		if(freezedDays != "")
		this.freezedDays = freezedDays;
	}

	public String getClassnum() {
		return classnum;
	}

	public void setClassnum(String classnum) {
		if(classnum != "")
		this.classnum = classnum;
	}

	public String getBreaktime() {
		return breaktime;
	}

	public void setBreaktime(String breaktime) {
		if(breaktime != "")
		this.breaktime = breaktime;
	}

	public String getServicefee() {
		return servicefee;
	}

	public void setServicefee(String servicefee) {
		if(servicefee != "")
		this.servicefee = servicefee;
	}

	public String getBadRecommendTimes() {
		return badRecommendTimes;
	}

	public void setBadRecommendTimes(String badRecommendTimes) {
		if(badRecommendTimes != "")
		this.badRecommendTimes = badRecommendTimes;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		
		if(grade != "")
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		if( major != "")
		this.major = major;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if(department != "")
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(phone != "")
		this.phone = phone;
	}

	public String getISSYNC() {
		return ISSYNC;
	}

	public void setISSYNC(String iSSYNC) {
		if(iSSYNC != "")
		ISSYNC = iSSYNC;
	}	
	
	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public String getRetain_info() {
		return Retain_info;
	}

	public void setRetain_info(String retain_info) {
		Retain_info = retain_info;
	}

	/**
	 * 打算对全部的数据进行一次大清扫，如果是' '
	 */
	public void cleanData()
	{
		
	}
	
	public String iString()
	{
		return "" + lib_id + "," + 
				reader_id + "," + 
				name + "," + 
				gender + "," + 
				id_card + "," + 
				 level  + "," + 
				 level_code  + "," + 
				 div_code + "," + 
				 division + "," + 
				 tel + "," + 
				 address + "," + 
				 post_code + "," + 
				 email + "," + 
				 deposit + "," + 
				 borrow_limit + "," + 
				 borrowed + "," + 
				 startDate + "," + 	//	发证日期	
				 endDate + "," + 		//	失效日期	
				 lock + "," + 		//	挂失注销
				 lockDate + "," + 		//	挂失日期
				 fine + "," + 		//	欠罚款	double
				 compensate + "," + 		//	欠赔款	double
				 lastDate + "," + 		//	上次到馆时间	date
				 lastMonthBrrowed + "," + 		//	上月外借册数
				 thisMonthBrrowed + "," + 		//	本月外借册数
				 thisYearBrrowed + "," + 		//	今年外借册数
				 lastYearBrrowed + "," + 		//	去年外借册数
				 totalBrrowed + "," + 		//	累计外借册数
				 totalExpiryBooknum + "," + 		//	累计超期册数
				 totalPaiedfine + "," + 		//	累计交罚款
				 totalPaiedcompensate + "," + 		//	累计赔款
				 thisMonthVisited + "," + 		//	本月到馆次数
				 lastMonthVisited + "," + 		//	上月到馆次数
				 thisYearVisited + "," + 		//	今年到馆次数
				 lastYearVisited + "," + 		//	去年到馆次数
				 totalVisited + "," + 		//	累计到馆次数
				 password + "," + 		//	密码
				 remark + "," + 		//	备注
						//	照片
						//	保留信息
				 nationality + "," + 		//	民族
				 readingroomBrrowed + "," + 		//	阅览室外借	int
				 agent + "," + 		//	代理人
				 balance + "," + 		//	余额
				 total + "," + 		//	总计
				 freeHours + "," + 		//	免费机时
				 specialBrrowedDeposit + "," + 		//	特借押金
				 specialBrrowed + "," + 		//	已借特借书
				 primarykey + "," + 		//	主键码
				 libkey + "," + 		//	馆键码
				 freezedDate + "," + 		//	停用日期
				 freezedDays + "," + 		//	停用天数
				 classnum + "," + 		//	班级
				 breaktime + "," + 		//	预约违章次数
				 servicefee + "," + 		//	服务费
				 badRecommendTimes + "," + 		//	恶意推荐次数
				 grade + "," + 		//	年级
				 major + "," + 		//	专业
				 department + "," + 		//	系别
				 phone + "," + 		//	手机
				 ISSYNC + "";
	}
	
	public String insertString() {
		 return "'" + lib_id + "','" + reader_id  + "','" + name + "','" + gender + "','" + id_card + "','" + 
		 level + "','" + 
		 level_code + "','" + 
		 div_code + "','" + 
		 division + "','" + 
		 tel + "','" + 
		 address + "','" + 
		 post_code + "','" + 
		 email + "','" + 
		 deposit + "','" + 
		 borrow_limit + "','" + 
		 borrowed + //"','" + 
//		 startDate + "','" + 	//	发证日期	
		 "', TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'),TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'),'"
//		 endDate + "','" + 		//	失效日期	
		 + lock + //"','" + 		//	挂失注销
		 "',TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'),'" + 
//		 lockDate + "','" + 		//	挂失日期
		 fine + "','" + 		//	欠罚款	double
		 compensate + //"','" + 		//	欠赔款	double
		 "',TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'),'" + 
//		 lastDate + "','" + 		//	上次到馆时间	date
		 lastMonthBrrowed + "','" + 		//	上月外借册数
		 thisMonthBrrowed + "','" + 		//	本月外借册数
		 thisYearBrrowed + "','" + 		//	今年外借册数
		 lastYearBrrowed + "','" + 		//	去年外借册数
		 totalBrrowed + "','" + 		//	累计外借册数
		 totalExpiryBooknum + "','" + 		//	累计超期册数
		 totalPaiedfine + "','" + 		//	累计交罚款
		 totalPaiedcompensate + "','" + 		//	累计赔款
		 thisMonthVisited + "','" + 		//	本月到馆次数
		 lastMonthVisited + "','" + 		//	上月到馆次数
		 thisYearVisited + "','" + 		//	今年到馆次数
		 lastYearVisited + "','" + 		//	去年到馆次数
		 totalVisited + "','" + 		//	累计到馆次数
		 password + "','" + 		//	密码
		 remark + "','" + 		//	备注
				//	照片
				//	保留信息
		 nationality + "','" + 		//	民族
		 readingroomBrrowed + "','" + 		//	阅览室外借	int
		 agent + "','" + 		//	代理人
		 balance + "','" + 		//	余额
		 total + "','" + 		//	总计
		 freeHours + "','" + 		//	免费机时
		 specialBrrowedDeposit + "','" + 		//	特借押金
		 specialBrrowed + "','" + 		//	已借特借书
		 primarykey + "','" + 		//	主键码
		 libkey + //"','" + 		//	馆键码
//		 freezedDate + "','" + 		//	停用日期
		 "',TO_DATE('2012-06-20 11:02:00', 'YYYY-MM-DD HH24:MI:SS'),'" + 
		 freezedDays + "','" + 		//	停用天数
		 classnum + "','" + 		//	班级
		 breaktime + "','" + 		//	预约违章次数
		 servicefee + "','" + 		//	服务费
		 badRecommendTimes + "','" + 		//	恶意推荐次数
		 grade + "','" + 		//	年级
		 major + "','" + 		//	专业
		 department + "','" + 		//	系别
		 phone + "','" + 		//	手机
		 ISSYNC + "'";
	}
	
	public static void main(String[] args)
	{
		Reader r = new Reader();
		r.setLib_id("137036");
		System.out.println(r.iString());
		
	}
}