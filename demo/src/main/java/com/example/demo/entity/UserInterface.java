/**
 * 
 */
package com.example.demo.entity;
import java.io.Serializable;

/**
 * @author denisputnam
 *
 */
public interface UserInterface extends Serializable{
	public long getId();
	public long setId(long value);
	public String getEMail();
	public void setEmail( String value );
	public String getName();
	public void setName(String value);

}