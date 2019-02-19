package com.fsd.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subject_Data")
public class Subject implements Serializable {

	public static final long serialVersionUID = 1L;

	@Id
	@Column(name = "subjectId")
	private long subjectId;
	@Column(name = "subtitle")
	private String subtitle;
	@Column(name = "durationInHours")
	private int durationInHours;
	@Column(name = "references")
	@OneToMany(mappedBy = "subjectId")
	private List<Book> references = new ArrayList<Book>();

	public List<Book> getReferences() {
		return references;
	}

	public void setReferences(List<Book> references) {
		this.references = references;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
				+ ", references=" + references + "]";
	}

}
