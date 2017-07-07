package com.nu.zjy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称：ticket
 * @类名称：CheCi
 * @类描述： 车次的实体类，车次的详细信息
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 上午10:15:44
 * @version 1.0
 */
public class CheCi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5324569548989014281L;
	private String start;
	private String end;
	private Date startTime;
	private Date startDate;
	private long time;
	private int farfrom;
	private String idString;

	public CheCi() {
		super();
	}

	/**
	 * @param start
	 *            起点
	 * @param end
	 *            终点
	 * @param startTime
	 *            起始时间
	 * @param startDate
	 *            起始日期
	 * @param time
	 *            全程时间
	 * @param farfrom
	 *            距离
	 * @param idString
	 *            车次号
	 */
	public CheCi(String start, String end, Date startTime, Date startDate,
			long time, int farfrom, String idString) {
		super();
		this.start = start;
		this.end = end;
		this.startTime = startTime;
		this.startDate = startDate;
		this.time = time;
		this.farfrom = farfrom;
		this.idString = idString;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public long getTime() {
		return time;
	}

	public int getFarfrom() {
		return farfrom;
	}

	public String getIdString() {
		return idString;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setFarfrom(int farfrom) {
		this.farfrom = farfrom;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	@Override
	public String toString() {
		return "CheCi [start=" + start + ", end=" + end + ", startTime="
				+ startTime + ", startDate=" + startDate + ", time=" + time
				+ ", farfrom=" + farfrom + ", idString=" + idString + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + farfrom;
		result = prime * result
				+ ((idString == null) ? 0 : idString.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheCi other = (CheCi) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (farfrom != other.farfrom)
			return false;
		if (idString == null) {
			if (other.idString != null)
				return false;
		} else if (!idString.equals(other.idString))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	
	

}
