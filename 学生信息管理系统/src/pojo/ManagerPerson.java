package pojo;

public class ManagerPerson extends Person{
	private int rank;//管理员的等级，0为超级管理员，1为普通管理员

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}


