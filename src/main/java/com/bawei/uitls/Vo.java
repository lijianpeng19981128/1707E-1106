package com.bawei.uitls;
/**
 *  µÃÂ¿‡
 * @author ASUS
 *
 */

import com.bawei.domain.Movie;

public class Vo extends Movie{
   private String startTime;
   private String endTime;
   private Integer maxPrice;
   private Integer minPrice;
   private Integer maxtime;
   private Integer mintime;
   
   private String name;
   private String method;
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public Integer getMaxPrice() {
	return maxPrice;
}
public void setMaxPrice(Integer maxPrice) {
	this.maxPrice = maxPrice;
}
public Integer getMinPrice() {
	return minPrice;
}
public void setMinPrice(Integer minPrice) {
	this.minPrice = minPrice;
}
public Integer getMaxtime() {
	return maxtime;
}
public void setMaxtime(Integer maxtime) {
	this.maxtime = maxtime;
}
public Integer getMintime() {
	return mintime;
}
public void setMintime(Integer mintime) {
	this.mintime = mintime;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMethod() {
	return method;
}
public void setMethod(String method) {
	this.method = method;
}
   
   
}
