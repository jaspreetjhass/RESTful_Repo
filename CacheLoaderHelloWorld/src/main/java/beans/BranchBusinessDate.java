package beans;

import java.util.Date;

public class BranchBusinessDate {

	private Date changeBusinessDate;

	public BranchBusinessDate() {

	}

	public BranchBusinessDate(Date changeBusinessDate) {
		this.changeBusinessDate = changeBusinessDate;
	}

	public Date getChangeBusinessDate() {
		return changeBusinessDate;
	}

	public void setChangeBusinessDate(Date changeBusinessDate) {
		this.changeBusinessDate = changeBusinessDate;
	}

	@Override
	public String toString() {
		return "BranchBusinessDate [changeBusinessDate=" + changeBusinessDate + "]";
	}
	
}