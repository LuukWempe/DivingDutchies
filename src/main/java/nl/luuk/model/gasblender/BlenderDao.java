package nl.luuk.model.gasblender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blender")
public class BlenderDao {
	
	@Id
	@GeneratedValue
	Long blenderId;
	
	@Column(name="c1_o2")
	double c1_o2;
	
	@Column(name="c1_n2")
	double c1_n2;
	
	@Column(name="c1_he")
	double c1_he;
	
	@Column(name="c1_size")
	double c1_size;
	
	@Column(name="c1_pressure")
	double c1_pressure;
	
	@Column(name="c2_o2")
	double c2_o2;
	
	@Column(name="c2_n2")
	double c2_n2;
	
	@Column(name="c2_he")
	double c2_he;
	
	@Column(name="c2_size")
	double c2_size;
	
	@Column(name="c2_pressure")
	double c2_pressure;
	
	@Column(name="blendMethod", columnDefinition="varchar2(20)")
	String bm;
	
	@Column(name="topOff")
	double topOff;
	
	@Column(name="blendplan", columnDefinition="varchar2(100)")
	String blendPlan;
	
	public BlenderDao() {
		this.bm = "PARTIAL";
		this.topOff = 21;
	}
	
	

	public Long getBlenderId() {
		return blenderId;
	}

	public void setBlenderId(Long blenderId) {
		this.blenderId = blenderId;
	}

	public double getC1_o2() {
		return c1_o2;
	}

	public void setC1_o2(double c1_o2) {
		this.c1_o2 = c1_o2;
	}

	public double getC1_n2() {
		return c1_n2;
	}

	public void setC1_n2(double c1_n2) {
		this.c1_n2 = c1_n2;
	}

	public double getC1_he() {
		return c1_he;
	}

	public void setC1_he(double c1_he) {
		this.c1_he = c1_he;
	}

	public double getC2_o2() {
		return c2_o2;
	}

	public void setC2_o2(double c2_o2) {
		this.c2_o2 = c2_o2;
	}

	public double getC2_n2() {
		return c2_n2;
	}

	public void setC2_n2(double c2_n2) {
		this.c2_n2 = c2_n2;
	}

	public double getC2_he() {
		return c2_he;
	}

	public void setC2_he(double c2_he) {
		this.c2_he = c2_he;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public double getTopOff() {
		return topOff;
	}

	public void setTopOff(double topOff) {
		this.topOff = topOff;
	}



	public double getC1_size() {
		return c1_size;
	}



	public void setC1_size(double c1_size) {
		this.c1_size = c1_size;
	}



	public double getC1_pressure() {
		return c1_pressure;
	}



	public void setC1_pressure(double c1_pressure) {
		this.c1_pressure = c1_pressure;
	}



	public double getC2_size() {
		return c2_size;
	}



	public void setC2_size(double c2_size) {
		this.c2_size = c2_size;
	}



	public double getC2_pressure() {
		return c2_pressure;
	}



	public void setC2_pressure(double c2_pressure) {
		this.c2_pressure = c2_pressure;
	}



	public String getBlendPlan() {
		return blendPlan;
	}



	public void setBlendPlan(String blendPlan) {
		this.blendPlan = blendPlan;
	}
	
	
}
