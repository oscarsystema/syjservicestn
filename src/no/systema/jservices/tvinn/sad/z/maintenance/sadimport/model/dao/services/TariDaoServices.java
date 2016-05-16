package no.systema.jservices.tvinn.sad.z.maintenance.sadimport.model.dao.services;
import java.util.*;


/**
 * 
 * @author oscardelatorre
 * @date May 6, 2016
 * 
 */
public interface TariDaoServices extends IDaoServices { 
	public List findByAlfa(String alfa, StringBuffer errorStackTrace);
	public List findForUpdate(String id, String alfa, StringBuffer errorStackTrace);
	
}