package Model;

import java.util.Date;

public abstract class KingModel {
	
	private int Id;
	private Date RecordDate;
	@Override
	public String toString() {
		return "KingModel [Id=" + Id + "]";
	}
	private int Active;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getRecordDate() {
		return RecordDate;
	}
	public void setRecordDate(Date recordDate) {
		RecordDate = recordDate;
	}
	public int getActive() {
		return Active;
	}
	public void setActive(int active) {
		Active = active;
	}

}
